package LeetCode.Tree;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by SN2OV on 2017/7/25.
 */
public class BasicTreeAlgo {

    //建立二叉树存储结构
    public BTree createTree(BTree BTree){
        int data;
        if(BTree == null)
            BTree = new BTree();
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        if(val == 0)
            BTree = null;
        else{
            BTree.val = val;
            //之前返回为null， 调用createTree(BTree.lchild)
            BTree.lchild = createTree(BTree.lchild);
            BTree.rchild = createTree(BTree.rchild);
        }
        return BTree;
    }

    public BTree initTree(){
        BTree root = new BTree(1);
        BTree node2 = new BTree(2);
        BTree node3 = new BTree(3);
        BTree node4 = new BTree(4);
        BTree node5 = new BTree(5);
        BTree node6 = new BTree(6);
        root.setLchild(node2);
        root.setRchild(node3);
        node2.setRchild(node4);
        node3.setLchild(node5);
        node5.setLchild(node6);
        return root;
    }

    public BTree initTree2(){
        BTree root = new BTree(11);
        BTree node2 = new BTree(22);
        BTree node3 = new BTree(33);
        BTree node4 = new BTree(44);
        BTree node5 = new BTree(55);
        root.setLchild(node2);
        root.setRchild(node3);
        node2.setRchild(node4);
        node3.setLchild(node5);
        return root;
    }

    //求二叉树中叶节点的数目
    //即左子树叶节点和右子树叶节点之和
    public int countLeaf(BTree tree){
        if(tree == null)
            return 0;
        if(tree.lchild==null&&tree.rchild==null)
            return 1;
        return countLeaf(tree.lchild)+countLeaf(tree.rchild);
    }

    //求二叉树的深度
    //返回左子树和有子树的深度的最大值
    public int countDepth(BTree bTree){
        if(bTree == null)
            return 0;
        //这个判定没必要，因为在null哪里已经包含进去了
//        if(bTree.lchild == null && bTree.rchild ==null)
//            return 1;
        int lchildDepth = countDepth(bTree.lchild);
        int rchildDepth = countDepth(bTree.rchild);
        return lchildDepth>rchildDepth?lchildDepth+1:rchildDepth+1;
    }

    //递归前序遍历
    public void preorderRecursion(BTree bTree){
        if(bTree == null)
            return;
        System.out.print(bTree.val + " ");
        preorderRecursion(bTree.lchild);
        preorderRecursion(bTree.rchild);
    }

    //非递归前序遍历
    public void preorderNonRecursion(BTree tree){
        BTree p = tree;
        if(tree == null)
            return;
        Stack<BTree> stack = new Stack<>();
        while(!(stack.isEmpty()&&p==null)){
            while(p!=null){
                System.out.print(p.val + " ");
                stack.push(p);
                p = p.lchild;
            }
            p = stack.peek();
            stack.pop();
            p = p.rchild;
        }
    }

    //非递归中序遍历
//    public void inorderNonRecursion(BTree bTree){
//        if(bTree == null)
//            return;
//        Stack<BTree> stack = new Stack<BTree>();
//        stack.push(bTree);
//        while(!stack.isEmpty()){
//            //栈顶元素
//            BTree p = stack.lastElement();
//            while (p.lchild != null){
//                stack.push(p.lchild);
//                p = p.lchild;
//            }
//            BTree node = stack.pop();
//            System.out.print(node.val + " ");
//            if(node.rchild!= null)
//               stack.push(node.rchild);
//        }
//    }

    //非递归中序遍历
    public void inorderNonRecursion(BTree bTree){
        if(bTree == null)
            return;
        Stack<BTree> stack = new Stack<BTree>();
        BTree p = bTree;
        while(!(stack.isEmpty()&& p==null)){
            //栈顶元素
            while (p != null){
                stack.push(p);
                p = p.lchild;
            }
            p = stack.pop();
            System.out.print(p.val + " ");
            p = p.rchild;
        }
    }
    //非递归后序遍历
    public void postorderNonRecursion(BTree bTree){
        if(bTree == null)
            return;
        BTree p = bTree;
        Stack<BTree> nodeStack = new Stack<>();
        Stack<Boolean> statusStack = new Stack<>();
        while (!(nodeStack.isEmpty()&&p==null)){
            while (p!=null){
                nodeStack.push(p);
                statusStack.push(false);
                p = p.lchild;
            }
            p = nodeStack.pop();
            if(statusStack.pop()){
                System.out.print(p.val + " ");
                //这句话想了半天
                p = null;
            }else{
                nodeStack.push(p);
                statusStack.push(true);
                p = p.rchild;
            }
        }
    }

