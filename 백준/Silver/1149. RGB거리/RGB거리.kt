import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

const val RED = 0
const val GREEN = 1
const val BLUE = 2

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = br.readLine().toInt()
    val dp = Array(n) { IntArray(3) {0} }
    val cost = Array(n) { IntArray(3) { 0 } }

    repeat(n) { i ->
        cost[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    dp[0][RED] = cost[0][RED]
    dp[0][GREEN] = cost[0][GREEN]
    dp[0][BLUE] = cost[0][BLUE]

    for (i in 1 until n) {
        dp[i][RED] += cost[i][RED] + min(dp[i - 1][GREEN], dp[i - 1][BLUE])
        dp[i][GREEN] += cost[i][GREEN] + min(dp[i - 1][RED], dp[i - 1][BLUE])
        dp[i][BLUE] += cost[i][BLUE] + min(dp[i - 1][RED], dp[i - 1][GREEN])
    }

    bw.write("${minOf(dp[n - 1][RED], dp[n - 1][GREEN], dp[n - 1][BLUE])}")
    bw.flush()
    bw.close()
    br.close()
}
