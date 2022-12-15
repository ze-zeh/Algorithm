import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val t = st.nextToken().toInt()

    repeat(t) {
        st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val result = factorial(m) / (factorial(n) * factorial(m-n))

        bw.write("$result\n")
    }

    bw.flush()
    bw.close()
}

fun factorial(n: Int): BigInteger = if (n == 1 || n == 0) BigInteger.valueOf(1) else BigInteger.valueOf(n.toLong()) * factorial(n - 1)