val DAY = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31)
val DAY_OF_THE_WEEK = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")

fun main() {
    var (month, day) = readLine()!!.split(" ").map { it.toInt() }
    if (month > 1) {
        for (i in 0 until month - 1) {
            day += DAY[i]
        }
    }
    println(DAY_OF_THE_WEEK[day % 7])
}
