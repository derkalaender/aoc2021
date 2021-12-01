fun part1(input: List<String>): Int {
    return input
        .asSequence()
        .map { it.toInt() }
        .zipWithNext()
        .count { (f, s) -> s > f }
}

fun part2(input: List<String>): Int {
    return input
        .asSequence()
        .map { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .zipWithNext()
        .count { (f, s) -> s > f }
}

fun main() {
    readInput("Day01").let {
        println("Answer 1: ${part1(it)}")
        println("Answer 2: ${part2(it)}")
    }
}