fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        var result = 0
        val applicants = mutableListOf<Pair<Int, Int>>()
        var max = Int.MAX_VALUE
        repeat(n) {
            val score = readLine()!!.split(" ").map { it.toInt() }
            applicants.add(Pair(score[0], score[1]))
        }
        applicants.sortBy { it.first }

        applicants.forEach {
            if (max > it.second) {
                max = it.second
                result++
            }
        }
        println(result)
    }
}