package com.lannstark.lec16

fun main() {
    /**
     * 1. 확장함수
     */
    println("test".lastChar())

    val person = Person("A", "B", 20)
    // 멤버함수가 불린다.
    println(person.nextYearAge())

    val train: Train = Train()
    train.isExpensive() // Train의 확장함수

    val srt1: Train = Srt()
    srt1.isExpensive() // Train의 확장함수

    val srt2: Srt = Srt()
    srt2.isExpensive()  // Srt의 확장함수

    /**
     * 2.중위함수(infix 함수)
     */
    3.add(4)
    3.add2(4)
    3 add2 4

    /**
     * 3. inline 함수
     */
    3.add3(4)

    /**
     * 4. 지역함수
     */
}

fun String.lastChar(): Char {
    return this[this.length - 1]
}

fun Person.nextYearAge(): Int {
    println("확장함수")
    return this.age + 1
}

open class Train(
    val name: String = "새마을기차",
    val price: Int = 5_000
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10_000
}

class Srt: Train("SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("SRT의 확장함수")
    return this.price >= 10_000
}

/**
 * 2. 중위함수(infix)
 */

fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

/**
 * 3. inline 함수
 */
inline fun Int.add3(other: Int): Int {
    return this + other
}

/**
 * 4. 지역함수
 */
fun createPerson(firstName: String, lastName: String): Person {
    //    if (firstName.isEmpty()) {
//        throw IllegalArgumentException("firstName은 비어있을 수 없습니다! 현재 값: $firstName")
//    }
//
//    if (lastName.isEmpty()) {
//        throw IllegalArgumentException("lastName은 비어있을 수 없습니다! 현재 값: $lastName")
//    }
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("$fieldName 은 비어있을 수 없습니다! 현재 값: $name")
        }
    }

    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}