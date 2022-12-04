fun main() {
    val s = readLine()!!
    val start = s[0]
    var before = s[0]
    var result = 0
    s.forEach {
        if (it != before && it != start) result++
        before = it
    }
    print(result)
}