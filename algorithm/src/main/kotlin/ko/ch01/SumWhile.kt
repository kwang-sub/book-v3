package ko.ch01

import java.util.Scanner

fun main() {
    println(sumWhile(3))
    println(sumFor(3))
}

fun sumWhile(n: Int): Int {
    var result = 0
    var i = 1
    while (i <= n) {
        result += i
//        println(i)
        i++
    }
    return result
}

fun sumFor(n: Int): Int {
    var result = 0
    for (i in 1 .. n) {
        result += i
    }
    return result
}
