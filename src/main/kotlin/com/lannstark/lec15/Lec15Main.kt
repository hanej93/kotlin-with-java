package com.lannstark.lec15

fun main() {

    /**
     * 배열
     */
    val array = arrayOf(100, 200)

    for (i in array.indices) {
        println("${i} : ${array[i]}")
    }

    val array2 = array.plus(300)

    for ((idx, value) in array2.withIndex()) {
        println("$idx : $value")
    }

    /**
     * 리스트(불변)
     */
    val numbers = listOf(100, 200)
    val emptyList = emptyList<Int>()
    
    // 타입을 추론을 가능하면 제네릭 생략가능
    printNumbers(emptyList())

    numbers.get(0)
    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    for ((idx, value) in numbers.withIndex()) {
        println("$idx : $value")
    }

    /**
     * 리스트(가변)
     */
    val numbers2 = mutableListOf(100, 200)
    numbers2.add(300)

    /**
     * 집합
     */
    val numbers3 = setOf(100, 200)
    val numbers4 = mutableSetOf(100, 200)


    /**
     * Map
     */
    val oldMap = mutableMapOf<Int, String>()
//    oldMap.put(1, "MONDAY")
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    val newMap = mapOf(1 to "MONDAY", 2 to "TUESDAY")
    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }
    for ((key, value) in oldMap.entries) {
        println("$key : $value")
    }

    /**
     * 컬렉션의 null 가능성
     */
}

private fun printNumbers(numbers: List<Int>) {

}