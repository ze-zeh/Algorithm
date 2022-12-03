import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine()!!.map { it }.sortedDescending()
    var sum = 0
    for (num in n) sum += num.digitToInt()
    if (!n.contains('0') || sum % 3 != 0) {
        print(-1)
    } else {
        for (num in n) bw.write("$num")
    }
    bw.flush()
    bw.close()
}