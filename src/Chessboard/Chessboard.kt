package Chessboard

import EightQueens.ChessboardSquare
import java.io.InputStream

//model a chessboard


var chessBoard = mutableListOf<BoardSquare>()
var currentTurn = "White"
val validRows = listOf("A", "B", "C", "D", "E", "F", "G", "H")
val validColumns = listOf(1, 2, 3, 4, 5, 6, 7, 8)
val quadrantOne = mutableListOf<Int>()
val quadrantTwo = mutableListOf<Int>()
val quadrantThree = mutableListOf<Int>()
val quadrantFour = mutableListOf<Int>()
//////////////////////////
fun main(args: Array<String>) {
    buildChessBoard()
    resetPieces()
    drawBoard(chessBoard)
    drawBoard(chessBoard)
    println(quadrantOne)
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
            val quadrant = determineQuadrant(chessboardSquare)
            val integerPosition = parseSquareFromObject(chessboardSquare)
            when (quadrant){
                1 -> quadrantOne.add(integerPosition)
                2 -> quadrantTwo.add(integerPosition)
                3 -> quadrantThree.add(integerPosition)
                4 -> quadrantFour.add(integerPosition)
                else -> println("error!")
            }
        }
    }
}

fun resetPieces(){
    for (element in chessBoard){
        element.piece = "none"
    }
    chessBoard[0].piece = "Black Rook"
    chessBoard[1].piece = "Black Knight"
    chessBoard[2].piece = "Black Bishop"
    chessBoard[3].piece = "Black Queen"
    chessBoard[4].piece = "Black King"
    chessBoard[5].piece = "Black Bishop"
    chessBoard[6].piece = "Black Knight"
    chessBoard[7].piece = "Black Rook"
    for (i in 8..15){
        chessBoard[i].piece = "Black Pawn"
    }
    for (i in 48..55){
        chessBoard[i].piece = "White Pawn"
    }
    val displace = 56
    chessBoard[0+displace].piece = "White Rook"
    chessBoard[1+displace].piece = "White Knight"
    chessBoard[2+displace].piece = "White Bishop"
    chessBoard[3+displace].piece = "White Queen"
    chessBoard[4+displace].piece = "White King"
    chessBoard[5+displace].piece = "White Bishop"
    chessBoard[6+displace].piece = "White Knight"
    chessBoard[7+displace].piece = "White Rook"
}

//
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
        print(9-i)
        drawInnerHorizontalLine(chessboardRow)
        print(9-i)
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

fun parseSquareFromString(notation: String): Int{
    val letter: String = notation.toCharArray().first().toString()
    val number: Int = notation.substring(1).toInt()
    var integerPosition = ((number-1)*8)
    integerPosition += when (letter){

        "B" -> 1
        "C" -> 2
        "D" -> 3
        "E" -> 4
        "F" -> 5
        "G" -> 6
        "H" -> 7
        else -> 0

    }
    return integerPosition
}

fun parseSquareFromObject(boardSquare: BoardSquare):Int {
    val x = boardSquare.x
    val y = boardSquare.y
    val integerPosition = (((y-1)*8)+(x-1))
    return integerPosition
}

fun moveBlackPawn(moveFrom: BoardSquare, moveTo: BoardSquare){
    val pieceType = moveFrom.piece
    val startingPosition = parseSquareFromObject(moveFrom)
    val endingPosition = parseSquareFromObject(moveTo)
    if (pieceType == "Black Pawn"){
        //straight move
        if (startingPosition +8 == endingPosition && moveTo.piece == "none") {
            chessBoard[startingPosition].piece = "none"
            chessBoard[endingPosition].piece = "Black Pawn"
        }
        //left diagonal capture
        if (startingPosition +7 == endingPosition && moveTo.piece != "none"){
            chessBoard[startingPosition].piece = "none"
            chessBoard[endingPosition].piece = "Black Pawn"
        }
        //right diagonal capture
        if (startingPosition +9 == endingPosition && moveTo.piece != "none"){
            chessBoard[startingPosition].piece = "none"
            chessBoard[endingPosition].piece = "Black Pawn"
        }
        //double move
        if (startingPosition + 16 == endingPosition && moveTo.piece == "none") {
            val intercedingSquare = startingPosition + 8
            if (chessBoard[intercedingSquare].piece == "none") {
                chessBoard[startingPosition].piece = "none"
                chessBoard[endingPosition].piece = "Black Pawn"
            }
        }

    }
    if (endingPosition in 56..63){
        //Queen me!
    }
}
fun moveBlackKnight(moveFrom: BoardSquare, moveTo: BoardSquare){
    val startingPosition = parseSquareFromObject(moveFrom)
    val endingPosition = parseSquareFromObject(moveTo)
    //determine legality
    val quadrant = determineQuadrant(moveFrom)
    //val outOfBounds = determineOutOfBoundsSquares(moveFrom)
}

fun determineOutOfBoundsSquares(boardSquare: BoardSquare): List<Int>{
    val outOfBoundsSquares = mutableListOf<Int>()
    val piece = boardSquare.piece
    val quadrant = determineQuadrant(boardSquare)
    if (piece == "White Knight" || piece == "Black Knight"){


    }
    return outOfBoundsSquares
}
fun determineQuadrant(boardSquare: BoardSquare): Int{
    var quadrant = 0
    if (boardSquare.x in 1..4 && boardSquare.y in 1..4){
        //Top left quadrant
        quadrant = 1
    }
    if (boardSquare.x in 5..8 && boardSquare.y in 1..4){
        //Top right
        quadrant = 2
    }
    if (boardSquare.x in 1..4 && boardSquare.y in 5..8){
        //Bottom left
        quadrant = 3
    }
    if (boardSquare.x in 5..8 && boardSquare.y in 5..8){
        //Bottom Right
        quadrant = 4
    }
    return quadrant
}
fun checkInput(string: String): String{
    val firstLetter = string.substring(0)
    val secondLetter = string.substring(1).toInt()
    val thirdLetter = string.substring(2)
    val fourthLetter = string.substring(3).toInt()

    return if (validRows.contains(firstLetter) &&
            validRows.contains(thirdLetter) &&
            validColumns.contains(secondLetter) &&
            validColumns.contains(fourthLetter)){
        "Good Input"
    } else {
        "Bad Input"
    }

}


