package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.UpgradeAdapter
import com.example.clicker.MainActivity.Companion.upgradeList
import com.example.clicker.R
import com.example.clicker.upgrades.UpgradeInc
import kotlinx.android.synthetic.main.fragment_upgrades.view.*


@ExperimentalUnsignedTypes

class UpgradeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_upgrades, container, false)

        view.recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = UpgradeAdapter(upgradeList as ArrayList<UpgradeInc>) {
                it.upgrade()
                adapter?.notifyDataSetChanged()
            }
        }

        return view
    }

}