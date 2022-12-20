import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val cards = br.readLine().split(" ").map { it.toInt() }.sorted()
    val m = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }

    numbers.forEach { number ->
        bw.write(
            if (cards.binarySearch(number) >= 0) {
               "1"
            } else {
                "0"
            }
        )
        bw.write(" ")
    }

    bw.flush()
    bw.close()
}