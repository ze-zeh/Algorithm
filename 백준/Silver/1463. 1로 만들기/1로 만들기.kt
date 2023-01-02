import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val dp = Array(n + 1) { -1 }

    dp[0] = 0
    dp[1] = 0

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1)
        if (i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1)
    }

    bw.write("${dp[n]}\n")
    bw.flush()
    bw.close()
    br.close()
}