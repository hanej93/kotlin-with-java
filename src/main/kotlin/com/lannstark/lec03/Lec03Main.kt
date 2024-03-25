package com.lannstark.lec03

fun main() {
    val number1 = 3
    val number2: Long = number1.toLong()

    val number3: Int? = 3
    val number4: Long = number3?.toLong() ?: 0L

    val person = Person("한의진", 100)
    println("name = ${person.name}, age = ${person.age}, number = $number1")

    val str = """
        ABCD
        EFG
        ${person.name}
    """.trimIndent()
    println(str)

    val str2 = "ABCDE"
    println(str2[0])
    println(str2[2])
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
//        val person = obj as Person
//        println(person.age)

        println(obj.age)
    }
}

fun printAgeIfPerson2(obj: Any?) {
    val person = obj as? Person
    println(person?.age)
}