package HourClockPuzzle

//Clock angle problem - given a time in HH:MM, calculate the small angle between the
//minute hand and the hour hand.
fun getAngle(hour: Int = 0, minute: Int = 0): Int{

    val newHour = if (hour == 12){
        0
    } else {
        hour
    }

    val hourPosition = newHour * 5
    var angle = (hourPosition - minute) * 6
    if (angle < 0) {
        angle *= -1
    }
    val inverseAngle = calculateInverseAngle(angle)
    if (inverseAngle < angle) {
        return inverseAngle
    } else {
        return angle
    }
}

fun calculateInverseAngle (angle: Int): Int{
    val inverseAngle = 360-angle
    return inverseAngle
}

fun main(args: Array<String>) {
    val angleTest = getAngle(12, 45)
    println(angleTest)
}


