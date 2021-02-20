package SwordPointOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

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
        QuickSort1(arr, 0, arr.length - 1);
    }

    // 这个是错误的，下面的测试用例无法同时满足
    //    val intArray7 = intArrayOf(3, 30, 34, 5, 9)
    //    val intArray8 = intArrayOf(10, 9)
    public void quickSort(int arr[], int start, int end) {
        int s = start + 1;
        int e = end;
        // 这里注意额
        if (s >= e) {
            return;
        }
        while (s < e) {
            while (arr[e] > arr[start] && s <= e) {
                e --;
            }
            while (arr[s] < arr[start] && s <= e) {
                s ++;
            }
            if (s <= e) {
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

    // https://www.cnblogs.com/nullzx/p/5880191.html
    public void QuickSort1(int[] A, int L, int R){
        if(L < R){//递归的边界条件，当 L == R时数组的元素个数为1个
            int pivot = A[L];//最左边的元素作为中轴，L表示left, R表示right
            int i = L+1, j = R;
            //当i == j时，i和j同时指向的元素还没有与中轴元素判断，
            //小于等于中轴元素，i++,大于中轴元素j--,
            //当循环结束时，一定有i = j+1, 且i指向的元素大于中轴，j指向的元素小于等于中轴
            while(i <= j){
                while(i <= j && A[i] <= pivot){
                    i++;
                }
                while(i <= j && A[j] > pivot){
                    j--;
                }
                //当 i > j 时整个切分过程就应该停止了，不能进行交换操作
                //这个可以改成 i < j， 这里 i 永远不会等于j， 因为有上述两个循环的作用
                if(i < j){
                    swap(A, i, j);
                    i++;
                    j--;
                }
            }
            //当循环结束时，j指向的元素是最后一个（从左边算起）小于等于中轴的元素
            swap(A, L, j);//将中轴元素和j所指的元素互换
            QuickSort1(A, L, j-1);//递归左半部分
            QuickSort1(A, j+1, R);//递归右半部分
        }
    }

    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     *
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */

    public class Solution46 {

        int resultMemo[] = new int[32];

        public int translateNum(int num) {
            // f(n) = f(n - 1) + f(n - 2) a[n-1]a[n] 10-26之间
            // f(n) = f(n - 1)
            resultMemo[0] = 1;
            for (int i = 1; i <= String.valueOf(num).length(); i ++) {
                translateNum(num, i);
            }
            return resultMemo[String.valueOf(num).length()];
        }

        public void translateNum(int num, int n) {
            String numStr = String.valueOf(num);
            int len = numStr.length();
            if (n > len) {
                return;
            }
            if (n == 1) {
                resultMemo[1] = 1;
            } else {
                int combinedNum = Integer.parseInt(numStr.charAt(n - 2) + "") * 10 + Integer.parseInt(numStr.charAt(n - 1) + "");
                if (combinedNum > 9 && combinedNum < 26) {
                    resultMemo[n] = resultMemo[n - 1] + resultMemo[n - 2];
                } else {
                    resultMemo[n] = resultMemo[n - 1];
                }
            }
        }
    }

    /**
     * 剑指 Offer 47. 礼物的最大价值
     *
     *  在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *
     *  输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *
     */


    public int maxValue(int[][] grid) {
        int column = grid[0].length;
        int raw = grid.length;
        int dp[][] = new int[raw][column];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < column; i ++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int j = 1; j < raw; j ++) {
            dp[j][0] = grid[j][0] + dp[j - 1][0];
        }
        for (int i = 1; i < raw; i ++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[raw - 1][column - 1];
    }

    /**
     *  剑指 Offer 48. 最长不含重复字符的子字符串
     *  请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     *  示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    // f(n) = f(n - 1) + 1  when (n - i) > f (n - 1)
    //      = n - i
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp[] = new int[s.length()];
        dp[0] = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int max = dp[0];
        for (int i = 1; i < s.length(); i ++) {
            int lastIndex = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            if (i - lastIndex > dp[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = i - lastIndex;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     *  剑指 Offer 49. 丑数
     *  我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     *   输入: n = 10
     *   输出: 12
     *   解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     *    1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16
     */
    public int nthUglyNumber(int n) {
        // f(n + 1) = min(f(a) * 2, f(b) * 3, f(c) * 5)
        // f(a)为首个乘以2等于f(n)的丑数

        int dp[] = new int[n + 1];
        dp[1] = 1;
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; i ++) {
            int n1 = dp[a] * 2;
            int n2 = dp[b] * 3;
            int n3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n1, n2), n3);
            if (dp[i] == n1) {
                a++;
            }
            if (dp[i] == n2) {
                b++;
            }
            if (dp[i] == n3) {
                c++;
            }
        }
        return dp[n];
    }


    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * 示例:
     *
     * s = "abaccdeff"
     * 返回 "b"
     *
     * s = ""
     * 返回 " "
     *
     */

    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        int arr[] = new int[255];
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            arr[ch] ++;
        }
        for (int i = 0; i < s.length(); i ++) {
            if (arr[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }






















}
