package NowCoder.`2021`

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

}