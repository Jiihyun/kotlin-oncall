package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.util.StringParser

object InputView {

    private const val READ_MONTH_AND_START_DAY_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요>"
    private const val READ_WEEKDAY_WORKER_MESSAGE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요>"
    private const val READ_WEEKEND_WORKER_MESSAGE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>"

    private const val DELIMITER = ","
    private const val INVALID_INPUT_ERROR = "[ERROR] Input value does not exist."

    fun readMonthAndStartDay(): Pair<Int, String> {
        println(READ_MONTH_AND_START_DAY_MESSAGE)
        val input = readInput()

        val data = StringParser.parseByDelimiter(input, DELIMITER)
        val month = StringParser.parseToInt(data.first())
        val startDay = data.last()
        return Pair(month, startDay)
    }

    fun readWeekdayWorkers(): List<String> {
        println(READ_WEEKDAY_WORKER_MESSAGE)
        val input = readInput()
        return StringParser.parseByDelimiter(input, DELIMITER)
    }

    fun readWeekendWorkers(): List<String> {
        println(READ_WEEKEND_WORKER_MESSAGE)
        val input = readInput()
        return StringParser.parseByDelimiter(input, DELIMITER)
    }

    private fun readInput(): String {
        val input = Console.readLine().trim()
        require(input.isNotBlank()) { INVALID_INPUT_ERROR }
        return input
    }
}
