package oncall.view

import oncall.domain.Day

object OutputView {

    private const val WEEKDAY_FORMAT: String = "%d월 %d일 %s %s"
    private const val WEEKEND_FORMAT: String = "%d월 %d일 %s(휴일) %s"

    fun showSchedule(month: Int, schedule: Map<Day, String>) {
        schedule.entries.forEach { (day, name) ->
            println(getFormat(day).format(month, day.value, day.dateOfWeek(), name))
        }
    }

    fun getFormat(day: Day): String {
        if (day.isHoliday) {
            return WEEKEND_FORMAT
        }
        return WEEKDAY_FORMAT
    }

    fun printError(message: String) {
        println(message)
    }
}
