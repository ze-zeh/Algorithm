import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }.toHashSet()
    val b = br.readLine().split(" ").map { it.toInt() }.toHashSet()
    var count = 0
    a.forEach { if (b.contains(it)) count++ }
    bw.write("${n + m - count * 2}")
    bw.flush()
    bw.close()
}