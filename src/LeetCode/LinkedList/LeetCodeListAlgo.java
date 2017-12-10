package LeetCode.LinkedList;

import javax.security.auth.Subject;

/*
  Created by SN2OV on 2017/7/27.
 */
public class LeetCodeListAlgo {

    /*
    描述
        You are given two linked lists representing two non-negative numbers. The digits are stored in reverse
        order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
     */
    //leetCode上面解法优化，循环结束条件为两个指针都为空，计算时如果指针为空则记为0
    //本题解法好像没有考虑list1和list2同时为null的时候
    public LinkList addTwoNumbers(LinkList list1,LinkList list2){
        LinkList list = null,p=list;
        int carry = 0;
        while(list1!=null&&list2!=null){
            int sum = list1.val + list2.val + carry;
            if(sum>9){
                carry = 1;
                sum -= 10;
            }else
                carry = 0;
            LinkList node = new LinkList(sum);
            //这里可以优化，初始化为-1,每次都尾插不用判断是否为null,最后返回list.next
            if(p == null){
                //这里开始错了，注意需要列表最后需要返回表头，所以不能跟着遍历，设置好表头指针后，使用另一个遍历指针
                //去执行next
                list = node;
                p = node;
            }
            else{
                p.next = node;
                p = p.next;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        while(list1!=null){
            int sum = carry + list1.val;
            if(sum>9){
                carry = 1;
                sum -= 10;
            }else
                carry = 0;
            LinkList node = new LinkList(sum);
            p.next = node;
            list1 = list1.next;
            p = p.next;
        }
        while(list2!=null){
            int sum = carry + list2.val;
            if(sum>9){
                carry = 1;
                sum -= 10;
            }else
                carry = 0;
            LinkList node = new LinkList(sum);
            list.next = node;
            p = p.next;
            list2 = list2.next;
        }
        return list;
    }

    /*
    2.2.2 Reverse Linked List II
        描述
        Reverse a linked list from position m to n. Do it in-place and in one-pass.
        For example: Given 1->2->3->4->5->nullptr, m = 2 and n = 4,
        return 1->4->3->2->5->nullptr.
        Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
        分析
        这题非常繁琐，有很多边界检查， 15 分钟内做到 bug free 很有难度！
     */
    //只是做了，花了不少时间，没有验证，感觉确实很繁琐...用的是书中反转全部单链表的思路，遍历过去，依次改方向
    //很繁琐，采用新的方法吧：第一步是找到m结点所在位置，第二步就是进行反转直到n结点。反转的方法就是每读到一个结点，
    // 把它插入到m结点前面位置，然后m结点接到读到结点的下一个。总共只需要一次扫描，所以时间是O(n)
    public LinkList reverseBetween(LinkList list , int start , int end){
        if(list == null||start>end||end<1)
            return null;
        LinkList pStart=null,pEnd,p=list,pPrev=null,pStartPrev=null;
        for(int i=0;i<end-1;i++){
            if(i==start-1){
                pStart = p;
                pStartPrev = pPrev;
            }
            pPrev = p;
            p = p.next;
        }
        pEnd = p;
        pStart.next = pEnd.next;
        pStartPrev.next = pEnd;
        LinkList temp ;
        //调换
//        pStart = pStart.next;
        while(pStart!=pEnd.next){
            temp = pStart;
            temp.next = pStartPrev;
            pStartPrev = temp;
            pStart = pStart.next;
        }
        return list;
    }

    /*
    2.2.5 Remove Duplicates from Sorted List II
        描述
        Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
        from the original list.
        For example,
        Given 1->2->3->3->4->4->5, return 1->2->5.
        Given 1->1->1->2->3, return 2->3.
     */
    public LinkList removeDuplicates(LinkList list){
        if(list == null)
            return null;
        LinkList p = list.next,q=list,prev;
        while(p!=null){
            prev = q;
            if(q.val == p.val){
                p = p.next;
            }else{
                p = p.next;
                q = q.next;
            }

        }
        return list;
    }

    /*
    2.2.8 Swap Nodes in Pairs
        描述
        Given a linked list, swap every two adjacent nodes and return its head.
        For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
        Your algorithm should use only constant space. You may not modify the values in the list, only nodes
        itself can be changed.
     */
    public LinkList swapNodes(LinkList list){
        if(list == null||list.next==null)
            return list;
        LinkList pPrev = list,pCur = list.next;
        LinkList tempPrev = list,tempCur = list.next;
        LinkList pHead = new LinkList(-1);
        pHead.next = tempCur;
        while (pCur!=null){
            tempPrev = pPrev;
            tempCur = pCur;
            pPrev = pPrev.next==null?null:pPrev.next.next;
            pCur = pCur.next==null?null:pCur.next.next;
            tempCur.next = tempPrev;
            tempPrev.next = pCur;
        }
        if(pPrev!=null)
            tempPrev.next = pPrev;
        return pHead.next;
    }

}
