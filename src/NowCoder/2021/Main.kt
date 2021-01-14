package NowCoder.`2021`

/**
 * Created by fan on 21-1-14
 */

fun main(args: Array<String>) {

    val nowcoder = NowCoder1_20()
    val intArray = intArrayOf(1, 4, 7, 11, 15)
    val intArray2 = intArrayOf(2, 5, 8, 12, 19)
    val intArray3 = intArrayOf(3, 6, 9, 16, 22)
    val intArray4 = intArrayOf(10, 13, 14, 17, 24)
    val intArray5 = intArrayOf(18, 21, 23, 26, 30)
    val arrays = arrayListOf(intArray, intArray2, intArray3, intArray4, intArray5)
    print(nowcoder.findNumberIn2DArray(arrayListOf(), 21))

}
