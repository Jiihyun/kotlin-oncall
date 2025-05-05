package oncall.domain

class WorkerName(val value: String) {

    init {
        require(value.length in MIN_VALUE..MAX_VALUE) { NAME_LENGTH_LIMIT }
    }

    companion object {
        private const val MIN_VALUE: Int = 1
        private const val MAX_VALUE: Int = 5

        private const val NAME_LENGTH_LIMIT: String = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
    }
}
