package SwordPointOffer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by SN2OV on 2017/8/22.
 */
public class NotUsed {
    public static void printRandom(int n){
        ArrayList<Integer> numArr = new ArrayList<>();
        ArrayList<Integer> srcArr = new ArrayList<>();
        for(int i=1;i<=n;i++)
            srcArr.add(i);
        while(n>0){
            int num = (int)(new Random().nextInt(n));
            numArr.add(srcArr.get(num));
            srcArr.remove(num);
            n--;
        }
        for(int i:numArr)
            System.out.print(i + " ");
    }

    public static int getMaxArea(){
        int n[] = new int[]{2,1,5,6,2,3};
        for(int i=0;i<n.length;i++){
            for(int j=i;j<n.length;j++){

            }
        }
        return 0;
    }

    public static int getMaxCountOfSubstr(String str1,String str2){
        int i=0,j=0,maxCount=0,count=0;
        while(i<str1.length()){
            if(str1.charAt(i)==str2.charAt(j)){
                i++;
                j++;
                count++;
                if(count>maxCount)
                    maxCount = count;
            }else{
                count = 0;
                j=0;
                i++;
            }
        }
        return maxCount;
    }


    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
        RandomListNode(){this.next =null;}
    };

//    public RandomListNode copyRandomList(RandomListNode head) {
//        RandomListNode randomListNode = new RandomListNode(1);
//        return copiedRandomListNode;
//    }

    public static RandomListNode copyList(RandomListNode head){
        //一定要弄两个指针！！一个用来存放head
        RandomListNode list = new RandomListNode(0);
        RandomListNode s = list;
        s.label = head.label;
        if(head == null)
            return null;
        while(head.next != null){
            s.label = head.label;
            RandomListNode newNode = new RandomListNode();
            s.next = newNode;
            head = head.next;
            s = s.next;
        }
        return list;
    }

    public static RandomListNode insertNode(RandomListNode head,int label){
        RandomListNode p = head;
        if(p == null)
            return null;
        while(p.next != null){
            p = p.next;
        }
        RandomListNode newNode = new RandomListNode(label);
        p.next = newNode;
        newNode.next = null;
        return head;
    }

    public static void initNode(RandomListNode head){
        int[] arr = new int[]{1,2,3,4,5,6};
        for(int i : arr){
            insertNode(head,i);
        }
    }

    public static void printListInfo(RandomListNode head){
        if(head == null)
            return ;
        while(head.next != null){
            System.out.print(head.label+" ");
            head = head.next;
        }
    }

    public interface A{
        void haha();
    }

    public interface B extends A{
        void hh();
    }

    public interface C extends A,B{

    }
}
