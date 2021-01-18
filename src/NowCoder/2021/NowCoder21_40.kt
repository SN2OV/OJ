package NowCoder.`2021`

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
        return false
    }

}