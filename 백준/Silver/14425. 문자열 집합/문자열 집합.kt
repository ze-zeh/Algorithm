import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val s = HashSet<String>()
    var count = 0

    repeat(n) {
        s.add(br.readLine())
    }

    repeat(m) {
        if (s.contains(br.readLine())) count++
    }

    bw.write("$count")
    bw.flush()
    bw.close()
    br.close()
}
