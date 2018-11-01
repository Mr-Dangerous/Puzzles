package TimeConvert

fun timeConvert (time: Int): String{
    val hours = time/60
    val minutes = time%60

    return ("$hours:$minutes")
}

fun main(args: Array<String>) {
    println(timeConvert(63))
    println(timeConvert(52))
    println(timeConvert(1052))
}