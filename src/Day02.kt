fun main() {
    class Values(var x: Int, var y: Int, var aim: Int)

    fun part1(input: List<String>): Int {
        return input
            .map { l -> l.split(' ').let { Pair(it[0], it[1].toInt()) } }
            .fold(Values(0, 0, 0)) { acc, cmd ->
                when (cmd.first) {
                    "forward" -> acc.apply { x += cmd.second }
                    "down" -> acc.apply { y += cmd.second }
                    "up" -> acc.apply { y -= cmd.second }
                    else -> error("Command not recognized")
                }
            }
            .run {
                x * y
            }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { l -> l.split(' ').let { Pair(it[0], it[1].toInt()) } }
            .fold(Values(0, 0, 0)) { acc, cmd ->
                when (cmd.first) {
                    "forward" -> acc.apply {
                        x += cmd.second
                        y += aim * cmd.second
                    }
                    "down" -> acc.apply { aim += cmd.second }
                    "up" -> acc.apply { aim -= cmd.second }
                    else -> error("Command not recognized")
                }
            }
            .run {
                x * y
            }
    }

    readInput("Day02").let {
        println("Answer 1: ${part1(it)}")
        println("Answer 2: ${part2(it)}")
    }
}