package com.example.clicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clicker.player.Player
import com.example.clicker.upgrades.UpgradeInc
import kotlinx.android.synthetic.main.activity_main.*

@ExperimentalUnsignedTypes
class MainActivity : AppCompatActivity() {
    private val countKey = "COUNT_KEY"
    private val player = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        load()
        current_clicks.setOnClickListener {
            player.increment()
            current_clicks.text = player.countClick.toString()
        }
        upgrade.setOnClickListener {
            val upgradeInc = UpgradeInc(player)
            if (player.countClick >= upgradeInc.cost) {
                player.countClick -= upgradeInc.cost
                upgradeInc.upgrade()
            }
        }
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
        editor.putLong(countKey, player.countClick.toLong())
        editor.apply()
    }

    private fun load() {
        val res = getPreferences(MODE_PRIVATE).getLong(countKey, 0)
        player.countClick = res.toULong()
        current_clicks.text = res.toString()
    }
}