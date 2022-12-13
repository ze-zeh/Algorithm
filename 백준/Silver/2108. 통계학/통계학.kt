import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

fun getMedian(arr: IntArray, n: Int): Int {
    var median = 0
    var count = 0
    for (i in 0..8000) {
        count += arr[i]
        if (count > n / 2) {
            median = i - 4000
            break
        }
    }
    return median
}

fun getMode(arr: IntArray, maxCount: Int): Int {
    var mode = 0
    var count = 0

    arr.forEachIndexed { index, it ->
        if (maxCount == it) {
            mode = index
            count++
            if (count == 2) {
                return mode - 4000
            }
        }
    }

    return mode - 4000
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = IntArray(8001) { 0 }
    var sum = 0
    var max = -4000
    var min = 4000
    var maxCount = 0

    repeat(n) {
        val num = br.readLine().toInt()
        sum += num
        max = max(max, num)
        min = min(min, num)
        arr[num + 4000]++
        maxCount = max(maxCount, arr[num + 4000])
    }

    val average = (sum.toDouble() / n).roundToInt()
    println(average)
    println(getMedian(arr, n))
    println(getMode(arr, maxCount))
    println(max - min)
}