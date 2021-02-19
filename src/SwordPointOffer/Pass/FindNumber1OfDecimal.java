package SwordPointOffer.Pass;

/**
 * Created by SN2OV on 2017/6/10.
 */
public class FindNumber1OfDecimal {
    /**
     * 寻找10进制对应二进制中1的个数
     * @param n
     * @return
     */
    public static int findNumberOf1(int n){
        int count = 0,remainder;
        while(n != 0){
            remainder  = n%2;
            if(remainder % 2 ==1)
                count++;
            n = n/2;
        }
        return count;
    }

    /**
     * 10进制转换为二进制
     * @param n
     * @return
     */
    public static int decimalToBinary(int n){
        int remainder,sum=0,i=0;
        while(n != 0){
            remainder  = n%2;
            n = n/2;
            sum = sum +  remainder * (int)Math.pow(10,i);
            i++;
        }
        return sum;
    }
}
