package KnightDialer

/* You know the knightdialer.  Now make an algorithim
that will calculate the amount of numbers possible

Thoughts:

There will be ten different trees of numbers, of which 8 can be mirrored, one can be assumed(5), one is unique (0)
Each branch will have some assumed moves.  for isntance

If starting at a corner(1), you can jump to one number(8), then be forced to jump to another number (3), then be
forced to jump to another number (5), then you could go to 0, or to.

There needs to be a make jump function that takes in the list of closed squares
 */

fun checkForValidJump(closedButtonsList: List<Int>): List<Int>{
    val validJumps = mutableListOf<Int>()

    val digit = closedButtonsList.last()
    when (digit) {
        0 -> {
            validJumps.add(4)
            validJumps.add(6)
        }
        1 -> {
            validJumps.add(6)
            validJumps.add(8)
        }
        2 -> {
            validJumps.add(7)
            validJumps.add(9)
        }
        3 -> {
            validJumps.add(4)
            validJumps.add(8)
        }
        4 -> {
            validJumps.add(3)
            validJumps.add(9)
            validJumps.add(0)
        }
        5 -> {

        }
        6 -> {
            validJumps.add(1)
            validJumps.add(7)
            validJumps.add(0)
        }
        7 -> {
            validJumps.add(2)
            validJumps.add(6)
        }
        8 -> {
            validJumps.add(1)
            validJumps.add(3)
        }
        9 -> {
            validJumps.add(2)
            validJumps.add(4)
        }

    }
    for (i in 0 until closedButtonsList.size){
        if (closedButtonsList.contains(i)){
            validJumps.remove(i)
        }
    }
    if (validJumps.isEmpty()) {
        validJumps.add(0, 10)
        println(validJumps)
    }
    return validJumps
}

fun makeJump (closedButtonsList: List<Int>) {

    for (i in 0..9) {
        var position = i

        while (closedButtonsList.isNotEmpty()) {

        }
    }
}

fun main(args: Array<String>) {
    val testDigit = listOf(0, 2, 4)
    val validJumps = checkForValidJump(testDigit)
    println(validJumps)
}

