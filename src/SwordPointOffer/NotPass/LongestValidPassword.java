package SwordPointOffer.NotPass;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by SN2OV on 2017/6/12.
 */
public class LongestValidPassword {
    //第一次尝试没考虑小对称序列被大对称序列包含的情况如：13422566522431
    //第二次尝试，在第一中情况下出栈统计完最大长度后再依次进栈，还原最初状态
    //结果这两次尝试都忽略了奇数的情况。。
    //应该类比求最长公共子序列，即将字符串反转，转化为求两个字符串的最长公共子字符串(使用动态规划吧)
    /*
    51233214

    312245542213
     */
    public static int calculateSum(String expression){
        int count =0,maxCount =0;
        ArrayList<Character> tempArr = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char pushItem = expression.charAt(i);
            if(stack.size() == 0){
                stack.push(pushItem);
                continue;
            }
            char peek = stack.peek();
            stack.push(pushItem);
            if(peek==pushItem){
                count ++;
                tempArr.add(peek);
                stack.pop();
                stack.pop();
                if(count >maxCount)
                    maxCount = count;
            }
            if(count >0){
                //把之前出栈的元素复原
                for(int j=1;j<=tempArr.size();j++)
                    stack.push(tempArr.get(tempArr.size()-j));
                for(int j=1;j<=tempArr.size();j++)
                    stack.push(tempArr.get(j-1));
                tempArr = new ArrayList<>();
                count = 0;
            }
        }
        return maxCount*2;
    }
}
