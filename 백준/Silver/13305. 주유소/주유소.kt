import java.math.BigInteger
import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val distance = mutableListOf<BigInteger>()
    val price = mutableListOf<BigInteger>()
    var result = BigInteger("0")
    var minPrice = BigInteger("100000000000000000000000000")

    var st = StringTokenizer(readLine())
    repeat(n - 1) {
        distance.add(BigInteger(st.nextToken()))
    }

    st = StringTokenizer(readLine())
    repeat(n - 1) {
        price.add(BigInteger(st.nextToken()))
    }

    for (i in 0 until n - 1) {
        if (minPrice > price[i]) minPrice = price[i]
        result += minPrice * distance[i]
    }
    print(result)
}
