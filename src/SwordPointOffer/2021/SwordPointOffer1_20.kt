package SwordPointOffer.`2021`

import java.util.*
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

    fun reversePrint(head: ListNode): IntArray {
        val stack = Stack<Int>()
        var p = head.next
        stack.add(head.`val`)
        while (p != null) {
            stack.add(p.`val`)
            p = p.next
        }
        val intArray = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            intArray.add(stack.pop())
        }
        return intArray.toIntArray()
    }

    // 递归回溯
    fun reversePrint2(head: ListNode?) {
        if (head == null) {
            return
        }
        reversePrint2(head.next)
        print(head.`val`)
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
        while (low <= high) {
            val mid = (low + high) / 2
            if (numbers[mid] < numbers[high]) {
                high = mid
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1
            } else {
                var min = numbers[mid]
                for (index in low..high) {
                    if (numbers[index] < min) {
                        min = numbers[index]
                    }
                }
                return min
            }
        }
        return numbers[0]
    }

    /**
     * 剑指 Offer 12. 矩阵中的路径
     *
         * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

        [["a","b","c","e"],
        ["s","f","c","s"],
        ["a","d","e","e"]]

        但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

        示例 1：
        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        输出：true

        示例 2：
        输入：board = [["a","b"],["c","d"]], word = "abcd"
        输出：false
     *
     */

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val column = board[0].size
        val raw = board.size
        for (rIndex in 0 until raw){
            for (cIndex in 0 until  column) {
                if (checkPath(rIndex, cIndex, board, word, 0)) {
                    return true
                }
            }
        }
        return false
    }

    // rIndex为横坐标
    private fun checkPath(rIndex: Int, cIndex: Int, board: Array<CharArray>, word: String, index: Int): Boolean {
        if (index == word.length) {
            return true
        }
        if (rIndex < 0 || rIndex >= board.size || cIndex < 0 || cIndex >= board[0].size || board[rIndex][cIndex] != word[index]) {
            return false
        }
        board[rIndex][cIndex] = ' '
        val result = checkPath(rIndex + 1, cIndex, board, word, index + 1) ||
                checkPath(rIndex - 1, cIndex, board, word, index + 1) ||
                checkPath(rIndex, cIndex + 1, board, word, index + 1) ||
                checkPath(rIndex, cIndex - 1, board, word, index + 1)
        board[rIndex][cIndex] = word[index]
        return result
    }

    /**
     * 剑指 Offer 13. 机器人的运动范围
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     *  示例 1：
        输入：m = 2, n = 3, k = 1
        输出：3
        示例 2：

        输入：m = 3, n = 1, k = 0
        输出：1
     *
     */
    fun movingCount(m: Int, n: Int, k: Int): Int {
        return 0
    }

    /**
     * 剑指 Offer 14- I. 剪绳子
     *  给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     *  请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

        示例 1：
        输入: 2
        输出: 1
        解释: 2 = 1 + 1, 1 × 1 = 1

        示例 2:
        输入: 10
        输出: 36
        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     */

    fun cuttingRope(n: Int): Int {
        return 0
    }

    /**
     * 剑指 Offer 15. 二进制中1的个数
     *  请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     */
    fun hammingWeight(n: Int): Int {
        var number = n
        var count = 0
        while (number != 0) {
            count += (number and 1)
            // ushr为无符号右移
            number = number ushr 1
        }
        return count
    }

    fun hammingWeight2(n: Int): Int {
        var number = n
        var count = 0
        while (number != 0) {
            count ++
            number = number and (number - 1)
        }
        return count
    }

    /**
     * 剑指 Offer 16. 数值的整数次方
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     */
    fun myPow(x: Double, n: Int): Double {
        if (x == 0.0) {
            return 0.0
        }
        var num = x
        var power: Long = n.toLong()
        var result = 1.0
        if (n < 0) {
            num = 1 / num
            power *= (-1)
        }
        while (power > 0) {
            if (power.toInt() and 1 == 1) {
                result *= num
            }
            num *= num
            power = power shr 1
        }
        return result
    }

    /**
     * 剑指 Offer 17. 打印从1到最大的n位数
     *输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
        示例 1:
        输入: n = 1
        输出: [1,2,3,4,5,6,7,8,9]

        说明：
        用返回一个整数列表来代替打印
        n 为正整数
     */

    fun printNumbers(n: Int): IntArray {
        return intArrayOf()
    }

    /**
     * 剑指 Offer 18. 删除链表的节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
       返回删除后的链表的头节点。
     */

    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        val pHead = head
        var cur = head
        var pre: ListNode? = null
        if (head?.`val` == `val`) {
            return head.next
        }
        while (cur != null) {
            if (cur.`val` == `val`) {
                pre?.next = cur.next
                return pHead
            }
            pre = cur
            cur = cur.next
        }
        return pHead
    }

    /**
     * 剑指 Offer 19. 正则表达式匹配
     *
     *  请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

        示例 1:
        输入:
        s = "aa"
        p = "a"
        输出: false
        解释: "a" 无法匹配 "aa" 整个字符串。

        示例 2:
        输入:
        s = "aa"
        p = "a*"
        输出: true
        解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

        示例 3:
        输入:
        s = "ab"
        p = ".*"
        输出: true
        解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

        示例 4:
        输入:
        s = "aab"
        p = "c*a*b"
        输出: true
        解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。

        示例 5:
        输入:
        s = "mississippi"
        p = "mis*is*p*."
        输出: false
        s 可能为空，且只包含从 a-z 的小写字母。
        p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。

     *
     */


    /**
     * 剑指 Offer 20. 表示数值的字符串
     *  请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、
     *  "0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     */

    // 没有跑过全部case
    fun isNumber(s: String): Boolean {
        val str = s.trim()
        if (str.isEmpty()) {
            return false
        }
        if (str.contains('e') || str.contains('E')) {
            val arr = str.split('e')
            val arr2 = str.split('E')
            if (arr.size == 2 && isInteger(arr[0]) && isInteger(arr[1])) {
                return true
            }
            if (arr2.size == 2 && isInteger(arr2[0]) && isInteger(arr2[1])) {
                return true
            }
        }
        if (str.contains('.')) {
            val arr = s.split('.')
            return (arr.size == 2 && isInteger(arr[0]) && isInteger(arr[1]) && arr[1].length > 0 && arr[1][0] != '+' && arr[1][0] != '-')
        }
        return isNumberWithoutE(str)
    }

    fun isNumberWithoutE(s: String): Boolean {
        var hasDot = false
        for (index in s.indices) {
            val curChar = s[index]
            if (curChar == '.') {
                if (hasDot) {
                    return false
                } else {
                    hasDot = true
                }
            }
            if ((curChar != '+' && curChar != '-' && curChar != '.') && !curChar.isDigit()) {
                return false
            }
            if ((curChar == '+' || curChar == '-')) {
                if (index > 0) {
                    return false
                } else {
                    continue
                }
            }
        }
        return true
    }

    fun Char.isDigit(): Boolean {
        return this in '0'..'9'
    }

    fun isInteger(s: String): Boolean {
        if (s.isEmpty()) {
            return false
        }
        for (index in s.indices) {
            val curChar = s[index]
            if ((curChar != '+' && curChar != '-') && !curChar.isDigit()) {
                return false
            }
            if ((curChar == '+' || curChar == '-')) {
                if (index > 0) {
                    return false
                } else {
                    continue
                }
            }
        }
        return true
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