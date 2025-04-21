package question

fun main() {
//    println(q1(4))
//    println(q2(3, 6))
//    println(q2(5, 15))
    println(gcdArray(intArrayOf(12, 6, 9)))
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

// TODO 배열도 재귀 함수 방법으로 고민 필요
fun gcdArray(a: IntArray): Int {
    if (a.isEmpty()) return 0
    var result = a[0]
    for (i in 1..a.lastIndex) {
        result = gcd(result, a[i])
    }

    return result
}

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}