import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val arr = mutableListOf<Int>()

    for (i in 1..n) {
        if (n % i == 0) arr.add(i)
    }
    arr.sort()
    if (arr.size >= k) {
        print(arr[k - 1])
    } else {
        print(0)
    }
}