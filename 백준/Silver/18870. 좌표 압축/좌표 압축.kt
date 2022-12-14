import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val sortedArr = arr.distinct().sorted()
    val hashMap = hashMapOf<Int, Int>()

    var idx = 0
    sortedArr.forEach {
        hashMap[it] = idx++
    }
    for (i in 0 until n) {
        bw.write("${hashMap.get(arr[i])} ")
    }

    bw.flush()
    bw.close()
}