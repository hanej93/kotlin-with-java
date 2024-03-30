package com.lannstark.lec12

fun main() {
//    Person.Companion.newBaby("ABC")
    Person.Factory.newBaby("ABC")
    Person.newBaby("ABC")

    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)

    moveSomething(object : Movable {
        override fun move() {
            println("무브무브")
        }

        override fun fly() {
            println("날다 날다")
        }
    })
}

class Person private constructor(
    var name: String,
    var age: Int,
) {
    companion object Factory : Log {
        private const val MIN_AGE = 1
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        // java에서 사용하려면 아래의 어노테이션
//        @JvmStatic
        override fun log() {
            println("나는 Person 클래스의 동행객체 Factory 에요")
        }
    }
}

object Singleton {
    var a: Int = 0
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}