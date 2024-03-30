package com.lannstark.lec08

fun main() {
    repeat("Hello world", 3, true)
    repeat("Hello world", 2)
    repeat("Hello world")
    repeat("Hello world", useNewLine = false)

    printNameAndGender(name = "한의진", gender = "male")

    printAll("A", "B", "C")
    val array = arrayOf("A", "B", "C")
    printAll(*array)
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            println(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

fun printAll(vararg strings: String) {
    for (string in strings) {
        println(string)
    }
}