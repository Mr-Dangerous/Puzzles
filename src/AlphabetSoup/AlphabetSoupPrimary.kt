package AlphabetSoup

/*Using the Java language, have the function AlphabetSoup(str)
take the str string parameter being passed and return the
string with the letters in alphabetical order (ie. hello becomes ehllo).
Assume numbers and punctuation symbols will not be included in the string.
 */

fun alphabetSoup(str: String):String {

    var chars = str.split("")
    var sorted = chars.sorted()
    var alphabetSoup = sorted.joinToString("")

    return alphabetSoup
}

fun main(args: Array<String>) {
    var pizza = alphabetSoup("pizza")
    println(pizza)

}