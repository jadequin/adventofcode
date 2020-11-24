import java.io.File
import kotlin.math.*

//now you can add Pair<Int, Int> together :)
operator fun Pair<Int, Int>.plus(p: Pair<Int, Int>): Pair<Int, Int> { return Pair(this.first + p.first, this.second + p.second) }

val input = File("/home/till/dev/aoc/aoc16/d1/input.txt")
val directions = input.readText().split(", ")

val xySteps = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0) //North[0], West[1], South[2], East[3]
val xyFinalCoordinates = directions.fold((0 to 0) to 0) { //Pair(coordinates, direction in xySteps)
    posAndDir, direction ->

    val newDirection = (posAndDir.second + (if(direction[0] == 'L') 3 else /*"R"*/5)) % 4
    val xyStep = xySteps[newDirection]
    val steps = direction.substring(1).toInt()

    val newCoordinates = posAndDir.first + Pair(xyStep.first * steps, xyStep.second * steps)

    return@fold newCoordinates to newDirection
}.first

println("Final coordinates: " + xyFinalCoordinates)
println("Manhattan distance: " + (abs(xyFinalCoordinates.first) + abs(xyFinalCoordinates.second)))