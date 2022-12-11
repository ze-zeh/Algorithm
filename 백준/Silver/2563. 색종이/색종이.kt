import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val paper = Array(100) { Array(100) { false } }
    var count = 0

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        for (i in 0 until 10) {
            for (j in 0 until 10) {
                paper[a + i][b + j] = true
            }
        }
    }
    paper.forEach { it.forEach { if (it) count++ } }

    print(count)
}