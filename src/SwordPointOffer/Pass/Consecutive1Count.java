package SwordPointOffer.Pass;

/**
 * Created by SN2OV on 2017/6/13.
 *
 * 题目描述
 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 输入: 一个byte型的数字

 输出: 无
 返回: 对应的二进制数字中1的最大连续数
 输入描述:
 输入一个byte数字
 输出描述:
 输出转成二进制之后连续1的个数
 输入例子:
 3
 输出例子:
 2
 */
public class Consecutive1Count {
    public static int getCountOfOne(int n){
        int count = 0,maxCount = 0;
        while (n!=0){
            if(n%2==1){
                count++;
            }else{
                count = 0;
            }
            if(count > maxCount)
                maxCount = count;
            n /=2;
        }
        return maxCount;
    }
}
