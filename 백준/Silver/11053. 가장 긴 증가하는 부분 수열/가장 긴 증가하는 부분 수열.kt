import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.max

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 0 }
    val arr = mutableListOf<Int>()
    arr.add(0)
    br.readLine().split(" ").map { it.toInt() }.forEach { arr.add(it) }

    for (i in 1..n) {
        var max = 0
        for (j in 0 until i) {
            if (arr[i] > arr[j]) {
                max = max(dp[j], max)
            }
        }
        dp[i] = max + 1
    }

    bw.write("${dp.maxOrNull()}")
    bw.flush()
    bw.close()
    br.close()
}
