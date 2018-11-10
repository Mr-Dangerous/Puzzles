package KnightDialer


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
            validJumps.add(8)
            validJumps.add(4)
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


fun main(args: Array<String>) {
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

}