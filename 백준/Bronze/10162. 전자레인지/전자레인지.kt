fun main() {
    var t = readLine()!!.toInt()
    val buttons = arrayListOf(300, 60, 10)
    val counts = arrayListOf<Int>()
    if (t % 10 != 0) {
        print(-1)
        return
    }
    for (i in 0 until 3) {
        counts += t / buttons[i]
        t %= buttons[i]
    }
    counts.forEach { print("$it ") }
}
