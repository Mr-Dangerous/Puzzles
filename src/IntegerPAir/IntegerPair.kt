package IntegerPAir

import kotlin.system.measureTimeMillis

/* given an array of integers in order, can you find if there is a pair in the array that when added
equal target number?  https://www.reddit.com/r/learnprogramming/comments/9vp1vv/an_interesting_problem_from_a_job_interview_at/

 */

/*
My first inclination is that I can bruteforce this one.,  But more efficent solutions exist.

First, I could eliminate numbers from the array that are greater than the target number.

In addition, I can eliminate a number if it doesn't work with another number, thereby lowering the
size of the array to work with.

I could also take the number closest to the target number, then subtract that number fromn the target number, adn then
check to see if the list contains that.  I like that


 */

//bruteforce
fun integerPair1 (listOfNumbers: List<Int>, targetNumber: Int){
    var calculations = 0
    for (i in 1 until listOfNumbers.size){
        for (j in 1 until listOfNumbers.size){
            val X = listOfNumbers.get(i)
            val Y = listOfNumbers[j]
            if (X + Y == targetNumber && X != Y){
                println("If you add $X and $Y together, you get $targetNumber.")
                calculations ++
            } else {
                println("$X + $Y  =" +  (X + Y))
                calculations ++
            }
        }
    }
    println("Took $calculations calculations")
}

fun integerPair2 (listOfNumbers: List<Int>, targetNumber: Int){
    measureTimeMillis {
        var calculations = 0
        var closestNumber = 0
        var closestNumberPosition = 0
        for (i in 1 until listOfNumbers.size) {
            if (listOfNumbers[i] < targetNumber) {
                closestNumber = listOfNumbers[i]
                closestNumberPosition = i
                calculations++
            }
        }
        var differenceNumber = targetNumber - closestNumber
        var negativeIterator = 0
        for (i in 1 until closestNumberPosition)
            if (listOfNumbers.contains(differenceNumber)) {
                println("$differenceNumber + $closestNumber = $targetNumber")
                break
            } else {
                negativeIterator -= 1
                closestNumber = listOfNumbers[closestNumberPosition + negativeIterator]
                calculations++
            }
        println("Took $calculations calculations")
    }


}

fun main(args: Array<String>) {
    val listOfNumbersToTest = listOf(1, 5, 8, 9, 12, 18, 19 ,22, 33, 45, 56, 57, 58, 59, 60, 70, 110, 169)
    val targetNumber = 170

    val integerPair1Time = measureTimeMillis { integerPair1(listOfNumbersToTest, targetNumber) }
    println("took $integerPair1Time to code")
    val integerPair2Time = measureTimeMillis { integerPair2(listOfNumbersToTest, targetNumber) }
    println("took $integerPair2Time to code")
}