package SwordPointOffer.Pass;

/**
 * Created by SN2OV on 2017/6/10.
 * 题目描述

     1

     1  1  1

     1  2  3  2  1

     1  3  6  7  6  3  1

     1  4  10 16 19  16 10  4  1

     以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。

     求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。


     输入n(n <= 1000000000)
     输入描述:
     输入一个int整数

     输出描述:
     输出返回的int值

     输入例子:
     4

     输出例子:
     3
 */
public class YangHuiTriangleX
{
      /*     1 2 3 4 5 6 7 8 9 10 11
          1  0 0 1 0 0 0 0 0 0 0 0 0 0
          2  0 0 1 1 1 0 0 0 0 0 0 0 0
          3  0 0 1 2 3 2 1 0 0 0 0 0 0
          4  0 0 1 3 6 7 6 3 1 0 0 0 0
          5  0 0 1 4 10 16 19 16 10 4 1
     */
    /*
    a[i,3] = a[i-1,1] + a[i-1,2] + a[i-1,3]
     */

    public static int getNum(int m ,int n){
        if(m<1||n<1)
            return 0;
        else if(m==1&&n==1)
            return 1;
        else if(n>2*m-1)
            return 0;
        return getNum(m-1,n-2)+getNum(m-1,n-1)+getNum(m-1,n);
    }

    //求第n行的第一个偶数
    public static int getYanghuiTriangleNum(int n){
        for(int i=1;i<=n;i++){
            if(getNum(n,i)%2 == 0)
                return i;
        }
        return -1;
    }
}
