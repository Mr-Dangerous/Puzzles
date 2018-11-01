package LetterCapitalize

/* have the function LetterCapitalize(str) take the str parameter being passed and
capitalize the first letter of each word. Words will be separated by only one space.*/

fun LetterCapitalize (str: String) {
    var charArray = str.toCharArray()
    for ((i) in charArray.withIndex()) {
        if (i == 0) {
            charArray[i] = charArray.elementAt(0).toUpperCase()
        } else if (charArray.elementAt(i).isWhitespace() && i != charArray.size)
            charArray[i+1] = charArray.elementAt(i+1).toUpperCase()
    }
    println(charArray.joinToString(""))
}

fun main(args: Array<String>) {
    LetterCapitalize("hello world")
}