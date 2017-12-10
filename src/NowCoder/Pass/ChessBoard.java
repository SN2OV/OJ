package NowCoder.Pass;

/**
 * Created by SN2OV on 2017/6/7.
 */
public class ChessBoard {
    /*
    题目描述
    请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。

    输入描述:
    输入两个正整数
    输出描述:
    返回结果

    输入例子:
    2
    2
    输出例子:
    6
     */

    /**
     * @param m 纵向
     * @param n 横向
     * @return 综述
     */
    public static int count(int n, int m){
        if(m<1||n<1)
            return 0;
        if(m == 1)
            return n+1;
        if(n == 1)
            return m+1;
        return count(n-1,m)+count(n,m-1);
    }

}
