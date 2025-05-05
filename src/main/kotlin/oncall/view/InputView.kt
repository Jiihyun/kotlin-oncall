package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.util.StringParser

object InputView {

    private const val READ_MONTH_AND_START_DAY_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요>"

    private const val MONTH_DAY_DELIMITER = ","
    private const val INVALID_INPUT_ERROR = "[ERROR] Input value does not exist."

    fun readMonthAndStartDay(): Pair<Int, String> {
        println(READ_MONTH_AND_START_DAY_MESSAGE)
        val input = readInput()
        return StringParser.parseByDelimiter(input, MONTH_DAY_DELIMITER)
    }

    private fun readInput(): String {
        val input = Console.readLine().trim()
        require(input.isNotBlank()) { INVALID_INPUT_ERROR }
        return input
    }
}
