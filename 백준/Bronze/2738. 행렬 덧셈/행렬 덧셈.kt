import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val arr = Array(n) { IntArray(m) { 0 } }

    repeat(2) {
        for (i in 0 until n) {
            st = StringTokenizer(br.readLine())
            for (j in 0 until m) {
                arr[i][j] += st.nextToken().toInt()
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            sb.append("${arr[i][j]} ")
        }
        sb.append("\n")
    }
    print(sb)
}