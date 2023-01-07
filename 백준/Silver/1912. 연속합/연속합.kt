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
    val arr = mutableListOf<Int>()
    br.readLine().split(" ").map { it.toInt() }.forEach { arr.add(it) }
    dp[0] = arr[0]

    for (i in 1 until n) {
        dp[i] = max(arr[i], dp[i - 1] + arr[i])
    }

    bw.write("${dp.maxOrNull()}")
    bw.flush()
    bw.close()
    br.close()
}
