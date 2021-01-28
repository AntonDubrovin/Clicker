package com.example.clicker.player

import com.example.clicker.upgrades.common.AbstractUpgrade

@ExperimentalUnsignedTypes
class Player {
    var countClick: ULong = 0U
    var inc: ULong = 1U
    var autoInc: ULong = 0U

    fun increment() {
        countClick += inc
    }
}