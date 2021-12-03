fun main() {
    fun List<String>.charsForColumn(n: Int) = groupingBy { it[n] }.eachCount()
    fun String.invertBinaryString() = map { if (it == '0') '1' else '0' }.joinToString("")

    fun part1(input: List<String>): Int {
        val charFreqPerColumn = input[0].indices.map { input.charsForColumn(it) }

        val gamma = charFreqPerColumn.joinToString("") { freqs ->
            freqs.maxByOrNull { it.value }?.key?.toString() ?: error("Could not find max!")
        }

        val epsilon = gamma.invertBinaryString()
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
        fun List<String>.filterColumnsForChar(charByFreq: (zeros: Int, ones: Int) -> Char): String {
            var current = this
            for (column in input[0].indices) {
                val charFreqPerColumn = current.charsForColumn(column)
                val zeros = charFreqPerColumn['0'] ?: 0
                val ones = charFreqPerColumn['1'] ?: 1
                current = current.filter { it[column] == charByFreq(zeros, ones) }
                if (current.size == 1) break
            }
            return current.single()
        }

        val oxygen = input.filterColumnsForChar { zeros, ones -> if (zeros > ones) '0' else '1' }
        val co2 = input.filterColumnsForChar { zeros, ones -> if (zeros > ones) '1' else '0' }

        return oxygen.toInt(2) * co2.toInt(2)
    }

    readInput("Day03").let {
        println("Answer 1: ${part1(it)}")
        println("Answer 2: ${part2(it)}")
    }
}