import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val time = mutableListOf<Int>()
    var sum = 0

    repeat(n) {
        time.add(st.nextToken().toInt())
    }
    time.sort()
    for (i in 0 until n) {
        sum += time[i] * (n - i)
    }
    print(sum)
}
