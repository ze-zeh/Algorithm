import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.sortedDescending()
    var day = 1
    var result = 0

    arr.forEach {
        day++
        result = max(day + it, result)
    }

    bw.write("$result")
    bw.flush()
    bw.close()
    br.close()
}
