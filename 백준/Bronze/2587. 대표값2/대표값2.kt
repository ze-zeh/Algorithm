import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numbers = Array(5) { br.readLine().toInt() }.sorted()
    var sum = 0
    numbers.forEach { sum += it }
    print("${sum / 5}\n${numbers[2]}")
}