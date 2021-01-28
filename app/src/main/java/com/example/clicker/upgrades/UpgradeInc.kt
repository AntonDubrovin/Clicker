package com.example.clicker.upgrades

import com.example.clicker.player.Player
import com.example.clicker.upgrades.common.AbstractUpgrade

@ExperimentalUnsignedTypes
class UpgradeInc(player_: Player) : AbstractUpgrade(player_) {
    var autoInc: ULong = 0U
    override var level: ULong = 0U
    override var cost: ULong = 15U

    override fun upgrade() {
        upgradeInc()
        level++
        cost *= 2U // TODO
    }

    private fun upgradeInc() {
        player.inc += 1U // TODO
    }
}