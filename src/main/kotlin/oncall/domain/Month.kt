package oncall.domain

class Month(val value: Int) {

    init {
        require(value in MIN_VALUE..MAX_VALUE) { MONTH_RANGE_LIMIT }
    }

    companion object {
        private const val MIN_VALUE: Int = 1
        private const val MAX_VALUE: Int = 12

        private const val MONTH_RANGE_LIMIT: String = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
    }

    //TODO: 일 (28,30,31 구분 메서드)
}
