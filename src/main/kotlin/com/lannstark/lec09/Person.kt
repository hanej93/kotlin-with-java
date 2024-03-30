package com.lannstark.lec09

fun main() {
    val person = Person("한의진", 100)
    println(person.name)
    person.age = 10
    println(person.age)

    val person2 = Person()
}

class Person(
    val name: String,
    var age: Int
) {
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
        println("초기화 블록")
    }

    constructor(name: String): this(name, 1) {
        println("첫 번째 부생성자")
    }

    constructor() : this("홍길동") {
        println("두 번째 부생성자")
    }
}

// 부생성자는 거의 쓰지않음 Default Parameter로
class Person2(
    val name: String = "한의진",
    var age: Int = 1
) {
//    val name = name
//        get() = field.uppercase()
//
//    var age: Int = age
//        set(value) {
//            field = value + 1
//        }

//    fun getUppercaseName(): String =this.name.uppercase()

    val uppercaseName: String
        get() = this.name.uppercase()

    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
        println("초기화 블록")
    }

//    fun isAdult(): Boolean {
//        return this.age >= 20
//    }

    val isAdult: Boolean
        get() = this.age >= 20
}
