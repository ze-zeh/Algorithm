import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var max = -1
    var n = -1
    var m = -1

    for (i in 0 until 9) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until 9) {
            val num = st.nextToken().toInt()
            if (num > max) {
                max = num
                n = i + 1
                m = j + 1
            }
        }
    }
    println(max)
    print("$n $m")
}