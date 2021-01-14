package NowCoder.`2021`

/**
 * Created by fan on 21-1-14
 */
class NowCoder1_20 {


    /**
     * 剑指 Offer 03. 数组中重复的数字
        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
        也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
      */

    fun findRepeatNumber(nums: IntArray): Int {
        val map = HashSet<Int>()
        nums.forEach {
            if (!map.add(it)) {
                return it
            }
        }
        return -1
    }

    // 原地排序，第一次写错了
    fun findRepeatNumber2(nums: IntArray): Int {
        for ((index, value) in nums.withIndex() ) {
            while (index != nums[index]) {
                if (nums[nums[index]] == nums[index]) {
                    return nums[index]
                }
                swap(nums, index, nums[index])
            }
        }
        return -1
    }

    /**
     *  剑指 Offer 04. 二维数组中的查找
     *  在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

        示例:
        现有矩阵 matrix 如下：

        [
        [1,   4,  7, 11, 15],
        [2,   5,  8, 12, 19],
        [3,   6,  9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
        ]
        给定 target = 5，返回 true。

        给定 target = 20，返回 false。

        限制：
        0 <= n <= 1000
        0 <= m <= 1000

     */

    fun findNumberIn2DArray(matrix: ArrayList<IntArray>, target: Int): Boolean {
        if (matrix.size == 0 || matrix[0].isEmpty()) {
            return false
        }
        val raw = matrix.size
        val column = matrix[0].size
        var columnIndex = column - 1
        var rawIndex = 0
        while (columnIndex >= 0 && rawIndex <= raw - 1) {
            if (target == matrix[rawIndex][columnIndex]) {
                return true
            } else if (target > matrix[rawIndex][columnIndex]) {
                rawIndex ++
            } else {
                columnIndex--
            }
        }
        return false
    }


}