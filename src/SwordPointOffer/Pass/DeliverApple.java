package SwordPointOffer.Pass;

/**
 * Created by SN2OV on 2017/6/7.
 */
public class DeliverApple {
    /*
    题目描述
    把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。

    输入
    每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。

    样例输入
    7 3

    样例输出
    8

    public static int count(int m, int n)
    输出描述:
    输出结果，int型

    输入例子:
     7 3

    输出例子:
    8
    */

        /*
    解题思路：（递归）
    放苹果分为两种类别：至少有一个盘子为空，和所有盘子都不为空
    1）至少有一个盘子为空
    (m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
    2）所有盘子都不为空
    所有盘子至少有一个苹果，我们不妨每个盘子都放一个苹果，即求(m-n,n)即可
    记着边界条件，m<0时返回0，只有一个苹果或只有一个盘子时返回1
     */

    /**
     * @param m 苹果数
     * @param n 盘子数
     * @return 放苹果方法数目
     */
    public static int count(int m, int n){
        if(m < 0)
            return 0;
        if(m == 1||n ==1)
            return 1;
        return count(m,n-1)+count(m-n,n);
    }

}
