package com.example.clicker.player

@ExperimentalUnsignedTypes
data class Player(var countClick : ULong) {
    var inc: ULong = 1U
    var autoInc: ULong = 0U

    fun increment() {
        countClick += inc
    }
}