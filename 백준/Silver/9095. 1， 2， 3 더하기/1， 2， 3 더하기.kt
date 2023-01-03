import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    val dp = Array(11) { -1 }
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    repeat(t) {
        val n = br.readLine().toInt()

        for (i in 4..n) {
            if (dp[i] != -1) continue
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        }

        bw.write("${dp[n]}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}