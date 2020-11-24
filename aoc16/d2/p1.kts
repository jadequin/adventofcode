import java.io.File

val input = File("input.txt")
val instructionLines = input.readLines()

/*
Solution with a bit grid inside of an integer:

     0  1  2  3  4
     5  6  7  8  9
     10 11 12 13 14
     15 16 17 18 19
     20 21 22 23 24

     Bits in the middle (the keypad) are flagged with 1 and the borders with 0:

     0  0  0  0  0
     0  1  1  1  0
     0  1  1  1  0
     0  1  1  1  0
     0  0  0  0  0

 */

val keypad = 0b00000_01110_01110_01110_00000
var pos = 1 shl 12

val code = instructionLines.map {
    val finalDigit = it.toCharArray().fold(pos) {
        currentPos, direction ->
        print("Current pos: $currentPos, Direction: $direction\n")

        return@fold when(direction) {
            'L' -> if(((currentPos shr 1) and keypad) != 0) ((currentPos shr 1) and keypad) else currentPos
            'R' -> if(((currentPos shl 1) and keypad) != 0) ((currentPos shl 1) and keypad) else currentPos
            'U' -> if(((currentPos shr 5) and keypad) != 0) ((currentPos shr 5) and keypad) else currentPos
            else -> if(((currentPos shl 5) and keypad) != 0) ((currentPos shl 5) and keypad) else currentPos
        }
    }
    pos = finalDigit
    arrayOf(6,7,8,11,12,13,16,17,18).forEachIndexed {
        index, i ->
        if(finalDigit shr i == 1)
            return@map index + 1
    }
    return@map -999
}

println("The code is: " + code)