package com.lannstark.lec13


fun main() {

}

class House(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    // static inner class
    class LivingRoom(
        private val area: Double
    )

    // 권장되지 않는 방법
    inner class LivingRoomInner(
        private val area: Double
    ) {
        val address: String
            get() = this@House.address
    }
}