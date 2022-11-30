import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val a = mutableListOf<Int>()
    val b = mutableListOf<Int>()
    var result = 0

    var st = StringTokenizer(readLine())
    repeat(n) {
        a.add(st.nextToken().toInt())
    }

    st = StringTokenizer(readLine())
    repeat(n) {
        b.add(st.nextToken().toInt())
    }

    a.sort()
    b.sortDescending()
    
    repeat(n) {
        result += a[it] * b[it]
    }

    print(result)
}
