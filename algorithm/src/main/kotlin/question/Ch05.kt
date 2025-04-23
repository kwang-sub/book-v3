package question

import java.util.*

fun main() {
//    println(q1(4))
//    println(q2(3, 6))
//    println(q2(5, 15))
//    println(gcdArray(intArrayOf(12, 6, 9)))
//    println(gcdArrayV2(intArrayOf(12, 6, 3, 4), 0, 4))
    q5(1)
}

fun q1(n: Int): Int {
    if (n <= 1) return 1
    var result = 1
    for (i in 2..n) {
        result *= i
    }
    return result
}

fun q2(x: Int, y: Int): Int {
    var a = if (x > y) x else y
    var b = if (x > y) y else x

    while (b != 0) {
        val temp = a
        a = b
        b = temp % b
    }

    return a
}

fun gcdArray(a: IntArray): Int {
    if (a.isEmpty()) return 0
    var result = a[0]
    for (i in 1..a.lastIndex) {
        result = gcd(result, a[i])
    }

    return result
}

fun gcdArrayV2(a: IntArray, idx: Int, size: Int): Int {
    if (size == 1) return a[0]
    else if (size == 2) return gcd(a[idx], a[idx + 1])
    else return gcd(a[idx], gcdArrayV2(a, idx + 1, size - 1))

}

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}

fun q5(n: Int) {
    var a = n
    var ptr = -1
    var s = 0
    val nStk = IntArray(1000)
    val sStk = IntArray(1000)

    while (true) {
        if (a > 0) {
            nStk[++ptr] = a
            sStk[ptr] = s
            if (s == 0) a -= 1
            else if (s == 1) {
                a = a - 2
                s = 0
            }
            continue
        }
        do {
            a = nStk[ptr]
            s = sStk[ptr--] + 1
            if (s == 2) {
                println(a)
                if (ptr < 0) return
            }
        } while (s == 2)
    }
}

