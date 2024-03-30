package com.lannstark.lec10

interface Swimmable {

    val swimAbility: Int
        get() = 3
    
    fun act() {
        println(swimAbility)
        println("파닥 파닥")
    }
}