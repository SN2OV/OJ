package LeetCode.Tree;

/**
 * Created by SN2OV on 2017/7/25.
 */
public class BTree {
    int val;
    BTree lchild,rchild;
    public BTree(){
        lchild = null;
        rchild = null;
    }

    public BTree(int val){
        this.val = val;
        lchild = null;
        rchild = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BTree getLchild() {
        return lchild;
    }

    public void setLchild(BTree lchild) {
        this.lchild = lchild;
    }

    public BTree getRchild() {
        return rchild;
    }

    public void setRchild(BTree rchild) {
        this.rchild = rchild;
    }
}
