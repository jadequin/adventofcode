import java.io.File

val input = File("input.txt")

val sectorIdNorthPoleObjects = (input.readLines().find {
    val roomNameChars = it.substringBeforeLast('-')
    val sectorId = it.substringBefore('[').substringAfterLast('-').toInt()

    println(roomNameChars.map { if(it == '-') ' ' else ((it - 97 + sectorId).toInt().rem(26) + 97).toChar() }.joinToString(""))
    return@find roomNameChars.map { if(it == '-') ' ' else ((it - 97 + sectorId).toInt().rem(26) + 97).toChar() }.joinToString("") == "northpole object storage"

} ?: "999").substringBefore('[').substringAfterLast('-').toInt()

println("\n\n${"-".repeat(40)}\nSector ID of the north pole objects: $sectorIdNorthPoleObjects")