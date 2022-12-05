import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val cards = PriorityQueue<Int>()
    var result = 0

    repeat(n) {
        cards.add(readLine()!!.toInt())
    }

    while (cards.size > 1) {
        val a = cards.poll()
        val b = cards.poll()
        result += a + b
        cards.add(a + b)
    }

    print(result)
}