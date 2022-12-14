import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val sb = StringBuilder()
    val arr = mutableListOf<Pair<Int, String>>()

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken()
        arr.add(Pair(x, y))
    }

    arr.sortWith(compareBy { it.first })

    arr.forEach {
        sb.append("${it.first} ${it.second}\n")
    }

    print(sb)
}