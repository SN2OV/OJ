package LeetCode.Algo;

import java.util.Arrays;

/**
 * Created by SN2OV on 2017/8/17.
 */
public class DP {
    /*
    给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
     */
    /*
    dp[i][sum] = dp[i-1][sum - 0*Vm] + dp[i-1][sum - 1*Vm]

    + dp[i-1][sum - 2*Vm] + ... + dp[i-1][sum - K*Vm]; 其中K = sum / Vm
     */
    public static int getCoinsMethod(int money){
        int coins[] = {1,5,10,20,50,100};
        //int dp[i][j] 前i种钱币，组成j元的方法，i/j可以取0所以定义数组时应该加1
        int dp[][]=new int[7][10001];
        for(int i=0;i<=6;i++){
            Arrays.fill(dp[i],0);
            //注意dp[i][0]=13
            dp[i][0]=1;
        }
        //注意等号
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=money;j++){
                //注意这里应该是i-1，因为是第i个硬币
                for(int k=0;k<=j/coins[i-1];k++){
                    dp[i][j]+=dp[i-1][j-k*coins[i-1]];
                }
            }
        }
        return dp[6][money];
    }
}
