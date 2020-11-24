/*
couldn't find a bug so i looked for a reference program to find my bug...
bug -> didn't check if a character of the checksum is non-existent in the room names
 */


import java.io.File

val rooms = File("/home/till/dev/aoc/aoc16/d4/input.txt").readText().split("\n").map(::Room)

fun solvePart1() =
        rooms
                .filter { it.isValid() }
                .map { it.accessCode }
                .sum()

fun solvePart2(find: String = "northpole object storage"): Int =
        rooms
                .filter { it.isValid() }
                .filter { it.decrypted == find }
                .first()
                .accessCode


class Room(raw: String) {
    val name: String = raw.substringBeforeLast('-')
    val accessCode: Int = raw.substringAfterLast('-').substringBefore('[').toInt()
    val checksum: String = raw.substringAfter('[').substringBefore(']')
    val decrypted: String by lazy { decryptName() }

    // Group by frequency, convert to pairs, sort by count desc, letter asc, join first 5.
    fun isValid(): Boolean {
        return name
                .replace("-", "")
                .groupBy { it }
                .mapValues { it.value.size }
                .toList()
                .sortedWith(compareBy({ 0 - it.second }, { it.first }))
                .take(5)
                .map { it.first }
                .joinToString(separator = "") == this.checksum
    }

    private fun decryptName(): String =
            name.map { if (it == '-') ' ' else shiftChar(it) }.joinToString(separator = "")

    private fun shiftChar(c: Char): Char =
            ((((c - 'a') + this.accessCode) % 26) + 'a'.toInt()).toChar()

}

println(solvePart1())