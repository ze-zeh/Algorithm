fun main() {
    var s = readLine()!!.toULong()
    var n = 0u
    while (n < s) s -= ++n
    print(n)
}