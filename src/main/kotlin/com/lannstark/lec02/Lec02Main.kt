package com.lannstark.lec02

fun main() {
//    val str: String? = "ABC"
    val str: String? = null
//    println(str.length)
    println(str?.length ?: 0)

    println(startWithA4("ABC"))

    val person = Person(null)
    println(startWithA(person.name))


}

fun startWithA(str: String): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException()
}

fun startWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException()

//    if (str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다")
//    }
//    return str.startsWith("A")
}

fun startWithA2(str: String?): Boolean? {
    return str?.startsWith("A")

//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")
}

fun startWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false

//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")
}

fun startWithA4(str: String?): Boolean {
    return str!!.startsWith("A")
}