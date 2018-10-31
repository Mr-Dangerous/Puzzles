package LongestWord

/* Using the Java language, have the function LongestWord(sen)
take the sen parameter being passed and return the largest word
in the string. If there are two or more words that are the
same length, return the first word from the string with that length.
Ignore punctuation and assume sen will not be empty.
 */

fun longestWord(sentence: String){
    var sentenceArray = sentence.split(" ", "!", "@", "#", "$", ",", "!", "'")
    var longestWord = ""
    for (element in sentenceArray){
        if (element.length > longestWord.length){
            longestWord = element
        }
    }
    println(longestWord)
}

fun main(args: Array<String>) {
    longestWord("Hello, I'm a tool!")
}