    //层次遍历
    public void layerOrder(BTree bTree){
        if(bTree == null)
            return;
        //注意队列的初始化，要用LinkedList
        Queue<BTree> queue = new LinkedList<>();
        BTree p = bTree;
        queue.add(bTree);
        while(!(queue.isEmpty())){
            //记住用法poll为出队，peek为查看队首
            p = queue.poll();
            System.out.print(p.val + " ");
            if(p.lchild != null)
                queue.add(p.lchild);
            if(p.rchild != null)
                queue.add(p.rchild);
        }

    }

    //二叉树相似
    public Boolean isSimilarOf2Trees(BTree bTree1,BTree bTree2){
        if(bTree1 == null && bTree2 == null)
            return true;
        //之前一直陷入这么写的泥潭里，递归不一定写在return里面的，这里写在if语句中
//        return isSimilarOf2Trees(bTree1.lchild,bTree2.lchild)&&isSimilarOf2Trees(bTree1.rchild,bTree2.rchild);
        if(bTree1 !=null && bTree2 !=null &&isSimilarOf2Trees(bTree1.lchild,bTree2.lchild) && isSimilarOf2Trees(bTree1.rchild,bTree2.rchild))
            return true;
        return false;
    }

    //二叉树的复制
    public BTree copyBT(BTree bTree){
        BTree newBTree = new BTree();
        if(bTree == null)
            return null;
        newBTree.setVal(bTree.val);
        newBTree.lchild = copyBT(bTree.lchild);
        newBTree.rchild = copyBT(bTree.rchild);
        return newBTree;
    }

    //二叉树等价
    public Boolean isEqualOf2Trees(BTree bTree1,BTree bTree2){
        if(bTree1 == null && bTree2 == null)
            return true;
        if(bTree1!=null && bTree2!=null && bTree1.val==bTree2.val &&isEqualOf2Trees(bTree1.lchild,bTree2.lchild)
                &&isEqualOf2Trees(bTree1.rchild,bTree2.rchild))
            return true;
        return false;
    }

    //非递归二叉树深度
    //求每个结点的深度，放在栈里面
    public int countDepthNonRecursion(BTree bTree){
        if(bTree == null)
            return 0;
        Stack<BTree> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        BTree p = bTree;
        int depth = 0 ,maxDepth = 0;
        while (!(stack.isEmpty()&&p==null)){
            if(p == null)
                depth --;
            while (p!=null){
                stack.push(p);
                depthStack.push(++depth);
                p = p.lchild;
            }
            p = stack.pop();
            //之前没用栈暂存深度，导致出错
            depth = depthStack.pop();
            if(depth > maxDepth)
                maxDepth = depth;
            p =p.rchild;

        }
        return maxDepth;
    }

    //求结点所在的层次,和上面的算法一样，区别就在上面求最大，下面的根据item判断返回
    public int getLayerNo(BTree bTree,int item){
        if(bTree == null)
            return 0;
        Stack<BTree> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        BTree p = bTree;
        int depth = 0 ,maxDepth = 0;
        while (!(stack.isEmpty()&&p==null)){
            if(p == null)
                depth --;
            while (p!=null){
                stack.push(p);
                depthStack.push(++depth);
                p = p.lchild;
            }
            p = stack.pop();
            depth = depthStack.pop();
            if(p.val == item)
                return depth;
            p =p.rchild;

        }
        return -1;
    }

    public int getLayerNoWithRecursion(BTree bTree,int item){
        if(bTree == null)
            return 0;
        if(item == bTree.val)
            return 1;
        int depth = Math.max(getLayerNoWithRecursion(bTree.lchild,item)+1,getLayerNoWithRecursion(bTree.rchild,item));
        return 0;
    }

    //交换所有节点左右子树的位置
    //相当于左、右子树分别交换位置后，两者再交换位置
    //书中用的是层次遍历，和层次遍历访问区别：在结点出队时对左右子树调换位置，而不是获取值
    public BTree exchangeBT(BTree bTree){
        if(bTree == null)
            return null;
        if(bTree.lchild==null&&bTree.rchild==null)
            return bTree;
        BTree temp = exchangeBT(bTree.lchild);
        bTree.setLchild(exchangeBT(bTree.rchild));
        bTree.setRchild(temp);
        return bTree;
    }

    //交换结点子树位置，剑指offer的方法，其实就是先序遍历
    public void exchangeBT2(BTree bTree){
        if(bTree == null)
            return;
        if(bTree.lchild==null&&bTree.rchild==null)
            return;
        BTree temp = bTree.lchild;
        bTree.lchild = bTree.rchild;
        bTree.rchild = temp;
        if(bTree.lchild!=null)
            exchangeBT2(bTree.lchild);
        if(bTree.rchild!=null)
            exchangeBT2(bTree.rchild);
    }

    //TODO 二叉树删除每个结点及其子树
    public void deleteBT(BTree bTree,int item){

    }

}
