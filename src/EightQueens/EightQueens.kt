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

fun main(args: Array<String>) {
    var chessBoard = buildChessBoard()
    printChessBoard(chessBoard)
}