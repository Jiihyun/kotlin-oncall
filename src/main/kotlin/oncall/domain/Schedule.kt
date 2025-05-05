package oncall.domain

class Schedule(val workers: List<WorkerName>) {

    init {
        require(isUniqueName()) { NAMES_DUPLICATED_ERROR }
    }

    private fun isUniqueName() = workers.toSet().size == workers.size

    companion object {
        private const val NAMES_DUPLICATED_ERROR: String = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
    }
}
