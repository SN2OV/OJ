package SwordPointOffer.`2021`

import java.util.*
import kotlin.math.min

class NowCoder21_40 {

    /**
     *  剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     *  输入：nums = [1,2,3,4]
        输出：[1,3,2,4]
        注：[3,1,2,4] 也是正确的答案之一。
     *
     */

    fun exchange(nums: IntArray): IntArray {
        if (nums.isEmpty() || nums.size == 1) {
            return nums
        }
        var start = 0
        var end = nums.size - 1
        // 第一次没有注意数组内的边界，而且需要放在&&的前面
        while (start < end) {
            while (start < nums.size && nums[start] % 2 == 1) {
                start++
            }
            while (end >= 0 && nums[end] % 2 == 0) {
                end--
            }
            if (start < end) {
                swap(nums, start, end)
            }
        }
        return nums
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     *
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     *
     */

    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        var slowListNode = head
        var fastListNode = head
        for (index in 0 until k - 1) {
            fastListNode = fastListNode?.next
        }
        while (fastListNode?.next != null) {
            fastListNode = fastListNode.next
            slowListNode = slowListNode?.next
        }
        return slowListNode
    }

    /**
     * 剑指 Offer 24. 反转链表
     *
     */
    fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur = head
        var pointer = cur
        while (pointer != null) {
            pointer = pointer.next
            cur?.next = pre
            pre = cur
            cur = pointer
        }
        return pre
    }

    /**
     * 剑指 Offer 25. 合并两个排序的链表
     *
     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        } else if (l2 == null) {
            return l1
        }
        var p1 = l1
        var p2 = l2
        var mergeListNode: ListNode? = null
        if (p1.`val` <= p2.`val`) {
            mergeListNode = ListNode(p1.`val`)
            p1 = p1.next
        } else {
            mergeListNode = ListNode(p2.`val`)
            p2 = p2.next
        }
        var newNode = mergeListNode
        while (p1 != null && p2 != null) {
            if (p1.`val` <= p2.`val`) {
                mergeListNode?.next = ListNode(p1.`val`)
                p1 = p1.next
            } else {
                mergeListNode?.next = ListNode(p2.`val`)
                p2 = p2.next
            }
            mergeListNode = mergeListNode?.next
        }
        while (p1 != null) {
            mergeListNode?.next = ListNode(p1.`val`)
            p1 = p1.next
            mergeListNode = mergeListNode?.next
        }
        while (p2 != null) {
            mergeListNode?.next = ListNode(p2.`val`)
            p2 = p2.next
            mergeListNode = mergeListNode?.next
        }
        return newNode
    }

    /**
     * 剑指 Offer 26. 树的子结构
     *输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

        B是A的子结构， 即 A中有出现和B相同的结构和节点值。
        例如:
        给定的树 A:

             3
            / \
           4   5
          / \
         1   2
        给定的树 B：

           4 
          /
         1
        返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     */

    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B))
    }

    // 判断A是否包含B,第一次写的时候recur写成了判断树是否相同，区别就是B==null也可以return true，相同则return false
    fun recur(A: TreeNode?, B: TreeNode?): Boolean {
        if (B == null) {
            return true
        }
        if (A == null || A?.`val` != B?.`val`) {
            return false
        }
        return recur(A.left, B) && recur(A.right, B)
    }

    /**
     * 剑指 Offer 27. 二叉树的镜像
     *
     */

    fun mirrorTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return root
        }
        val temp = root.left
        root.left = root.right
        root.right = temp
        mirrorTree(root.left)
        mirrorTree(root.right)
        return root
    }

    /**
     * 剑指 Offer 28. 对称的二叉树
     */
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSymmetric(root?.left, root?.right)
    }

    fun isSymmetric(treeA: TreeNode?, treeB: TreeNode?): Boolean {
        if (treeA == null && treeB == null) {
            return true
        }
        if (treeA == null || treeB == null) {
            return false
        }
        return treeA.`val` == treeB.`val` && isSymmetric(treeA.left, treeB.right) && isSymmetric(treeA.right, treeB.left)
    }

    /**
     * 剑指 Offer 29. 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

        示例 1：
        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[1,2,3,6,9,8,7,4,5]

        示例 2：
        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     */

    // 部分case没通过
    fun spiralOrder(matrix: Array<IntArray>) {
        if (matrix.isEmpty()) {
            return
        }
        val raw = matrix.size - 1
        val column = matrix[0].size - 1
        val min = min(raw, column)
        var start = 0
        while (start * 2 < min) {
            for (j in start until column - start) {
                print("${matrix[start][j]} ")
            }
            for (i in start until raw - start) {
                print("${matrix[i][column - start]} ")
            }
            for (j in column - start downTo start + 1) {
                print("${matrix[raw - start][j]} ")
            }
            for (i in raw - start downTo start + 1) {
                print("${matrix[i][start]} ")
            }
            start++
        }
        start --
        if (raw > column) {
            for (i in start + 1 until raw - start) {
                print("${matrix[i][start + 1]} ")
            }
        } else if (raw < column) {
            for (j in start + 1 until column - start) {
                print("${matrix[start + 1][j]} ")
            }
        } else if (raw % 2 == 0) {
            print("${matrix[start + 1][start + 1]} ")
        }
    }

    fun spiralOrder2(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty()) {
            return intArrayOf()
        }
        val raw = matrix.size - 1
        val column = matrix[0].size - 1
        val min = min(raw, column)
        var start = 0
        val arrayList = arrayListOf<Int>()
        while (start * 2 < min) {
            for (j in start until column - start) {
                arrayList.add(matrix[start][j])
            }
            for (i in start until raw - start) {
                arrayList.add(matrix[i][column - start])
            }
            for (j in column - start downTo start + 1) {
                arrayList.add(matrix[raw - start][j])
            }
            for (i in raw - start downTo start + 1) {
                arrayList.add(matrix[i][start])
            }
            start++
        }
        start --
        if (raw > column) {
            for (i in start + 1 until raw - start) {
                arrayList.add(matrix[i][start + 1])
            }
        } else if (raw < column) {
            for (j in start + 1 until column - start) {
                arrayList.add(matrix[start + 1][j])
            }
        } else if (raw % 2 == 0) {
            arrayList.add(matrix[start + 1][start + 1])
        }
        return arrayList.toIntArray()
    }

    /**
     * 剑指 Offer 31. 栈的压入、弹出序列
     *  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     *  例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     */
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var pushPointer = 0
        for (popIndex in popped.indices) {
            if (stack.isNotEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop()
                continue
            }
            for (pushIndex in pushPointer until pushed.size) {
                stack.push(pushed[pushIndex])
                pushPointer ++
                if (popped[popIndex] == pushed[pushIndex]) {
                    stack.pop()
                    break
                }
            }
        }
        return stack.isEmpty()
    }

    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     */

    fun levelOrder(root: TreeNode?): IntArray {
        if (root == null) {
            return intArrayOf()
        }
        val array = mutableListOf<Int>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.peek()
            array.add(node.`val`)
            queue.remove()
            if (node.left?.`val` != null) {
                queue.add(node.left)
            }
            if (node.right?.`val` != null) {
                queue.add(node.right)
            }
        }
        return array.toIntArray()
    }

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */

    fun levelOrder2(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }
        val array = mutableListOf<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var layerCount = 1
        while (queue.isNotEmpty()) {
            val layerData = mutableListOf<Int>()
            layerCount = queue.size
            while (--layerCount >= 0) {
                val node = queue.peek()
                layerData.add(node.`val`)
                queue.remove()
                if (node.left?.`val` != null) {
                    queue.add(node.left)
                }
                if (node.right?.`val` != null) {
                    queue.add(node.right)
                }
            }
            array.add(layerData)
        }
        return array
    }

    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     *  请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     */
    fun levelOrder3(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }
        val array = mutableListOf<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var layerCount = 1
        var layerNo = 1
        while (queue.isNotEmpty()) {
            val layerData = LinkedList<Int>()
            layerCount = queue.size
            while (--layerCount >= 0) {
                val node = queue.peek()
                if (layerNo and 1 == 1) {
                    layerData.addLast(node.`val`)
                } else {
                    // 倒序插入
                    layerData.addFirst(node.`val`)
                }
                queue.remove()
                if (node.left?.`val` != null) {
                    queue.add(node.left)
                }
                if (node.right?.`val` != null) {
                    queue.add(node.right)
                }
            }
            array.add(layerData)
            layerNo++
        }
        return array
    }

    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     */
    // 超时
    fun verifyPostorder(postorder: IntArray): Boolean {
        return verifyPostorder(postorder, 0, postorder.size - 1)
    }

    fun verifyPostorder(postorder: IntArray, start: Int, end: Int): Boolean {
        if (start == end || start < 0 || end < 1) {
            return true
        }
        var mid = end - 1
        while (mid >= 0 && postorder[mid] > postorder[end]) {
            mid --
        }
        mid++
        for (index in start until mid) {
            if (postorder[index] > postorder[end]) {
                return false
            }
        }
        for (index in mid until end) {
            if (postorder[index] < postorder[end]) {
                return false
            }
        }
        return verifyPostorder(postorder, start, mid - 1) && verifyPostorder(postorder, mid, end - 1)
    }

    /**
     * 剑指 Offer 35. 复杂链表的复制
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     */
    // 无kotlin版本

}

/***
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */

class MinStack() {
    var numStack = Stack<Int>()
    var minStack = Stack<Int>()

    fun push(x: Int) {
        numStack.push(x)
        if (minStack.isEmpty()) {
            minStack.push(x)
            return
        }
        val curMin = minStack.peek()
        if (x < curMin) {
            minStack.push(x)
        } else {
            minStack.push(curMin)
        }
    }

    fun pop() {
        numStack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return numStack.peek()
    }

    fun min(): Int {
        return minStack.peek()
    }
}

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */

class Solution34 {

    private val pathList = mutableListOf<List<Int>>()
    private var path = arrayListOf<Int>()

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        recur(root, sum)
        return pathList
    }

    fun recur(root: TreeNode?, sum: Int) {
        if (root == null) {
            return
        }
        var variableSum = sum
        path.add(root.`val`)
        variableSum -= root.`val`
        if (variableSum == 0 && root.left == null && root.right == null) {
            pathList.add(LinkedList(path))
        }
        recur(root.left, variableSum)
        recur(root.right, variableSum)
//        path.removee()
    }
}
