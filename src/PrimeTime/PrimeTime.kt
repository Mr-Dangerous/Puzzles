package PrimeTime

/*Using the Java language, have the function PrimeTime(num) take
the num parameter being passed and return the string true if the
parameter is a prime number, otherwise return the string false... */

fun primeTime(num: Int):String {
    var primeTime = "false"

    for (i in 2 until num) {
        if (num % i == 0) {
            break
        } else {
            primeTime = "true"
        }
    }
    return primeTime + " $num"
}
//come back later to try and use this to find all prime numbers to a certain range.
fun iterateNumbers (){
    var primeNumbersList = listOf<Int>((1), (2))

}
fun main(args: Array<String>) {
    println(primeTime(10))
    println(primeTime(7))
    println(primeTime(1000213121))
    println(primeTime(13))
}