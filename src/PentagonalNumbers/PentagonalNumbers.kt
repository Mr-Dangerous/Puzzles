package PentagonalNumbers

fun calculatePentagonalNumbers (num: Int) : Int {
    var total = 0
    for (i in 0..num) {
        when (i) {
            1 -> total += 1
            0 -> { }
            else -> total += ((i-1) *5)
        }
    }
    print("$total, ")
    if (num % 10 == 0) {
        println()
    }
    return total
}

fun main(args: Array<String>) {
    for (i in 1..10000) {
        calculatePentagonalNumbers(i)
    }


}