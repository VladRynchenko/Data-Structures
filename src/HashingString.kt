class HashingString(private val arraySize: Int) {
    class StringItem(val key: String)

    private val hashArray: Array<StringItem?> = arrayOfNulls(arraySize)
    private val nonItem: StringItem = StringItem("")

    fun displayTable() {
        print("Table: ")
        for (j in 0 until arraySize) {
            if (hashArray[j] != null) print(hashArray[j]!!.key.toString() + " ") else print(" ** ")
        }
        println()
    }

    private fun hashFunString(key: String): Int {
        var hashVal = 0
        var pow27 = 1
        for (j in key.length - 1 downTo 0) {
            val letter: Int = key[j].toInt() - 96
            hashVal += pow27 * letter
            pow27 *= 27
        }
        return hashVal % arraySize
    }

    fun insert(item: StringItem) {
        val key = item.key
        var hashVal = hashFunString(key)
        var counter = 0
        while (hashArray[hashVal] != null && hashArray[hashVal]!!.key == "") {
            hashVal += counter * counter
            hashVal %= arraySize
            counter++
        }
        hashArray[hashVal] = item
    }

    fun delete(key: String): StringItem? // delete a DataItem
    {
        var hashVal = hashFunString(key) // hash the key
        var counter = 0
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]!!.key == key) {
                val temp = hashArray[hashVal]
                hashArray[hashVal] = nonItem
                return temp
            }
            hashVal += counter * counter
            hashVal %= arraySize
            counter++
        }
        return null
    }

    fun find(key: String): StringItem? {
        var hashVal = hashFunString(key)
        var counter = 0
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal]!!.key == key) return hashArray[hashVal] // yes, return item
            hashVal += counter * counter
            hashVal %= arraySize
            counter++
        }
        return null
    }

}
