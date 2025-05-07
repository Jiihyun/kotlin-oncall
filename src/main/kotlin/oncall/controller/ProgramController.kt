package oncall.controller

import oncall.domain.DayOfWeek
import oncall.domain.Month
import oncall.domain.Schedule
import oncall.domain.ScheduleMaker
import oncall.domain.WorkerName
import oncall.util.InputHandler
import oncall.view.InputView
import oncall.view.OutputView

class ProgramController {

    fun run() {
        val monthAndStartDay = InputHandler.retryOnInvalidInput { readMonthAndStartDay() }
        val schedules = InputHandler.retryOnInvalidInput { readSchedules() }

        val scheduleMaker = ScheduleMaker(schedules.first, schedules.second)
        val schedule = scheduleMaker.makeSchedule(monthAndStartDay.first, monthAndStartDay.second)

        OutputView.showSchedule(monthAndStartDay.first.value, schedule)
    }

    private fun readMonthAndStartDay(): Pair<Month, DayOfWeek> {
        val monthAndStartDay = InputView.readMonthAndStartDay()
        val month = Month(monthAndStartDay.first)
        val dayOfWeek = DayOfWeek.from(monthAndStartDay.second)
        return Pair(month, dayOfWeek)
    }

    private fun readSchedules(): Pair<Schedule, Schedule> {
        val weekdayWorkers = InputView.readWeekdayWorkers()
        val weekdaySchedule = Schedule(weekdayWorkers.map { WorkerName(it) })

        val weekendWorkers = InputView.readWeekendWorkers()
        val weekendSchedule = Schedule(weekendWorkers.map { WorkerName(it) })
        return Pair(weekdaySchedule, weekendSchedule)
    }
}
