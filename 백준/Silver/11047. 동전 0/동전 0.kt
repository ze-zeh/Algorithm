import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    var k = st.nextToken().toInt()
    val coins = mutableListOf<Int>()
    var count = 0

    repeat(n) {
        coins.add(br.readLine().toInt())
    }

    coins.sortDescending()

    for (coin in coins) {
        val q = k / coin
        if (q > 0) {
            k %= coin
            count += q
        }
    }

    print(count)
}