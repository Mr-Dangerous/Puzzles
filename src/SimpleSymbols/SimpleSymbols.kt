package SimpleSymbols

import com.sun.org.apache.xpath.internal.operations.Bool

/* have the function SimpleSymbols(str) take the str parameter
being passed and determine if it is an acceptable sequence by
either returning the string true or false. The str parameter
will be composed of + and = symbols with several letters between
them (ie. ++d+===+c++==a) and for the string to be true each
letter must be surrounded by a + symbol. So the string to the
left would be false. (because of the 'a' at the end)
The string will not be empty and will have at least one letter. */


fun simpleSymbol(str: String): Boolean{
    var returnValue = false
    var returnLock = false
    var conditionMet = false
    val charArray = str.toCharArray()
    for ((i) in charArray.withIndex()) {

        if (charArray.elementAt(i).isLetter() && (i > 0) && (i < charArray.size)) {
            if ((charArray.elementAt(i - 1) == '+') && (charArray.elementAt(i+1) == '+')) {
                conditionMet = true
            }
        }
        if (conditionMet && !returnLock){
            returnValue = true
        }
        if (!conditionMet && returnLock){
            returnValue = false
            returnLock = true
        } else {
            continue
        }
    }
    return returnValue
}

fun main(args: Array<String>) {
    println("The string follows the rules: " + simpleSymbol("==+a+======+b+=="))
    println("This string follows the rules: " + simpleSymbol("efde+====dfdf"))
}
