package oncall.util

object StringParser {

    private const val INVALID_NUMBER_ERROR = "[ERROR] Input value must be a number."

    fun parseByDelimiter(input: String, delimiter: String): List<String> {
        return input.split(delimiter)
    }

    fun parseToInt(input: String): Int {
        val month = input.toIntOrNull()
        require(month != null) { INVALID_NUMBER_ERROR }
        return month
    }
}
