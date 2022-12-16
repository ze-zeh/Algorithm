import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()

    repeat(t) {
        val st = StringTokenizer(br.readLine())
        val first = Turret(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        val second = Turret(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        val distanceBetweenTwoTurrets = calcDistance(first, second)
        val sumOfDistanceToTarget = first.distanceToTarget + second.distanceToTarget
        val diffOfDistanceToTarget = abs(first.distanceToTarget - second.distanceToTarget)

        bw.write(
            when {
                distanceBetweenTwoTurrets == 0.0 && diffOfDistanceToTarget == 0 -> "-1"
                
                distanceBetweenTwoTurrets == (sumOfDistanceToTarget).toDouble() -> "1"
                
                distanceBetweenTwoTurrets < sumOfDistanceToTarget && (distanceBetweenTwoTurrets == diffOfDistanceToTarget.toDouble()) -> "1"

                distanceBetweenTwoTurrets > sumOfDistanceToTarget -> "0"
                
                distanceBetweenTwoTurrets < sumOfDistanceToTarget && (distanceBetweenTwoTurrets < diffOfDistanceToTarget) -> "0"
                distanceBetweenTwoTurrets == 0.0 && diffOfDistanceToTarget != 0 -> "0"
                
//                distanceBetweenTwoTurrets < sumOfDistanceToTarget && (distanceBetweenTwoTurrets > diffOfDistanceToTarget) -> "2"
                
                else -> "2"
            }
        )
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

fun power(num: Int): Int {
    return num * num
}

fun calcDistance(first: Turret, second: Turret): Double {
    return abs(sqrt((power(first.x - second.x) + power(first.y - second.y)).toDouble()))
}

data class Turret(val x: Int, val y: Int, val distanceToTarget: Int)