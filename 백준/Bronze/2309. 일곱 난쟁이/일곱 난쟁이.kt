import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = mutableListOf<Int>()
    repeat(9) {
        arr.add(br.readLine().toInt())
    }
    arr.sort()

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (i == j) continue
            var sum = 0
            val result = mutableListOf<Int>()
            for (k in 0 until 9) {
                if (k != i && k != j) {
                    sum += arr[k]
                    result.add(arr[k])
                }
            }
            if (sum == 100) {
                result.forEach { println(it) }
                return
            }

        }
    }
}