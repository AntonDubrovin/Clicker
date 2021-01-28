package com.example.clicker.upgrades.common

import com.example.clicker.player.Player

@ExperimentalUnsignedTypes
abstract class AbstractUpgrade(var player: Player) {
    abstract var level: ULong
    abstract var cost: ULong

    abstract fun upgrade()
}