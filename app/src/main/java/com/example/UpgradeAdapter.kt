package com.example

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clicker.R
import com.example.clicker.upgrades.UpgradeInc

@ExperimentalUnsignedTypes
class UpgradeAdapter(
    private val users: ArrayList<UpgradeInc>,
    private val onClick: (UpgradeInc) -> Unit,
) : RecyclerView.Adapter<UpgradeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpgradeViewHolder {

        val holder = UpgradeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.upgrade_item, parent, false)
        )

        holder.root.setOnClickListener {
            onClick(users[holder.adapterPosition])
        }

        return holder
    }

    override fun onBindViewHolder(holder: UpgradeViewHolder, position: Int) =
        holder.bind(users[position])

    override fun getItemCount() = users.size

}