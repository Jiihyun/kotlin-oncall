package oncall.domain

class Month(val value: Int) {

    init {
        require(value in MIN_VALUE..MAX_VALUE) { MONTH_RANGE_LIMIT }
    }

    fun getLastDay(): Int {
        if (value in ODD_DAYS_MONTH) {
            return ODD_DAYS_LAST_DAY_VALUE
        }
        if (value in EVEN_DAYS_MONTH) {
            return EVEN_DAYS_LAST_DAY_VALUE
        }
        return FEB_LAST_DAY_VALUE
    }

    companion object {
        private const val MIN_VALUE: Int = 1
        private const val MAX_VALUE: Int = 12

        private val ODD_DAYS_MONTH: List<Int> = listOf(1, 3, 5, 7, 8, 10, 12)
        private const val ODD_DAYS_LAST_DAY_VALUE: Int = 31
        private val EVEN_DAYS_MONTH: List<Int> = listOf(2, 4, 6, 9, 11)
        private const val EVEN_DAYS_LAST_DAY_VALUE: Int = 30
        private const val FEB_LAST_DAY_VALUE: Int = 28

        private const val MONTH_RANGE_LIMIT: String = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
    }
}
