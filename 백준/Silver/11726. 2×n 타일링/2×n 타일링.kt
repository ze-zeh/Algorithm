import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = (dp[i - 1] % 10007 + dp[i - 2] % 10007) % 10007
    }

    bw.write("${dp[n]}")
    bw.flush()
    bw.close()
    br.close()
}