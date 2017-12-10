package NowCoder.Pass;

import java.util.Scanner;

/**
 * Created by SN2OV on 2017/6/7.
 * 题目描述

 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。

 输入参数：

 inputString：输入的字符串

 返回值：

 输出转换好的逆序字符串

 输入描述:

 输入一个字符串，可以有空格

 输出描述:

 输出逆序的字符串

 输入例子:

 I am a student

 输出例子:

 tneduts a ma I


 */
public class CharacterReverse {
    public static int getCharacterReversed() {
        String input = new Scanner(System.in).nextLine();
        char[] inputCharArr = input.toCharArray();
        char temp = ' ';
        for(int i=0;i<input.length()/2;i++){
            temp = inputCharArr[i];
            inputCharArr[i] = inputCharArr[input.length()-i-1];
            inputCharArr[input.length()-i-1] = temp;
        }
        System.out.println(inputCharArr);
        return 0;
    }
}



