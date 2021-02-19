package SwordPointOffer.Pass;

import java.util.ArrayList;

/**
 * Created by SN2OV on 2017/6/8.

     题目描述

     完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。

     它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。

     例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。

     给定函数count(int n),用于计算n以内(含n)完全数的个数。计算范围, 0 < n <= 500000

     返回n以内完全数的个数。 异常情况返回-1


     *  完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。

     *  它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。

     *  例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。

     *

     *  给定函数count(int n),用于计算n以内(含n)完全数的个数

     * @param n  计算范围, 0 < n <= 500000

     * @return n 以内完全数的个数, 异常情况返回-1

        输入描述:
        输入一个数字

        输出描述:
        输出完全数的个数

        输入例子:
        1000

        输出例子:
        3
        */
public class PerfectNumber {
    public static int getPerfectnumCount(int n){
        if(n<1||n>500000)
            return -1;
        int sum = 0;
        for(int i=1;i<=n;i++)
            sum+=isPerfectNum(i)?1:0;
        return sum;
    }

    public static Boolean isPerfectNum(int n){
        ArrayList<Integer> factorsArr = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(n % i == 0)
                factorsArr.add(i);
        }
        int sum = 0;
        for(int factor : factorsArr)
            sum += factor;
        return n==sum;
    }
}
