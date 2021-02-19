package SwordPointOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by fan on 21-2-19
 */
public class SwordPointOffer40_60 {


    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     *
     * 要求时间复杂度为O(n)。
     *
     * 示例1:
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     */

    public int maxSubArray(int[] nums) {
        // f(n)返回第n个结尾的最大值
        // f(n) = f(n - 1) + nums[n]  f(n - 1) > 0
        // f(n) = nums[n] f(n - 1) <= 0
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int maxNums[] = new int[nums.length];
        maxNums[0] = nums[0];
        int max = maxNums[0];
        for (int index = 1; index < nums.length; index++) {
            if (maxNums[index - 1] <= 0) {
                maxNums[index] = nums[index];
            } else {
                maxNums[index] = maxNums[index - 1] + nums[index];
            }
            max = Math.max(max, maxNums[index]);
        }
        return max;
    }

    /**
     *
     * 剑指 Offer 44. 数字序列中某一位的数字
     *
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     * 请写一个函数，求任意第n位对应的数字。
     *
     * 示例 1：
     * 输入：n = 3
     * 输出：3
     *
     * 示例 2：
     * 输入：n = 11
     * 输出：0
     *
     */

    public int findNthDigit(int n) {
        // 1-9 10-99 100-999
        // 第一次做时一个一个的遍历了，应该相同位数的合一
        return 0;
    }

    /**
     * 剑指 Offer 45. 把数组排成最小的数
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     * 示例 1:
     * 输入: [10,2]
     * 输出: "102"
     *
     * 示例 2:
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     *
     *
     */

    public String minNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int index = 0; index < nums.length; index ++) {
            numStrs[index] = nums[index] + "";
        }
        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        String result = "";
        for (int index = 0; index < numStrs.length; index++) {
            result += numStrs[index];
        }
        return result;
    }

    public void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    // 2 3 1 5 4
    public void quickSort(int arr[], int start, int end) {
        int s = start + 1;
        int e = end;
        // 这里注意额
        if (s > e) {
            return;
        }
        while (s < e) {
            while (arr[e] > arr[start] && e != start) {
                e --;
            }
            while (arr[s] < arr[start] && s != end) {
                s ++;
            }
            if (s < e) {
                swap(arr, s, e);
            }
        }
        swap(arr, start, e);
        quickSort(arr, start, e - 1);
        quickSort(arr, e + 1, end);
    }

    public void swap(int arr[], int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

}
