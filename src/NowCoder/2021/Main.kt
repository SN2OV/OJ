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
//    print(nowcoder.findNumberIn2DArray(arrayListOf(), 21))

    val nowcoder2140 = NowCoder21_40()
    //printArray(nowcoder2140.exchange(intArrayOf(1, 3, 5)))

    val listNode = ListNode(1)
    val listNode2 = ListNode(2)
    val listNode3 = ListNode(3)
    val listNode4 = ListNode(4)
    val listNode5 = ListNode(5)
    listNode.next = listNode2
    listNode2.next = listNode3
    listNode3.next = listNode4
    listNode4.next = listNode5

    listNode4.next = listNode5
    //printListNode(nowcoder2140.mergeTwoLists(listNode, listNode2))

    val treeNodeA = TreeNode(1)
    var treeNodeB = TreeNode(1)
    val treeNode2 = TreeNode(2)
    val treeNode3 = TreeNode(3)
    val treeNode4 = TreeNode(4)
    val treeNode5 = TreeNode(5)
    val treeNode6 = TreeNode(6)
    val treeNode7 = TreeNode(2)
    treeNodeA.left = treeNode2
    treeNode2.left = treeNode3
    treeNodeA.right = treeNode4
    treeNode4.left = treeNode5

    treeNodeB.left = treeNode7
    treeNode7.left = treeNode6
    treeNodeB.right = treeNode4
    treeNode4.left = treeNode5
    nowcoder2140.mirrorTree(treeNodeA)
}
