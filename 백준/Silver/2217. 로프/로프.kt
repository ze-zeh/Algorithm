import java.lang.Integer.max

fun main() {
    val n = readLine()!!.toInt()
    val ropes = mutableListOf<Int>()
    repeat(n) {
        ropes.add(readLine()!!.toInt())
    }
    ropes.sort()

    var max = 0
    for (i in 0 until n) {
        max = max(max, ropes[i] * (n - i))
    }

    print(max)
}
