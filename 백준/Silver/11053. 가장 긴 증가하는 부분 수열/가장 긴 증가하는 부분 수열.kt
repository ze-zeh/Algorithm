import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = br.readLine().toInt()
    val dp = Array(n) { 0 }
    val arr = mutableListOf<Int>()
    var last = 0
    br.readLine().split(" ").map { it.toInt() }.forEach { arr.add(it) }

    for (i in arr.indices) {
        if (i == 0) {
            dp[last++] = arr[0]
            continue
        }

        if (dp[last - 1] > arr[i]) {
            dp[binarySearch(dp, 0, last - 1, arr[i])] = arr[i]
        } else if (dp[last - 1] < arr[i]) {
            dp[last++] = arr[i]
        }
    }

    bw.write("$last")
    bw.flush()
    bw.close()
    br.close()
}

fun binarySearch(arr: Array<Int>, l: Int, h: Int, num: Int): Int {
    var low = l
    var high = h
    var mid = 0

    while (low < high) {
        mid = (low + high) / 2

        if (arr[mid] < num) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return high
}
