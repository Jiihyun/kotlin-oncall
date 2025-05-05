package oncall.domain

import java.time.LocalDate

class ScheduleMaker(val weekday: Schedule, val weekend: Schedule) {

    fun makeSchedule(month: Month): Map<Day, String> {
        val result: MutableMap<Day, String> = mutableMapOf()

        val days = makeDays(month)
        days.forEach { day ->
            result[day] = getWorker(day, result)
        }
        return result
    }

    private fun makeDays(month: Month): List<Day> {
        val lastDay = month.getLastDay()
        val days: MutableList<Day> = mutableListOf()
        for (day in FIRST_DAY..lastDay) {
            val localDate = LocalDate.of(YEAR, month.value, day)
            days.add(Day(day, DayOfWeek.fromValue(localDate.dayOfWeek.value), Holiday.contains(month.value, day)))
            localDate.plusDays(1)
        }
        return days
    }

    private fun getWorker(day: Day, result: Map<Day, String>): String {
        var worker = getWorker(day)
        if (result.containsValue(worker)) {
            worker = getAnotherWorker(day)
        }
        return worker
    }

    private fun getWorker(day: Day): String {
        if (day.isWeekDay()) {
            return weekday.getWorker()
        }
        return weekend.getWorker()
    }

    private fun getAnotherWorker(day: Day): String {
        if (day.isWeekDay()) {
            return weekday.getAnotherWorker()
        }
        return weekend.getAnotherWorker()
    }

    companion object {
        private const val FIRST_DAY: Int = 1
        private const val YEAR: Int = 2023
    }
}
