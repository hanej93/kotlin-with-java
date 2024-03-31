package com.lannstark.lec19

import com.lannstark.lec19.a.printHelloWorld as printHelloWorldA
import com.lannstark.lec19.b.printHelloWorld as printHelloWorldB


fun main() {
    /**
     * as import
     */
    printHelloWorldA()
    printHelloWorldB()

    /**
     * 구조분해
     */
    val person = Person("한의진", 100)
    val (name, age) = person
//    val name = person.component1()
//    val age = person.component1()

    println("이름: $name , 나이: $age")

    val person2 = Person2("한의진", 100)
    val (name2, age2) = person2
    println("이름: $name2 , 나이: $age2")

    /**
     * Jump 와 Label
     */
    val numbers = listOf(1, 2, 3)
    run {
        numbers.forEach { number ->
            if (number == 3) {
//                break
                return@run
            }
            println(number)
        }
    }

    numbers.forEach { number ->
        if (number == 3) {
//                continue
            return@forEach
        }
        println(number)
    }

    loop@
    for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@loop
            }
            println("$i $j")
        }
    }

    /**
     * TakeIf 와 TakeUnless
     */

}


data class Person(
    val name: String,
    val age: Int
)

class Person2(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name
    }
    operator fun component2(): Int {
        return this.age
    }
}


/**
 * TakeIf 와 TakeUnless
 */
val number = 2

fun getNumberOrNull(): Int? {
    return if (number <= 0) {
        null
    } else {
        number
    }
}

fun getNumberOrNullV2(): Int? {
    return number.takeIf { it > 0}
}

fun getNumberOrNullV3(): Int? {
    return number.takeUnless { it <= 0}
}