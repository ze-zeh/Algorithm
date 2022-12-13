import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = mutableListOf<Int>()
    repeat(n) {
        numbers.add(br.readLine().toInt())
    }

    println("${numbers.average().roundToInt()}")
    numbers.sort()
    println("${numbers[n / 2]}")
    val freq = numbers.groupingBy { it }.eachCount()
    val max = freq.filter { it.value == freq.maxOf { it.value } }.keys.sorted()
    val maxFreq = if(max.size == 1) {
        max.first()
    } else {
        max[1]
    }
    println("$maxFreq")
    println("${numbers.maxOf { it } - numbers.minOf { it }}")
}