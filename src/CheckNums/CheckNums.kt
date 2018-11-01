package CheckNums

/* have the function CheckNums(num1,num2) take both parameters being passed
and return the string true if num2 is greater than num1, otherwise return the string false.
If the parameter values are equal to each other then return the string -1. */

fun checkNums (num1: Int, num2: Int): String{
    var returnValue = "false"
    if (num2 > num1)
        returnValue = "true"
    if (num1 == num2)
        returnValue = "-1"
    return returnValue
}

fun main(args: Array<String>) {
    println(checkNums(4, 5))
    println(checkNums(6, 3))
    println(checkNums(5,5))
}