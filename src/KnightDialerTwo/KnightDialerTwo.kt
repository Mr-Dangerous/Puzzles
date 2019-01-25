package KnightDialerTwo


var phoneBoard = mutableListOf<PhoneSquare>()
var dialedNumbers = mutableListOf<List<PhoneSquare>>()

fun main(args: Array<String>) {
    buildPhoneBoard()
    for (element in phoneBoard){
        element.printPhoneDigit(element)
    }
}
class PhoneSquare (val x: Int, val y: Int, val num: Int){
    fun printPhoneDigit(phoneSquare: PhoneSquare){
        println("The digit is $num.  X = $x.  Y = $y.")
    }
}

fun buildPhoneBoard(){
    for (i in 1..3){
        for (j in 1..4){
            var num = 0
            when (j) {
                1 -> if (i == 2) {
                    num = 0
                } else {
                    num = 100
                }
                2 -> when (i){
                    1 -> num = 7
                    2 -> num = 8
                    3 -> num = 9
                }
                3 -> when (i){
                    1 -> num = 4
                    2 -> num = 5
                    3 -> num = 6
                }
                4 -> when (i){
                    1 -> num = 1
                    2 -> num = 2
                    3 -> num = 3
                }
            }
            if (num != 100) {
                val newPhoneSquare = PhoneSquare(i, j, num)
                phoneBoard.add(newPhoneSquare)
            }
        }
    }
}

fun dialNumber(phoneSquare: PhoneSquare, dialedNumbers: List<List<PhoneSquare>>){

}

fun checkForValidMov