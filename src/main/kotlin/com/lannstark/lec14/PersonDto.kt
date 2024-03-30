package com.lannstark.lec14

fun main() {
    val dto1 = PersonDto("한의진", 100)
    val dto2 = PersonDto("한의진", 100)
    println(dto1 == dto2)
    print(dto1)
}

data class PersonDto(
    val name: String,
    val age: Int
)