class DequeCustom(sizeArray: Int) {

    private var array: Array<Long> = Array(sizeArray) { 0 }
    private var head = 0
    private var size = 0
    private var maxSize = sizeArray


    private fun inc(index: Int): Int = if (index == array.lastIndex) 0 else index + 1
    private fun dec(index: Int): Int = if (index == 0) array.lastIndex else index - 1
    private fun internalIndex(index: Int): Int = positiveMod(head + index)
    private fun positiveMod(index: Int): Int = if (index >= array.size) index - array.size else index

    fun pushTop(l: Long) {
        if (full()) return
        head = dec(head)
        array[head] = l
        size += 1
    }

    fun pushBack(l: Long) {
        if (full()) return
        array[internalIndex(size)] = l
        size += 1
    }

    fun popTop(): Long {
        if (empty()) return -1
        val element = array[head]
        head = inc(head)
        size -= 1
        return element
    }

    fun popBack(): Long {
        if (empty()) {
            return -1
        }
        val tempHead = internalIndex(size - 1)
        val element = array[tempHead]
        size -= 1
        return element
    }

    fun empty(): Boolean {
        return (size == 0)
    }

    fun full(): Boolean = (size == maxSize)


    fun getTop(): Long = if (empty()) -1 else array[head]
    fun getBack(): Long = if (empty()) -1 else array[internalIndex(size - 1)]
    fun clean() {
        head = 0
        size = 0
    }

}