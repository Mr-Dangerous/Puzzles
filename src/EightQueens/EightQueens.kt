package EightQueens

//Given a chessboard with 8 queens, make a function that will check to see if any of the
//queens can capture one another.  Return true if they can capture eachother
//false if they cannot
class ChessboardSquare (val xCoordinate: Int, val yCoordinate: Int)

fun buildChessBoard (): List<ChessboardSquare> {
    val chessboard = mutableListOf<ChessboardSquare>()
    for (i in 1..8){
        for (j in 1..8){
            val chessboardSquare = ChessboardSquare (i, j)
            chessboard.add(chessboardSquare)
        }
    }
    return chessboard
}
fun printChessBoard (chessBoard: List<ChessboardSquare>){
    for ((index) in chessBoard.withIndex()){
        val chessBoardSquare = chessBoard[index]
        val x = chessBoardSquare.xCoordinate
        val y = chessBoardSquare.yCoordinate
        println("[$x, $y]")
    }
}

//the purpose of this variable is to store a list of all squares that are
//currently being threatened by a different Queen.  If any queen is on one
//of these squares, the program will return false

var suppressedSquareBoard = mutableListOf<ChessboardSquare>()

fun eliminateSpaces (suppressedSquareList: List<ChessboardSquare>){
    for (element in suppressedSquareList){
        if (!suppressedSquareList.contains(element)){
            suppressedSquareBoard.add(element)
            val x = element.xCoordinate
            val y = element.yCoordinate
            println("added space$x, $y.")
        }
    }
}
//functions that add squares to a list of chessboard spaces that are checked against
fun eliminateHorizontalZone (chessboardSquare: ChessboardSquare){
    val suppressedHorizontalSquares = mutableListOf<ChessboardSquare>()
    val y = chessboardSquare.yCoordinate
    for (i in 1..8){
        if (chessboardSquare.xCoordinate != i){
            val suppressedSquare = ChessboardSquare(i, y)
            suppressedHorizontalSquares.add(suppressedSquare)
        }
    }
    eliminateSpaces(suppressedHorizontalSquares)
}
fun eliminateVerticalZone (chessboardSquare: ChessboardSquare){
    val suppressedVerticalSquares = mutableListOf<ChessboardSquare>()
    val x = chessboardSquare.xCoordinate
    for (i in 1..8){
        if (chessboardSquare.yCoordinate != i){
            val suppressedSquare = ChessboardSquare(x, i)
            suppressedVerticalSquares.add(suppressedSquare)
        }
    }
    eliminateSpaces(suppressedVerticalSquares)
}
fun eliminateUpRightZone (chessboardSquare: ChessboardSquare){
    var suppressedSquares = mutableListOf<ChessboardSquare>()
    var x = chessboardSquare.xCoordinate
    var y = chessboardSquare.yCoordinate
    while (x < 9 && y < 9 ){
        if (x != chessboardSquare.xCoordinate && y != chessboardSquare.yCoordinate){
            val suppresedSquare = ChessboardSquare(x, y)
            suppressedSquares.add(suppresedSquare)
            x++
            y++
        } else {
            x++
            y++
        }
    }
    eliminateSpaces(suppressedSquares)
}
fun eliminateUpLeftZone (chessboardSquare: ChessboardSquare){
    var suppressedSquares = mutableListOf<ChessboardSquare>()
    var x = chessboardSquare.xCoordinate
    var y = chessboardSquare.yCoordinate
    while (x > 9 && y < 0 ){
        if (x != chessboardSquare.xCoordinate && y != chessboardSquare.yCoordinate){
            val suppresedSquare = ChessboardSquare(x, y)
            suppressedSquares.add(suppresedSquare)
            x--
            y++
        } else {
            x--
            y++
        }
    }
    eliminateSpaces(suppressedSquares)
}
fun eliminateDownLeftZone(chessboardSquare: ChessboardSquare){
    var suppressedSquares = mutableListOf<ChessboardSquare>()
    var x = chessboardSquare.xCoordinate
    var y = chessboardSquare.yCoordinate
    while (x > 0 && y > 0 ){
        if (x != chessboardSquare.xCoordinate && y != chessboardSquare.yCoordinate){
            val suppresedSquare = ChessboardSquare(x, y)
            suppressedSquares.add(suppresedSquare)
            x--
            y--
        } else {
            x--
            y--
        }
    }
    eliminateSpaces(suppressedSquares)
}
fun eliminateDownRightZone(chessboardSquare: ChessboardSquare){
    var suppressedSquares = mutableListOf<ChessboardSquare>()
    var x = chessboardSquare.xCoordinate
    var y = chessboardSquare.yCoordinate
    while (x < 9 && y > 0 ){
        if (x != chessboardSquare.xCoordinate && y != chessboardSquare.yCoordinate){
            val suppresedSquare = ChessboardSquare(x, y)
            suppressedSquares.add(suppresedSquare)
            x++
            y--
        } else {
            x++
            y--
        }
    }
    eliminateSpaces(suppressedSquares)
}
fun eliminateAllSuppressedSquares(queenPlacementList: List<ChessboardSquare>){
    for (chessboardSquare in queenPlacementList) {
        eliminateHorizontalZone(chessboardSquare)
        eliminateVerticalZone(chessboardSquare)
        eliminateDownLeftZone(chessboardSquare)
        eliminateUpRightZone(chessboardSquare)
        eliminateDownRightZone(chessboardSquare)
        eliminateUpLeftZone(chessboardSquare)
    }
}

//functions the will check to see if the victory condition is met!  True = yes, false = no
fun checkForVictory(queenPlacementList: List<ChessboardSquare>, suppressedSquareList: List<ChessboardSquare>) {
    for (element in queenPlacementList) {
        if (suppressedSquareList.contains(element)) {
            println("The queens are threatening each other")
        } else {
            println("The queens are NOT threatening each other")
        }

    }
}


fun main(args: Array<String>) {

    val queenPlacementListFail = listOf<ChessboardSquare>(
            ChessboardSquare(1, 1),
            ChessboardSquare(3, 2),
            ChessboardSquare(3, 3),
            ChessboardSquare(4, 4),
            ChessboardSquare(5, 5),
            ChessboardSquare(6, 6),
            ChessboardSquare(7, 7),
            ChessboardSquare(8,8)
            )
    eliminateAllSuppressedSquares(queenPlacementListFail)
    checkForVictory(queenPlacementListFail, suppressedSquareBoard)
}