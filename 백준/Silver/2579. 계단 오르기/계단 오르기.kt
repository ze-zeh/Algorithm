import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.max

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = br.readLine().toInt()
    val dp = Array(n) { 0 }
    val arr = IntArray(n) { br.readLine().toInt() }

    dp[0] = arr[0]
    if (n >= 2) {
        dp[1] = arr[0] + arr[1]
        if (n >= 3) {
            dp[2] = max(arr[0] + arr[2], arr[1] + arr[2])

            for (i in 3 until n) {
                dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i])
            }
        }
    }

    bw.write("${dp[n - 1]}")
    bw.flush()
    bw.close()
    br.close()
}