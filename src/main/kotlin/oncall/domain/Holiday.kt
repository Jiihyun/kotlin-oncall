package oncall.domain

import java.time.LocalDate

enum class Holiday(val date: LocalDate) {

    신정(LocalDate.of(2023, 1, 1)),
    삼일절(LocalDate.of(2023, 3, 1)),
    어린이날(LocalDate.of(2023, 5, 5)),
    현충일(LocalDate.of(2023, 6, 6)),
    광복절(LocalDate.of(2023, 8, 15)),
    개천절(LocalDate.of(2023, 10, 3)),
    한글날(LocalDate.of(2023, 10, 9)),
    성탄절(LocalDate.of(2023, 12, 25));
    
    companion object {
        fun contains(month: Int, date: Int): Boolean {
            return entries.any { it.date.monthValue == month && it.date.dayOfMonth == date }
        }
    }
}
