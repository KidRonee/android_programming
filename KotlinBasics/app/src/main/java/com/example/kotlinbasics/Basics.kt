package com.example.kotlinbasics

var b = 10

fun main() {
    var mathias = Person("Mathias", "Brevik")
    testfunction()
    println("This is a test of this keyword: $b")
    b = 1
    println("This is the in-fun variable b: $b")



}

fun testfunction() {
    println(b)
}
class Person (firstName: String, lastName: String) {

    init {
        println("Person $firstName $lastName created")
    }
}