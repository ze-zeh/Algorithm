import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val a = br.readLine().toLong()
    val b = br.readLine().toLong()
    val c = br.readLine().toLong()
    val number = (a * b * c).toString().map { Integer.parseInt(it.toString()) }.sorted()
    val arr = IntArray(10) { 0 }

    number.forEach { arr[it]++ }

    arr.forEach { bw.write("$it\n") }

    bw.flush()
    bw.close()
}