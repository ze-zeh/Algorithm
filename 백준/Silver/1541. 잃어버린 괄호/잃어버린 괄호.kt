fun main() {
    val str = readLine()!!.split('-')
    var result = 0
    for (i in str.indices) {
        var sum = 0
        val a = str[i].split('+')
        for (b in a) sum += b.toInt()
        if (i == 0) result += sum else result -= sum
    }
    print(result)
}
