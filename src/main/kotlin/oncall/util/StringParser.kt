package oncall.util

object StringParser {

    fun parseByDelimiter(input: String, delimiter: String): Pair<Int, String> {
        val data = input.split(delimiter)
        val month = data.first().toInt()
        val startDay = data.last()
        return Pair(month, startDay)
    }
}
