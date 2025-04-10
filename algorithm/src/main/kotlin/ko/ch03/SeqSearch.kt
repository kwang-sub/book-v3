package ko.ch03

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println("요솟수: ")
    val num = br.readLine().toInt()
    val x = IntArray(num + 1)
    for (i in 0 until num) {
        print("x[$i]: ")
        x[i] = br.readLine().toInt()
    }
    println("검색할 값: ")
    val key = br.readLine().toInt()
    val findKey = seqSearchSen(x, num, key)
    if (findKey == -1) println("그 값의 요소가 없습니다.")
    else println("${key}는 x[$findKey]에 있습니다.")
}

fun seqSearch(a: IntArray, n: Int, key: Int): Int {
    for (i in 0 until n) {
        if (a[i] == key) return i
    }

    return -1
}

fun seqSearchSen(a: IntArray, n: Int, key: Int): Int {
    var i = 0
    a[n] = key
    while (true) {
        if (a[i] == key) break
        i++
    }
    return if (i == n) -1 else i
}