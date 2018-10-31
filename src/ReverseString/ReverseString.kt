package ReverseString

/*have the function FirstReverse(str) take the str
parameter being passed and return the string in reversed
 order. For example: if the input string is
"Hello World and Coders" then your program should
return the string sredoC dna dlroW olleH.
 */

fun FirstReverse(str: String): String{
    var reversedWord = str.toCharArray()

    for (i in 0..(str.length-1)){
        reversedWord[i] = str[str.length - i - 1]
    }

    println(reversedWord.joinToString(""))
    return (reversedWord.joinToString(""))
}
//so it works but its still very odd.


fun SecondReverse(str: String): String{
    val reversedString = str.reversed()
    println(reversedString)
    return reversedString
}
//This is the proper way to do it in Kotlin.  I feel pretty happy that i basically just built
// a standard library function :)

fun main(args: Array<String>) {
    FirstReverse("Cretin I shall kill you")
    SecondReverse("Hi, may I help you?")
}
