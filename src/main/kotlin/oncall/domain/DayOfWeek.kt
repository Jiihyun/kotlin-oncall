package oncall.domain

enum class DayOfWeek(val dayOfWeek: String, val index: Int) {

    SUN("일", 0),
    MON("월", 1),
    TUE("화", 2),
    WED("수", 3),
    THU("목", 4),
    FRI("금", 5),
    SAT("토", 6);

    fun isWeekend(): Boolean {
        return WEEKEND.contains(this)
    }

    fun isWeekDay(): Boolean {
        return !isWeekend()
    }

    fun getDayOfWeek(): DayOfWeek {
        val nextIndex: Int = (this.index) % entries.size
        return entries.firstOrNull { dayOfWeek -> dayOfWeek.index == nextIndex }
            ?: throw IllegalStateException("[ERROR] Couldn't find the date of week.")
    }

    companion object {
        private val WEEKEND: List<DayOfWeek> = listOf(SAT, SUN)

        fun from(input: String): DayOfWeek {
            return entries
                .firstOrNull { it.dayOfWeek == input }
                ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
        }

        fun createNextDayOfWeek(dayOfWeek: DayOfWeek): DayOfWeek {
            return entries
                .firstOrNull { it.index == (dayOfWeek.index + 1) % entries.size }
                ?: throw IllegalStateException("[ERROR] Couldn't find the date of week.")
        }
    }
}
