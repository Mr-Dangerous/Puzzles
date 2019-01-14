package KnightDialer

import java.util.logging.Logger.global


fun determineValidJump(digit: Int): List<Int> {
    val validJumps = mutableListOf<Int>()
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
    return validJumps
}

fun knightDialer (digit: Int): Int {
    //takes in the digit then calculates how many jumps it will take until you cannot take anymore
    val closedSquares = mutableListOf(digit)
    var numberOfJumps = 0
    var position = digit
    while (true){
        val validJump = determineValidJump(position)
        if (validJump.isEmpty()){
            break
        }
        if (validJump.size == 2){
            position = if (!closedSquares.contains(validJump[0])){
                validJump[0]
            } else if (!closedSquares.contains(validJump[1])) {
                validJump[1]
            } else {
                break
            }
            closedSquares.add(position)
            numberOfJumps++
        }
        if (validJump.size == 3) {

            position = if (!closedSquares.contains(validJump[0])) {
                validJump[0]
            } else if (!closedSquares.contains(validJump[1])) {
                validJump[1]
            } else if (!closedSquares.contains(validJump[2])) {
                validJump[2]
            } else {
                break
            }
            closedSquares.add(position)
            numberOfJumps++
        }

    }
    println("If you start on $digit you can make $numberOfJumps jumps")
    return numberOfJumps
}


fun main(args: Array<String>) {

    /*
    Solution didn't work
    for (i in 0..9) {
        var counter: Int = 0
        val invalidJumpList = mutableListOf(i)
        val validJumps = determineValidJump(i)
        var position = i
        var canContinue = true
        while (canContinue) {
            for (j in 0..9) {
                if (validJumps.contains(j)) {
                    invalidJumpList.add(j)
                    position = j
                    counter++
                    break
                }
            }
            //need to make the break condition
            }
        }
        println("When starting at $i The knight can move $counter times around the phone at most")

    }
*/
    for (i in 0..9){
        val number = knightDialer(i)
        println("$number")
    }

}