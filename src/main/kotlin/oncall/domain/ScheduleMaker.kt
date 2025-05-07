package oncall.domain

class ScheduleMaker(val weekday: Schedule, val weekend: Schedule) {

    fun makeSchedule(month: Month, dayOfWeek: DayOfWeek): Map<Day, String> {
        val result: MutableMap<Day, String> = mutableMapOf()

        val days = makeDays(month, dayOfWeek)
        days.forEach { day ->
            result[day] = getWorker(day, result)
        }
        return result
    }

    private fun makeDays(month: Month, dayOfWeek: DayOfWeek): List<Day> {
        val lastDay = month.getLastDay()
        val days: MutableList<Day> = mutableListOf()
        var nextday = dayOfWeek
        for (day in FIRST_DAY..lastDay) {
            days.add(Day(day, nextday.getDayOfWeek(), Holiday.contains(month.value, day)))
            nextday = DayOfWeek.createNextDayOfWeek(nextday)
        }
        return days
    }

    private fun getWorker(day: Day, result: Map<Day, String>): String {
        val worker = peekWorkerByDay(day)
        if (day.value == 1) {
            return getWorkerByDay(day)
        }
        return findWorker(day, result, worker)
    }

    private fun peekWorkerByDay(day: Day): String {
        if (day.isWeekDay()) {
            return weekday.peekWorker()
        }
        return weekend.peekWorker()
    }

    private fun getWorkerByDay(day: Day): String {
        if (day.isWeekDay()) {
            return weekday.getWorker()
        }
        return weekend.getWorker()
    }

    private fun findWorker(
        day: Day,
        result: Map<Day, String>,
        worker: String
    ): String {
        if (worksContinuously(day, result, worker)) {
            return getAnotherWorker(day)
        }
        return getWorkerByDay(day)
    }

    private fun worksContinuously(
        day: Day,
        result: Map<Day, String>,
        worker: String
    ): Boolean {
        val oneDayBefore = day.value - 1
        val dayBefore = result.keys.first { it.value == oneDayBefore }
        return result[dayBefore] == worker
    }

    private fun getAnotherWorker(day: Day): String {
        if (day.isWeekDay()) {
            return weekday.getAnotherWorker()
        }
        return weekend.getAnotherWorker()
    }

    companion object {
        private const val FIRST_DAY: Int = 1
    }
}
