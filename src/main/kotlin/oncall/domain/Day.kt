package oncall.domain

class Day(val value: Int, private val dateOfWeek: DayOfWeek, val isHoliday: Boolean) {

    fun isWeekDay(): Boolean {
        return dateOfWeek.isWeekDay() && !isHoliday
    }

    fun dateOfWeek(): String {
        return dateOfWeek.dayOfWeek
    }
}
