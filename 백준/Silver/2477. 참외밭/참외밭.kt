import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
const val MAX_SIZE = 6

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val k = br.readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    var maxWidth = 0
    var maxHeight = 0
    var maxWidthIndex = 0
    var maxHeightIndex = 0

    repeat(6) { index ->
        val (direction, distance) = br.readLine().split(" ").map { it.toInt() }
        list.add(Pair(direction, distance))

        when (direction) {
            1, 2 -> {
                if (maxWidth < distance) {
                    maxWidth = distance
                    maxWidthIndex = index
                }
            }
            3, 4 -> {
                if (maxHeight < distance) {
                    maxHeight = distance
                    maxHeightIndex = index
                }
            }
        }
    }
    val smallArea = if ((maxWidthIndex + 1) % 6 == maxHeightIndex) {
        list[(maxHeightIndex + 2) % 6].second * list[(maxHeightIndex + 3) % 6].second
    } else {
        list[(maxWidthIndex + 2) % 6].second * list[(maxWidthIndex + 3) % 6].second
    }

    bw.write("${(maxWidth * maxHeight - smallArea) * k}")
    bw.flush()
    bw.close()
}