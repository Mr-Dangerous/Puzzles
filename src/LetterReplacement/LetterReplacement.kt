package LetterReplacement

/*have the function LetterChanges(str) take the str parameter
being passed and modify it using the following algorithm.
Replace every letter in the string with the letter following
it in the alphabet (ie. c becomes d, z becomes a).
Then capitalize every vowel in this new string (a, e, i, o, u)
and finally return this modified string.
Hint:  ACSII character codes are in alphabetical order*/

fun letterChanged(str: String): String {
    val charArray = str.toCharArray()
    for ((i, element) in charArray.withIndex()) {
        if (element == 'z') {
            charArray[i] = 'a'
        } else if (element.isLetter()) {
            charArray[i] = charArray.elementAt(i).toLowerCase().inc()
        }
    }
    for ((i, element) in charArray.withIndex()) {
        if (element == 'a' || element == 'e' || element == 'i' || element == 'o' || element == 'u') {
            charArray[i] = charArray.elementAt(i).toUpperCase()
        }
    }
    return charArray.joinToString("")
}

fun main(args: Array<String>) {
    println(letterChanged("Heybuttz face"))
}