package com.example.clicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.android.navigationadvancedsample.setupWithNavController
import com.example.clicker.player.Player
import com.example.clicker.upgrades.UpgradeInc
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ExperimentalUnsignedTypes
class MainActivity : AppCompatActivity() {
    private val countKey = "COUNT_KEY"
    private val upgradesKey = "UPGRADES_KEY"

    private var currentNavController: LiveData<NavController>? = null

    companion object {
        var player = Player(0U)
        lateinit var instance: MainActivity
        var upgradeList = (0..30).map {
            UpgradeInc("First upgrade #$it")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instance = this
        setupBottomNavigation()
        println(Gson().toJson(player))
        println(Gson().toJson(upgradeList))
        load()
    }

    override fun onDestroy() {
        super.onDestroy()
        save()
    }

    override fun onStop() {
        super.onStop()
        save()
    }

    override fun onPause() {
        super.onPause()
        save()
    }

    private fun save() {
        val editor = getPreferences(MODE_PRIVATE).edit()
        val json: String = Gson().toJson(player)
        editor.putString("MyObject", json)
        editor.putString(upgradesKey, Gson().toJson(upgradeList))
        editor.apply()
    }

    private fun load() {

        val json: String? = getPreferences(MODE_PRIVATE).getString("MyObject", "")
        val obj: Player? = Gson().fromJson(json, Player::class.java)

        if(obj != null){
            player = obj
        }

        val collectionList = object : TypeToken<ArrayList<UpgradeInc>>() {}.type
        val postsList: ArrayList<UpgradeInc>? =
            Gson().fromJson(getPreferences(MODE_PRIVATE).getString(upgradesKey, ""), collectionList)
        if (postsList != null) {
            upgradeList = postsList
        }




    }


    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navGraphIds = listOf(
            R.navigation.main_navigation,
            R.navigation.upgrades_navigation
        )
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.my_nav_host_fragment,
            intent = intent
        )
        currentNavController = controller
    }
}