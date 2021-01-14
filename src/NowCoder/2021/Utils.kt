package NowCoder.`2021`

/**
 * Created by fan on 21-1-14
 */

fun swap(array: IntArray, startIndex: Int, endIndex: Int) {
    val temp = array[startIndex]
    array[startIndex] = array[endIndex]
    array[endIndex] = temp
}

// 查找第一个大于等于目标的数
fun findFirstBiggerTarget(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    var mid: Int
    while (low <= high) {
        mid = (low + high) / 2
        when {
            array[mid] > target -> {
                // 这里之前写错了
                if (mid == 0 || array[mid - 1] < target) {
                    return mid
                } else {
                    high = mid -1
                }
            }
            array[mid] < target -> {
                low = mid + 1
            }
        }
    }
    return -1
}

// 二分查找
fun binarySearch(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    var mid: Int
    while (low <= high) {
        mid = (low + high) / 2
        when {
            array[mid] == target -> {
                return mid
            }
            array[mid] < target -> {
                low = mid + 1
            }
            else -> {
                high = mid -1
            }
        }
    }
    return -1
}