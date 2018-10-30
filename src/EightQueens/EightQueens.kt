package EightQueens

//Given a chessboard with 8 queens, make a function that will check to see if any of the
//queens can capture one another.  Return true if they can capture eachother
//false if they cannot
class ChessboardSquare (val xCoordinate: Int, val yCoordinate: Int)
//fun buildChessBoard (): List<ChessboardSquare> {
//    val chessboard = mutableListOf<ChessboardSquare>()
//    for (i in 1..8){
//        for (j in 1..8){
//            val chessboardSquare = ChessboardSquare (i, j)
//            chessboard.add(chessboardSquare)
//        }
//    }
//    return chessboard
//}

var suppressedSquareBoard = mutableListOf<ChessboardSquare>()

fun printChessBoard (chessBoard: List<ChessboardSquare>){
    for ((index) in chessBoard.withIndex()){
        val chessBoardSquare = chessBoard[index]
        val x = chessBoardSquare.xCoordinate
        val y = chessBoardSquare.yCoordinate
        println("[$x, $y]")
    }
}

fun eliminateSpaces (suppressedSquareList: List<ChessboardSquare>){
    for (element in suppressedSquareList){
        if (!suppressedSquareList.contains(element)){
            suppressedSquareBoard.add(element)
        }
    }
}

fun highlightHorizontalZone (chessboardSquare: ChessboardSquare){
    val suppressedSquares = mutableListOf<ChessboardSquare>()
    val y = chessboardSquare.yCoordinate
    for (i in 1..8){
        if (chessboardSquare.xCoordinate != i){
            val suppressedSquare = ChessboardSquare(i, y)
            suppressedSquares.add(suppressedSquare)
        }
    }
    eliminateSpaces(suppressedSquares)
}
fun highlightVerticalZone (chessboardSquare: ChessboardSquare){
    val suppressedSquares = mutableListOf<ChessboardSquare>()
    val x = chessboardSquare.xCoordinate
    for (i in 1..8){
        if (chessboardSquare.yCoordinate != i){
            val suppressedSquare = ChessboardSquare(x, i)
            suppressedSquares.add(suppressedSquare)
        }
    }
    eliminateSpaces(suppressedSquares)
}

//Pickup here!
fun highlightPositiveAngleZone (chessboardSquare: ChessboardSquare){
    val suppressedSquares = mutableListOf<ChessboardSquare>()
    val x = chessboardSquare.xCoordinate
    val y = chessboardSquare.yCoordinate
    for (i in 1..8){
        if (i != x && i != y){
            val newX = i
        }

    }
}
fun highlightNegativeAngleZone (){

}
fun highlightUpLeftZone (){

}
fun highlightDownLeftZone(){

}

fun main(args: Array<String>) {
    var chessBoard = buildChessBoard()
    printChessBoard(chessBoard)
}