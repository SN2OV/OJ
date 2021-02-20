package SwordPointOffer.`2021`

import SwordPointOffer.SwordPointOffer40_60

/**
 * Created by fan on 21-1-14
 */

fun main(args: Array<String>) {

    val nowcoder = NowCoder1_20()
    val intArray = intArrayOf(1, 3, 1)
    val intArray2 = intArrayOf(1, 5, 1)
    val intArray3 = intArrayOf(4, 2, 1)
    val intArray4 = intArrayOf(10, 13, 14, 17, 24)
    val intArray5 = intArrayOf(18, 21, 23, 26, 30)
    val intArray6 = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val intArray7 = intArrayOf(3, 30, 34, 5, 9)
    val intArray8 = intArrayOf(9, 10)
    val intArray9 = intArrayOf(13, 14, 15, 16)
    val arrays = arrayListOf(intArray, intArray2, intArray3)
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

    treeNodeB.left = treeNode4
    treeNode4.right = treeNode6
    treeNodeB.right = treeNode2
    treeNode2.right = treeNode3
    val charArray = charArrayOf('a', 'b', 'c', 'e')
    val charArray2 = charArrayOf('s', 'f', 'e', 's')
    val charArray3 = charArrayOf('a', 'd', 'e', 'e')
    val board = arrayOf(charArray, charArray2, charArray3)

    // print(Solution34().pathSum(treeNodeA, 6))

    val sword = SwordPointOffer40_60()
    // intArray7和intArray8 不能同时满足..
    sword.quickSort(intArray7)
    // printArray(intArray7)
    val solution46 = sword.Solution46()
    val array = arrayOf(intArray, intArray2, intArray3)
    print(sword.firstUniqChar("cc"))
}
