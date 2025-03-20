package question

import java.util.stream.IntStream

fun main() {
    q7(2)
//    println(q8(5))
//    println(q9(6, 4))
}

fun q7(n: Int) {
    var sum = 0
    val sb = StringBuilder()
    IntStream.rangeClosed(1, n).forEach {
        if (it != n) {
            sb.append("$it + ")
        } else {
            sb.append("$it = ")
        }
        sum += it
    }

    sb.append(sum)

    println(sb.toString())
}

fun q8(n: Int): Int {
    var sum = (1 + n) * (n / 2)
    if (n % 2 != 0) sum += n / 2 + 1

    return sum
}

fun q9(a: Int, b: Int): Int {
    var sum = 0
    if (a > b) {
        for (i in b..a) {
            sum += i
        }
    } else {
        for (i in a..b ) {
            sum += i
        }
    }
    return sum
}