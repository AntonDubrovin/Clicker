package com.example.clicker.upgrades

import com.example.clicker.MainActivity.Companion.player

@ExperimentalUnsignedTypes
data class UpgradeInc(val name_: String) {
    val name = name_
    var increment: ULong = 1U
    var level: ULong = 0U
    var cost: ULong = 15U
    var autoIncrement: ULong = 0U

    fun upgrade() {
        if (player.countClick >= cost) {
            player.countClick -= cost
            upgradeInc()
            upgradeAutoInc()

            level++
            cost *= 2U // TODO
        }
    }

    private fun upgradeInc() {
        player.inc += increment
        increment++// TODO
    }

    private fun upgradeAutoInc() {
        player.autoInc += autoIncrement
        autoIncrement++//TODO
    }
}