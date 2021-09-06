import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

var size: Int = 0

@Throws(IOException::class)
fun main(args: Array<String>) {
    print("Enter size of hash table: ")
    size = getInt()
    print("Enter element: ")
    val key = getInt()
    print(hashFun(key))


}

fun hashFun(key: Int): Int {
    val keyDigitCount = getDigitCount(key)
    val groupSize = getDigitCount(size)
    var groupSum = 0
    val keyString = Integer.toString(key)
    var i = 0
    while (i < keyString.length) {
        if (i + groupSize <= keyString.length) {
            val group = keyString.substring(i, i + groupSize)
            groupSum += group.toInt()
        }
        i += groupSize
    }
    if (keyDigitCount % groupSize != 0) {
        val remainingPart = keyString.substring(i - groupSize, keyString.length)
        groupSum += remainingPart.toInt()
    }
    return groupSum % size


}


fun getDigitCount(n: Int): Int {
    var n = n
    var numDigits = 1
    while (n > 9) {
        n /= 10
        numDigits++
    }
    return numDigits
}

@Throws(IOException::class)
fun getString(): String {
    val isr = InputStreamReader(System.`in`)
    val br = BufferedReader(isr)
    return br.readLine()
}

@Throws(IOException::class)
fun getInt(): Int {
    val s = getString()
    return s.toInt()
}