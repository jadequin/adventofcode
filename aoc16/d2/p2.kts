import java.io.File

val input = File("input.txt")
val instructionLines = input.readLines()

/*
Solution with a bit grid inside of an integer:

     0  1  2  3  4  5  6
     7  8  9 10 11 12 13
    14 15 16 17 18 19 20
    21 22 23 24 25 26 27
    28 29 30 31 32 33 34
    35 36 37 38 39 40 41
    42 43 44 45 46 47 48

     Bits in the middle (the keypad) are flagged with 1 and the borders with 0:

     0  0  0  0  0  0  0
     0  0  0  1  0  0  0
     0  0  2  3  4  0  0
     0  5  6  7  8  9  0
     0  0  A  B  C  0  0
     0  0  0  D  0  0  0
     0  0  0  0  0  0  0

 */

val keypad = 0b0000000_0001000_0011100_0111110_0011100_0001000_0000000L
var pos = 1L shl 22

val code = instructionLines.map {
    val finalDigit = it.toCharArray().fold(pos) {
        currentPos, direction ->
        print("Current pos: $currentPos, Direction: $direction\n")

        return@fold when(direction) {
            'L' -> if(((currentPos shr 1) and keypad) != 0L) ((currentPos shr 1) and keypad) else currentPos
            'R' -> if(((currentPos shl 1) and keypad) != 0L) ((currentPos shl 1) and keypad) else currentPos
            'U' -> if(((currentPos shr 7) and keypad) != 0L) ((currentPos shr 7) and keypad) else currentPos
            else -> if(((currentPos shl 7) and keypad) != 0L) ((currentPos shl 7) and keypad) else currentPos
        }
    }
    pos = finalDigit
    arrayOf(10,16,17,18,22,23,24,25,26,30,31,32,38).forEachIndexed {
        index, i ->
        if(finalDigit shr i == 1L)
            return@map index + 1L
    }
    return@map -999L
}

println("The code is: " + code)