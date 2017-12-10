package NowCoder.Pass;

/**
 * Created by SN2OV on 2017/6/8.
 *
 * 题目描述
     验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
     例如：
     1^3=1
     2^3=3+5
     3^3=7+9+11
     4^3=13+15+17+19

     接口说明
     原型：

     功能: 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
     原型：
     int GetSequeOddNum(int m,char * pcSequeOddNum);
     输入参数：
     int m：整数(取值范围：1～100)

     返回值：
     m个连续奇数(格式：“7+9+11”);

    输入例子:
    6

    输出例子:
    31+33+35+37+39+41
 *
 */
public class SquareOddNum {

    public static String GetSequeOddNum(int n){
        if(n<1||n>100)
            return null;
        int num = n * n * n;
        /*
        2^3 = 3+5
        3^3 = 7+9+11
        4^3 = 13+15+17+19
        5^3 = 21+23+25+27+29
        6^3 = 31+33+35+37+39+41
        n为奇数：n^3 = n^2*n
        n为偶数：n^3 = n^2*n = (n^2-1)+(n^2+1)+...一共n个
         */
        int start = 0,end = 0;
        String result = "";
        start = n*n - (n-1);
        end = n*n + (n-1);
        for(int i=start;i<=end;i=i+2){
            if(i == end)
                result = result + i;
            else
                result = result + i + "+";
        }
        return result;
    }

}
