import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    var num = 666
    while(true) {
        if(num.toString().contains("666")) {
            count++
            if(count == n) {
                print(num)
                break
            }
        }
        num++
    }
}