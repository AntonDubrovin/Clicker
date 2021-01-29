package com.example

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.clicker.upgrades.UpgradeInc
import kotlinx.android.synthetic.main.upgrade_item.view.*

@ExperimentalUnsignedTypes
class UpgradeViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
    fun bind(upgrade: UpgradeInc) {
        with(root) {
            name.text = upgrade.name
            level.text = upgrade.level.toString()
            cost.text = upgrade.cost.toString()
            increment.text = upgrade.increment.toString()
            auto_inc.text = upgrade.autoIncrement.toString()
        }
    }
}
