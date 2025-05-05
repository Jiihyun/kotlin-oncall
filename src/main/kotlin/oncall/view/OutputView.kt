package oncall.view

import oncall.domain.Day

object OutputView {

    private const val WEEKDAY_FORMAT: String = "%d월 %d일 %s %s"
    private const val WEEKEND_FORMAT: String = "%d월 %d일 %s(휴일) %s"

    fun showSchedule(month: Int, schedule: Map<Day, String>) {
        schedule.entries.forEach { (day, name) ->
            if (day.isHoliday) {
                println(WEEKEND_FORMAT.format(month, day.value, day.dateOfWeek(), name))
                return
            }
            println(WEEKDAY_FORMAT.format(month, day.value, day.dateOfWeek(), name))
        }
    }

    fun printError(message: String) {
        println(message)
    }
}
