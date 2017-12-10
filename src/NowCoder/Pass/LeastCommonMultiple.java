package NowCoder.Pass;

/**
 * Created by SN2OV on 2017/6/9.
 */
public class LeastCommonMultiple {

    /*
    题目描述
    正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。

    输入描述:
    输入两个正整数A和B。

    输出描述:
    输出A和B的最小公倍数。

    输入例子:
    5
    7

    输出例子:
    35
     */

     /*
          4,6=12  4*6/2
          8,12=24 8*12/4
     */

    //辗转相除，先求最大公约数，然后
    public static int GetLeastCommonMul(int m,int n){
        int orignM = m,orignN = n;
        while(m % n !=0){
            int temp = n;
            n = m % temp;
            m = temp;
        }
        return orignM*orignN/n;
    }
}
