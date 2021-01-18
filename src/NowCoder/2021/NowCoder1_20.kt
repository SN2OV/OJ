package NowCoder.`2021`

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

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

    /**
     *  剑指 Offer 05. 替换空格
     *
     *  请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
        示例 1：
        输入：s = "We are happy."
        输出："We%20are%20happy."
     *
     */

    fun replaceSpace(s: String): String {
        return s.replace(" ", "%20")
    }

    fun replaceSpace2(s: String): String {
        var count = 0
        s.forEach {
            if (it == ' ') {
                count ++
            }
        }
        val stringBuilder = StringBuilder(s.length + count)
        s.forEach {
            if (it == ' ') {
                stringBuilder.append("%20")
            } else {
                stringBuilder.append(it)
            }
        }
        return stringBuilder.toString()
    }

    /**
     *  剑指 Offer 06. 从尾到头打印链表
     *  输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
        输入：head = [1,3,2]
        输出：[2,3,1]
     *
     */

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */

    fun reversePrint(head: ListNode<Int>): IntArray {
        val stack = Stack<Int>()
        var p = head.next
        stack.add(head.value)
        while (p != null) {
            stack.add(p.value)
            p = p.next
        }
        val intArray = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            intArray.add(stack.pop())
        }
        return intArray.toIntArray()
    }

    // 递归回溯
    fun reversePrint2(head: ListNode<Int>?) {
        if (head == null) {
            return
        }
        reversePrint2(head.next)
        print(head.value)
    }

    /**
     * 剑指 Offer 07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *  例如
        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
        返回如下的二叉树：
             3
            / \
           9  20
             /  \
            15   7
     *
     */


    // 超时了..
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return buildTreeWithIndex(preorder, inorder, 0, preorder.size -1)
    }

    private fun buildTreeWithIndex(preorder: IntArray, inorder: IntArray, startIndex: Int, endIndex: Int): TreeNode? {
        var targetIndex = startIndex
        if (startIndex > endIndex) {
            return null
        } else if (startIndex == endIndex) {
            return TreeNode(inorder[startIndex])
        }
        while (targetIndex < inorder.size && preorder[startIndex] != inorder[targetIndex]) {
            targetIndex++
        }
        val treeNode = TreeNode(inorder[targetIndex])
        treeNode.left = buildTreeWithIndex(preorder, inorder, startIndex, targetIndex - 1)
        treeNode.right = buildTreeWithIndex(preorder, inorder, targetIndex + 1, endIndex)
        return treeNode
    }

    // 优化，利用空间换时间，依旧超时
    private val inorderHashMap = HashMap<Int, Int>()
    fun buildTree2(preorder: IntArray, inorder: IntArray): TreeNode? {
        inorder.forEachIndexed { index, value ->
            inorderHashMap[value] = index
        }
        return buildTreeWithIndex2(preorder, inorder, 0, preorder.size -1)
    }

    private fun buildTreeWithIndex2(preorder: IntArray, inorder: IntArray, startIndex: Int, endIndex: Int): TreeNode? {
        if (startIndex > endIndex) {
            return null
        } else if (startIndex == endIndex) {
            return TreeNode(inorder[startIndex])
        }
        val targetIndex = inorderHashMap[preorder[startIndex]]!!
        val treeNode = TreeNode(inorder[targetIndex])
        treeNode.left = buildTreeWithIndex2(preorder, inorder, startIndex, targetIndex - 1)
        treeNode.right = buildTreeWithIndex2(preorder, inorder, targetIndex + 1, endIndex)
        return treeNode
    }


    /**
     *  剑指 Offer 10- I. 斐波那契数列
     *  答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */

    fun fib(n: Int): Int {
        val array = IntArray(n + 1)
        if (n == 0 || n == 1) {
            return n
        }
        array[0] = 0
        array[1] = 1
        for (i in 2..n) {
            array[i] = array[i - 1] + array[i - 2]
            array[i] = array[i] % 1000000007
        }
        return array[n]
    }

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     *   一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */

    fun numWays(n: Int): Int {
        return fib(n + 1)
    }

    /**
     *  剑指 Offer 11. 旋转数组的最小数字
     *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *  输入：[3,4,5,1,2]  输出：1
     *  输入：[2,2,2,0,1]  输出：0
     */

    fun minArray(numbers: IntArray): Int {
        var low = 0
        var high = numbers.size - 1
        var mid = 0
        while (low <= high) {
            mid = (low + high) / 2
            if (mid == 0) {
                return numbers[0]
            }
            if (numbers[mid] < numbers[mid + 1] && numbers[mid - 1] > numbers[mid + 1]) {
                return numbers[mid]
            } else if (numbers[mid] < numbers[mid + 1] && numbers[mid] > numbers[mid - 1] ) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return -1
    }


}

    /**
     * 剑指 Offer 09. 用两个栈实现队列
     *
     *  用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     *  分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *
     */

    class CQueue {
        private var inStack = Stack<Int>()
        private var outStack = Stack<Int>()

        fun appendTail(value: Int) {
            inStack.add(value)
        }

        fun deleteHead(): Int {
            if (outStack.isEmpty()) {
                while (inStack.size > 0) {
                    outStack.add(inStack.pop())
                }
            }
            return if (outStack.size > 0) {
                outStack.pop()
            } else {
                -1
            }
        }

    }