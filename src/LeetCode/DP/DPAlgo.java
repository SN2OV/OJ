package LeetCode.DP;

import java.util.ArrayList;

/**
 * Created by SN2OV on 2017/8/31.
 */
public class DPAlgo {

    //最大连续子序列和
    /*
    -23 17 -7 11 -2 1 -34
    a
     */
    public static int subSerialSum(ArrayList<Integer> arr){
        int curSum = arr.get(0),len =arr.size(),maxSum=arr.get(0);
        for(int i=1;i<len;i++){
            if(curSum<0){
                curSum = arr.get(i);
            }else{
                curSum = curSum + arr.get(i);
                if(maxSum < curSum)
                    maxSum = curSum;
            }
        }
        return maxSum;
    }


    //求坐标轴上的最大点
    public static void getArrPrint(int arr[][]){
        //思路，（xi,yi）为最大的情况是，所有x轴比它大的y轴都比它小
        ArrayList<Integer> maxArr = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            Boolean flag = true;
            int xi = arr[i][0];
            int yi = arr[i][1];
            for(int j=i+1;j<arr.length;j++){
                //存在x轴比xi大且y轴比yi大的，则（xi,yi）不是最大点
                if(arr[j][1]<yi){
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag)
                maxArr.add(i);
        }
        for(int index : maxArr){
            System.out.println(arr[index][0]+""+arr[index][1]);
        }

    }

}
