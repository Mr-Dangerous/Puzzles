package FirstFactorial

/*have the function FirstFactorial(num) take the num parameter being passed
 and return the factorial of it (e.g. if num = 4, return (4 * 3 * 2 * 1)).
For the test cases, the range will be between 1 and 18 and the input
will always be an integer.  */

fun FirstFactorial(num: Int): Long {
    var runningProduct: Long = 1
    for (i in 1..num){
        runningProduct *= i
    }
    return runningProduct
}

fun main(args: Array<String>) {
    var num = FirstFactorial(21)
    println(num)
}

//comments - This solution, while it works, isn't the best.
//Need to study recursive functions!
