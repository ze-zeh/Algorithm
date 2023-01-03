import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    val dp = Array(41) { Pair(-1, -1) }
    dp[0] = Pair(1, 0)
    dp[1] = Pair(0, 1)

    repeat(t) {
        val n = br.readLine().toInt()

        for (i in 2..n) {
            val zero = dp[i - 1].first + dp[i - 2].first
            val one = dp[i - 1].second + dp[i - 2].second
            dp[i] = Pair(zero, one)
        }

        bw.write("${dp[n].first} ${dp[n].second}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}