import java.io.File

val input = File("input.txt")
val threeTimesThreeTriangles = input.readLines().chunked(3)
val validTriangles = threeTimesThreeTriangles.sumBy {
    var sum = 0
    //col1
    if(it[0].chunked(5)[0].trim().toInt() + it[1].chunked(5)[0].trim().toInt() > it[2].chunked(5)[0].trim().toInt()
    && it[0].chunked(5)[0].trim().toInt() + it[2].chunked(5)[0].trim().toInt() > it[1].chunked(5)[0].trim().toInt()
    && it[1].chunked(5)[0].trim().toInt() + it[2].chunked(5)[0].trim().toInt() > it[0].chunked(5)[0].trim().toInt())
        sum++
    //col2
    if(it[0].chunked(5)[1].trim().toInt() + it[1].chunked(5)[1].trim().toInt() > it[2].chunked(5)[1].trim().toInt()
    && it[0].chunked(5)[1].trim().toInt() + it[2].chunked(5)[1].trim().toInt() > it[1].chunked(5)[1].trim().toInt()
    && it[1].chunked(5)[1].trim().toInt() + it[2].chunked(5)[1].trim().toInt() > it[0].chunked(5)[1].trim().toInt())
        sum++
    //col3
    if(it[0].chunked(5)[2].trim().toInt() + it[1].chunked(5)[2].trim().toInt() > it[2].chunked(5)[2].trim().toInt()
    && it[0].chunked(5)[2].trim().toInt() + it[2].chunked(5)[2].trim().toInt() > it[1].chunked(5)[2].trim().toInt()
    && it[1].chunked(5)[2].trim().toInt() + it[2].chunked(5)[2].trim().toInt() > it[0].chunked(5)[2].trim().toInt())
        sum++

    return@sumBy sum
}

println("Number of valid triangles: $validTriangles")