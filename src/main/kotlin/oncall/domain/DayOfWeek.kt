package oncall.domain

enum class DayOfWeek(val dayOfWeek: String) {

    SUN("일"),
    MON("월"),
    TUE("화"),
    WED("수"),
    THU("목"),
    FRI("금"),
    SAT("토");

    companion object {
        fun from(input: String): DayOfWeek {
            return entries
                .firstOrNull { it.dayOfWeek == input }
                ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
        }
    }
}
