import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Math.min
import kotlin.math.abs

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val arr = mutableListOf<Int>()
    if (m != 0) {
        br.readLine().split(" ").map { arr.add(it.toInt()) }
    }

    var result = abs(n - 100)

    for (i in 0 until 1_000_000) {
        val str = i.toString()
        var flag = false

        for (j in str) {
            if (arr.contains(j - '0')) {
                flag = true
                break
            }
        }

        if (flag) continue
        result = min(result, abs(n - i) + i.toString().length)
    }

    bw.write("$result")
    bw.flush()
    bw.close()
    br.close()
}
