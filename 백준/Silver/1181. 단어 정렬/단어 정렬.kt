import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    Array(br.readLine()!!.toInt()) { br.readLine()!! }
        .sortedWith(compareBy({ it.length }, { it }))
        .distinct()
        .forEach { bw.write("$it\n") }
    bw.flush()
    bw.close()
}