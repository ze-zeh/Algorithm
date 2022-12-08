fun main() {
    val n = readLine()!!.toInt()
    val input = arrayListOf<String>()
    repeat(n) { input.add(readLine()!!) }
    val cards = input.distinct()
    val result = cards.sortedWith(compareBy ({ it.length }, { it }))
    result.forEach { println(it) }
}