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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WorkerName) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
