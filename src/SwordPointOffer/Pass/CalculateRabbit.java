package SwordPointOffer.Pass;

/**
 * Created by SN2OV on 2017/6/12.
 *

 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 **
 * 统计出兔子总数。
 *
 * @param monthCount 第几个月
 * @return 兔子总数
 *
    public static int getTotalCount(int monthCount)
        {
        return 0;
        }

        输入描述:

        输入int型表示month
        输出描述:

        输出兔子总数int型
        输入例子:
        9
        输出例子:
        34
        */
public class CalculateRabbit {
    //递推式的解释:对于第n个月的兔子数量：有两部分组成，
    //一部分是上个月的兔子f(n-1)，另一部是满足3个月大的兔子
    public static int calculateRabbit(int n){
        if(n==1||n==2)
            return 1;
        return calculateRabbit(n-1)+calculateRabbit(n-2);
    }
}

/*
注：减少时间复杂度的方法：用数组预存
链接：https://www.nowcoder.com/questionTerminal/1221ec77125d4370833fd3ad5ba72395
来源：牛客网
int arr[100];
    int i,N;
    arr[1]=arr[2]=1;
    arr[3]=2;
    for(i=4;i<100;i++){
        arr[i]=arr[i-1]+arr[i-2];
    }
 */
