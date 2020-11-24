import java.io.File

val input = File("/home/till/dev/aoc/aoc16/d4/input.txt")

// aaaaa-bbb-z-y-x-123[abxyz]       --- EXAMPLE INPUT
val sectorIdSum = input.readLines().sumBy {
    val roomNameChars = it.substringBefore('[').filterNot { it == '-' }
    val checkSumChars = it.substringAfter('[').substringBefore(']')
    val sectorId = it.substringBefore('[').substringAfterLast('-').toInt()

    val checkSumNums = checkSumChars.map { c -> roomNameChars.count { it == c } }
    return@sumBy if(
            checkSumNums == checkSumNums.sortedDescending()
            && checkSumNums.none { it == 0 }
            && checkSumChars
                    .map { it.toInt() }
                    .zip(checkSumNums)
                    .zipWithNext()
                    .none { it.first.second == it.second.second && it.first.first > it.second.first })
        sectorId
    else
        0
}
//176749 this solution, right solution is 173787
//critical: ide-htrgti-rdggdhxkt-ytaanqtpc-htgkxrth-921[tcpfv]

println("Sum of all sector IDs from real rooms: $sectorIdSum")