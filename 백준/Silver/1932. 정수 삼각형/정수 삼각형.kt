import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.max

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = br.readLine().toInt()
    val score = Array(n) { IntArray(n) { 0 } }
    val dp = Array(n) { IntArray(n) { 0 } }

    repeat(n) { i ->
        score[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    dp[0][0] = score[0][0]

    for (i in 1 until n) {
        for (j in 0 until score[i].size) {
            dp[i][j] = score[i][j] + when (j) {
                0 -> dp[i - 1][j]
                score[i].size - 1 -> dp[i - 1][j - 1]
                else -> max(dp[i - 1][j - 1], dp[i - 1][j])
            }
        }
    }

    bw.write("${(dp[dp.lastIndex]).max()}")
    bw.flush()
    bw.close()
    br.close()
}
