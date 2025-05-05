package oncall.domain

class Schedule(val workers: List<WorkerName>) {

    init {
        require(isUniqueName()) { NAMES_DUPLICATED_ERROR }
        require(workers.size in MIN_VALUE..MAX_VALUE) { SIZE_OUT_OF_RANGE_ERROR }
    }

    private fun isUniqueName() = workers.toSet().size == workers.size

    companion object {
        private const val MIN_VALUE: Int = 5
        private const val MAX_VALUE: Int = 35

        private const val NAMES_DUPLICATED_ERROR: String = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
        private const val SIZE_OUT_OF_RANGE_ERROR: String = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
    }
}
