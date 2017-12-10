package LeetCode.LinkedList;

import sun.awt.image.ImageWatched;

import javax.sound.sampled.Line;
import java.util.LinkedList;

/**
 * Created by SN2OV on 2017/7/24.
 */
public class BasicListAlgo {

    //创建单链表
    //关键点：设定list为表头并在最终返回，加一个表尾临时变量用于增加结点，初始化置为null即可
    public LinkList createList(int n){
        LinkList list = null,newNode,tailNode =null;
        int arr[] = new int[]{8,3,4,2,1,6,4,7,2,1};
//        for(int i=0;i<n;i++){
        for(int i:arr){
            newNode = new LinkList();
            newNode.val = i;
            newNode.next = null;
            if(list == null)
                list = newNode;
            else
                tailNode.next = newNode;
            tailNode = newNode;
        }
        return list;
    }

    public LinkList createList(int arr[]){
        LinkList list = null,newNode,tailNode =null;
        for(int i:arr){
            newNode = new LinkList();
            newNode.val = i;
            newNode.next = null;
            if(list == null)
                list = newNode;
            else
                tailNode.next = newNode;
            tailNode = newNode;
        }
        return list;
    }

    //求链表长度
    //之前弄的时候，把linkList == null单独判断，其实没必要
    //快速实现方法 return 1 + getLinkListLen(linkList.next);
    public int getLinkListLen(LinkList linkList){
        //此类题都要设置临时变量，最好不要修改形参
        LinkList p = linkList;
        int sum = 0;
        while(p != null){
            sum ++;
            p = p.next;
        }
        return sum;
    }

    //在第一个链结点前插入数据信息为item的结点
    //注意返回链表不要返回空，不然看不出来想要的结果，要返回新的表头
    public LinkList insertNodeAtStart(LinkList list ,int item){
        if(list == null)
            return null;
        LinkList newNode = new LinkList();
        newNode.val = item;
        newNode.next = list;
        return newNode;
    }

    //打印结点信息
    public void printListInfo(LinkList list){
        if(list == null)
            return ;
        LinkList p = list;
        while(p != null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }

    //在链表末尾插入
    //注意链表为空时也是可以插值的，需要特殊处理
    public LinkList inserNodeAtEnd(LinkList linkList,int item){
        LinkList newNode = new LinkList();
        newNode.val = item;
        newNode.next = null;
        LinkList p = linkList;
        if(p == null)
            return newNode;
        while (p.next != null){
            p = p.next;
        }
        p.next = newNode;
        return linkList;
    }

    //在q所在链结点的后面插入item
    //注意链表为空的情况
    public LinkList inserNodeAtQ(LinkList linkList,LinkList q,int item){
        if(q == null || linkList == null)
            return linkList;
        LinkList newNode = new LinkList();
        newNode.val = item;
        if(linkList == null){
            newNode.next = null;
            return newNode;
        }
        newNode.next = q.next;
        q.next = newNode;
        return linkList;
    }


    //在第i个结点后面插入item
    public Boolean inserNodeAfterI(LinkList linkList,int i,int item){
        if(i>getLinkListLen(linkList)||i<1)
            return false;
        LinkList p = linkList;
        while(--i>0){
            p = p.next;
        }
        LinkList newNode = new LinkList();
        newNode.val = item;
        newNode.next = p.next;
        p.next = newNode;
        return true;
    }

    //删除线性表中所有值为item结点
    public LinkList delNodeOfItem(LinkList list,int item){
        if(list == null)
            return null;
        while (list.val == item){
            //注意：这里这样操作是无法对调用本函数的list实际产生删除操作的，这里只是对形参指向的地址做出修改
            //这里可以不采用这种先去头部重复的方式，分两步：先从第二个链结点开始处理，最后再处理第一个结点
            list = list.next;
        }
        //这里可以让p先走一步，p= list.next;q= list;
        LinkList p = list,q=null;
        while (p.next!=null){
            if(p.val == item){
                q.next = p.next;
                p.next = q;
            }
            q = p;
            p = p.next;
        }
        return list;
    }

    //逆转线性表
    //注意：形参返回问题
    public LinkList reverseList(LinkList list){
        LinkList p = null,q = list,temp;
        while(q != null){
            temp = q;
            q = q.next;
            temp.next = p;
            p = temp;
        }
        return p;
    }

    //合并两个有序的线性表
    //出错点，没有设置新的线性表的指针结点，从newList上改来改去，导致错误；表头结点时固定的，任何时候不要改
    //不要再用while(p.next != null)了，都改成while(p!=null)吧
    public LinkList mergeLists(LinkList head1,LinkList head2){
        LinkList p = head1,q = head2,newList,r;
        if(head1 == null)
            newList = head2;
        if(head2 == null)
            newList = head1;
        if(head1.val<head2.val){
            newList = head1;
            p = p.next;
        }else{
            newList = head2;
            q = q.next;
        }
        r = newList;
        while (p!=null&&q!=null){
            LinkList node = new LinkList();
            if(p.val<q.val){
                //这里可以优化，不需要每次建立新的结点拷贝值，直接用表中结点即可
//                r.next = p;
//                r=p;
//                p=p.next;
                node.val = p.val;
                node.next = null;
                r.next = node;
                p = p.next;
                r = r.next;
            }else{
                node.val = q.val;
                node.next = null;
                r.next = node;
                q = q.next;
                r = r.next;
            }
        }
        //下面可以进行优化，当其中一个链表为空时，直接把没遍历完的剩余表放到r的后面即可
        while (p!=null){
            LinkList node = new LinkList();
            node.val = p.val;
            node.next = null;
            r.next = node;
            r = r.next;
            p = p.next;
        }
        while (q!=null){
            LinkList node = new LinkList();
            node.val = q.val;
            node.next = null;
            r.next = node;
            r = r.next;
            q = q.next;
        }
        return newList;
    }

    //递归方法赋值链表
    public LinkList copyList(LinkList srcList){
        LinkList desList;
        if(srcList == null)
            return null;
        else {
            desList = new LinkList();
            desList.val = srcList.val;
            desList.next = copyList(srcList.next);
        }
        return desList;
    }

    //将链表中数据值域最大的节点移动到链表末尾
    //这些需要赋值的指针可以直接设成linkList，这样就不需要判空
    //书中的代码写的更好，预设两个节点，一个指向最大值节点，一个指向最大值的前驱
    public LinkList moveMaxNodeToTail(LinkList linkList){
        LinkList p = linkList,q=null,prev=null,tempNode;
        if(p == null)
            return null;
        int max = linkList.val;
        while (p != null){
            if(p.val > max){
                prev = q;
                max = p.val;
            }
            q = p;
            p = p.next;
        }
        if(prev != null){
            if(q.val != max)
                prev.next = prev.next.next;
            else
                return linkList;
        }else{
            linkList = linkList.next;
        }
        LinkList newNode = new LinkList();
        newNode.next = null;
        newNode.val = max;
        q.next = newNode;
        return linkList;
    }

}
