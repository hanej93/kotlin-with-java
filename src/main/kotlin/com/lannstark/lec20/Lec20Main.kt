package com.lannstark.lec20

import java.time.Period

fun main() {

    /**
     * scope function의 분류
     */
    // it 사용, this 사용(확장함수)
    // let,     run, : 람다의 결과
    // also,    apply, : 객체 그 자체

    //          with

    /**
     *  let 사용 예시
     */
    // 1)
    val strings = listOf("APPLE", "CAR")
    strings.map { it.length }
        .filter { it > 3 }
//        .let { lengths -> println(lengths) }
        .let(::println)

    // 2) non-null 값에 대해서만 code block을 실행시킬 때
    val str = "ABC"
    val length = str?.let {
        println(it.uppercase())
        it.length
    }

    // 3) 일회성으로 제한된 영역에 지역 변수를 만들 때
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem ->
            if (firstItem.length >= 5) firstItem else "!$firstItem!"
        }.uppercase()
    println(modifiedFirstItem)

    /**
     * run 사용 예시
     */
    // 1) 객체를 만들어 DB에 바로 저장하고, 그 인스턴스를 활용할 때
//    val person = Person("한의진", 100).run(personRepository::save)

//    val person = Person("한의진", 100).run {
//        hobby = "독서"
//        personRepository.save(this)
//    }

//    val person = personRepository.save(Person("한의진", 100))

    /**
     * apply 사용 예시
     */
    // 1) 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 때
    fun createPerson(
        name: String,
        age: Int,
        hobby: String,
    ) : Person {
        return Person(
            name = name,
            age = age
        ).apply {
            this.hobby = hobby
        }
    }

    val person = Person("한의진", 100)
    person.apply { this.growOld() }
        .let { println(it) }

    /**
     * also 사용 예시
     */
//    1) 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 때
    mutableListOf("one", "two", "three")
        .also { println("four 추가 이전 지금 값: $it") }
        .add("four")

    val numbers2 = mutableListOf("one", "two", "three")
    println("four 추가 이전 지금 값: $numbers2")
    numbers2.add("four")

    /**
     * with 사용 예시
     */
    // 1) 특정 객체를 다른 객체로 변환해야 하는데, 모듈 간의 의존성에 의해 정적 팩토리 혹은 toClass 함수를 만들기 어려울 때
    val personDto = with(person) {
        PersonDto(
            name = name,
            age = age
        )
    }

    /**
     * 4. scope function 과 가독성
     */
    // 1번 코드
//    if (person != null && person.isAdult) {
//        view.showPerson(person)
//    } else {
//        view.showError()
//    }

    // 2번 kotlin style
//    person?.takeIf { it.isAdult }
//        ?.let(view::showPerson)
//        ?: view.showError

    // 1번 코드가 더 좋은 것 아닌가..?
    // 구현 1의 디버깅이 더 쉽다.
    // 구현 1이 수정도 더 쉽다.

    // 적절한 convention을 적용하면 유용하게 활용할 수 있다.
}

data class PersonDto(
    val name: String,
    val age: Int
)

fun printPerson(person: Person?) {
//    if (person != null) {
//        println(person.name)
//        println(person.age)
//    }
    person?.let {
        println(person.name)
        println(person.age)
    }
}

class Person(
    val name: String,
    val age: Int,
) {
    var hobby: String = ""

    val isAdult: Boolean
        get() =  this.age >= 20

    fun growOld() {
        
    }
}