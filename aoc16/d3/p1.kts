import java.io.File

val input = File("input.txt")
val triangles: List<Triple<Int, Int, Int>> = input.readLines().map { val lengths = it.chunked(5).map { it.trim().toInt() }; return@map Triple(lengths[0], lengths[1], lengths[2]) }

val validTriangles = triangles.count { it.first + it.second > it.third && it.first + it.third > it.second && it.second + it.third > it.first }

println("Number of valid triangles: $validTriangles")