import java.util.*

fun main() {
    data class Meeting(val start: Int, val end: Int)

    val n = readLine()!!.toInt()
    val meetings = mutableListOf<Meeting>()
    repeat(n) {
        val st = StringTokenizer(readLine())
        meetings.add(Meeting(st.nextToken().toInt(), st.nextToken().toInt()))
    }
    meetings.sortWith(compareBy({ it.end }, { it.start }))
    var count = 1
    var current = meetings[0].end
    for (i in 1 until n) {
        if (meetings[i].start >= current) {
            count++
            current = meetings[i].end
        }
    }
    print(count)
}
