package LetterReplacement

/*have the function LetterChanges(str) take the str parameter
being passed and modify it using the following algorithm.
Replace every letter in the string with the letter following
it in the alphabet (ie. c becomes d, z becomes a).
Then capitalize every vowel in this new string (a, e, i, o, u)
and finally return this modified string.
Hint:  ACSII character codes are in alphabetical order*/

fun letterChanged(str: String): String{
    var charArray = str.toCharArray()
    var newCharArrat: CharArray
    for (i in 1..charArray.size){


    }
    println(charArray.joinToString(""))
    return charArray.joinToString("")
}

fun main(args: Array<String>) {
    letterChanged("Heybuttzface")
}