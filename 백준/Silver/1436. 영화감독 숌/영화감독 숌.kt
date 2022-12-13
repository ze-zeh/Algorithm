import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    var num = 665
    var temp: Int

    while (count != n) {
        temp = ++num
        while (temp >= 666) {
            if (temp % 1000 == 666) {
                count++
                break
            } else {
                temp /= 10
            }
        }
    }
    print(num)
}