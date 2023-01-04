import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val dp = Array(1001) { -1L }
    dp[0] = 0L
    dp[1] = 1L
    dp[2] = 2L

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007L
    }

    bw.write("${dp[n] % 10007L}\n")
    bw.flush()
    bw.close()
    br.close()
}