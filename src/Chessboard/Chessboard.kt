package Chessboard

import java.io.InputStream

//model a chessboard.
var chessBoard = mutableListOf<BoardSquare>()
var currentTurn = "White"
//////////////////////////
fun main(args: Array<String>) {
    buildChessBoard()
    resetPieces()
    drawBoard(chessBoard)
    parseSquare("A1")
    parseSquare("C5")
    parseSquare("D7")
}
///////////////////////
class BoardSquare(val x: Int, val y: Int, var piece: String){
    fun printSquare(){

        if (piece != "none"){
            println("$x, $y  $piece")
        } else {
            println("$x, $y")
        }
    }

}


fun buildChessBoard(){
    for (y in 1..8){
        for (x in 1..8){
            val chessboardSquare = BoardSquare (x, y, "none")
            chessBoard.add(chessboardSquare)
        }
    }
}

fun resetPieces(){
    chessBoard[0].piece = "White Rook"
    chessBoard[1].piece = "White Knight"
    chessBoard[2].piece = "White Bishop"
    chessBoard[3].piece = "White Queen"
    chessBoard[4].piece = "White King"
    chessBoard[5].piece = "White Bishop"
    chessBoard[6].piece = "White Knight"
    chessBoard[7].piece = "White Rook"
    for (i in 8..15){
        chessBoard[i].piece = "White Pawn"
    }
    for (i in 48..56){
        chessBoard[i].piece = "Black Pawn"
    }
    val displace = 56
    chessBoard[0+displace].piece = "Black Rook"
    chessBoard[1+displace].piece = "Black Knight"
    chessBoard[2+displace].piece = "Black Bishop"
    chessBoard[3+displace].piece = "Black Queen"
    chessBoard[4+displace].piece = "Black King"
    chessBoard[5+displace].piece = "Black Bishop"
    chessBoard[6+displace].piece = "Black Knight"
    chessBoard[7+displace].piece = "Black Rook"



}


fun drawBoard(chessboard: MutableList<BoardSquare>){
    drawNotationLine()
    drawHorizontalLine()
    for(i in 1..8){
        var chessboardRow = mutableListOf<BoardSquare>()
        for (element in chessboard){
            if (element.y == i){
                chessboardRow.add(element)
            }
        }
        print(i)
        drawInnerHorizontalLine(chessboardRow)
        print(i)
        drawInnerHorizontalLine(chessboardRow)
        drawHorizontalLine()
        }

}
fun drawHorizontalLine(){
    for (i in 1..8) {
        if (i == 1){
            print(" ====")
        }
        print("=====")
    }
    println()
}
fun drawNotationLine(){
    println("   A    B    C    D    E    F    G    H  ")
}
fun drawInnerHorizontalLine(chessboardRow: MutableList<BoardSquare>){
    for (element in chessboardRow){
        when (element.piece){
            "none" -> print("=...=")
            "White Queen" -> print("=W.Q=")
            "White King" -> print("=W.K=")
            "White Rook" -> print("=W.R=")
            "White Bishop" -> print("=W.B=")
            "White Knight" -> print("=W.N=")
            "White Pawn" -> print("=W.P=")
            "Black Pawn" -> print("=B.P=")
            "Black Rook" -> print("=B.R=")
            "Black Knight" -> print("=B.N=")
            "Black Bishop" -> print("=B.B=")
            "Black Queen" -> print("=B.Q=")
            "Black King" -> print("=B.K=")
        }

    }
    print("=")
    println()
}
fun checkIfLegalMove(boardSquare: BoardSquare, moveTo: Int){
    when (boardSquare.piece){
        "none" -> println("invalid move")
        "White Pawn" -> if (moveTo){

        }
    }
}

fun parseSquare(notation: String): Int{
    val letter: String = notation.toCharArray().first().toString()
    val number: Int = notation.substring(1).toInt()
    var integerPosition = ((number-1)*8)
    when (letter){

        "B" -> integerPosition += 1
        "C" -> integerPosition += 2
        "D" -> integerPosition += 3
        "E" -> integerPosition += 4
        "F" -> integerPosition += 5
        "G" -> integerPosition += 6
        "H" -> integerPosition += 7
        else -> integerPosition += 0

    }
    return integerPosition
}
fun takeTurn(currentTurn: String){
    if (currentTurn == "White"){
        drawBoard(chessBoard)
        println("White Player, take your turn(format as A1B1): ")
        val input = readLine()!!
        val moveFrom = input.substring(0,1)
        val moveTo = input.substring(2, 3)
        val moveFromInt = parseSquare(moveFrom)
        val moveToInt = parseSquare(moveTo)


    }
}
