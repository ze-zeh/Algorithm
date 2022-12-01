fun main() {
    var n = 1000 - readLine()!!.toInt()
    var result = 0
    val coins = arrayListOf(500, 100, 50, 10, 5, 1)
    
    for (coin in coins) {
        if (n / coin > 0) {
            result += n / coin
            n %= coin
        }
    }

    print(result)
}
