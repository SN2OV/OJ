package LeetCode.Array;

import java.util.*;

/**
 * Created by SN2OV on 2017/7/27.
 */
public class LeetCodeArrAlgo {

    public void printArr(int a[]){
        for(int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

//    Remove Duplicates from Sorted Array
//    For example, Given input array A = [1,1,2],
//    Your function should return length = 2, and A is now [1,2].
    //数组是常量，怎么可能修改，所以最多只能返回新的数组
    public int removeDuplicates(int a[]){
        int temp = a[0];
        for(int i=1;i<a.length;i++){
            if(temp==a[i]){
                for(int j=i;j+1<a.length;j++)
                    a[j] = a[j+1];
            }else
                temp = a[i];
        }
        return a.length;
    }

    //不用移动的方法，只是将不重复的数字依次从前面输出
    public int removeDuplicates(int A[], int n) {
        if (n == 0) return 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (A[index] != A[i])
                A[++index] = A[i];
        }
        return index + 1;
    }

    //Remove Duplicates from Sorted Array II
    //    Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice?
//    For example, Given sorted array A = [1,1,1,2,2,3],
//    Your function should return length = 5, and A is now [1,1,2,2,3]
    public int removeDuplicates2(int a[]){
        int len = a.length;
        if(len<=1)
            return len;
        int index = 0;
        //允许插入
        Boolean flag = true;
        for(int i=1;i<len;i++){
            if(a[index]!=a[i]){
                a[++index] = a[i];
                flag = true;
            }else if(a[index]==a[i]&&flag==true){
                a[++index] = a[i];
                flag = false;
            }else{
                flag = true;
            }
        }
        return index+1;
    }

    //这个方法更好，可扩展性强，把index-2改成index-3可以筛选重复超过三次的值
    //思路：index从2开始和两个之前的元素进行比较，如果不同则该位元素保持不变（i++，index++同时向下遍历），
    // 如果相同，i++但是index保持原状
    int removeDuplicates2(int A[], int n) {
        if (n <= 2) return n;
        int index = 2;
        for (int i = 2; i < n; i++){
            if (A[i] != A[index - 2])
                A[index++] = A[i];
        }
        return index;
    }

    //2.1.3在翻转数组中进行搜索
//    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//    You are given a target value to search. If found in the array return its index, otherwise return -1.
//    You may assume no duplicate exists in the array
    //思路，分情况讨论根据a[mid]和a[low]的大小，即转折点在前面还是后面两类；
    //针对每种情况，在根据a[target]和两边的大小关系进行二次分类
    //e.g. 501234 和5678901
    public int search(int a[],int target){
        int low = 0,high = a.length-1,mid;
        while(low<high){
            mid = (low + high)/2;
            if(a[mid]==target)
                return mid;
            //TODO
        }
        return -1;
    }

    //2.1.4在翻转数组中进行搜索2
//    Follow up for ”Search in Rotated Sorted Array”: What if duplicates are allowed?
//    Would this affect the run-time complexity? How and why?
//    Write a function to determine if a given target is in the array.

//    2.1.6 Longest Consecutive Sequence
//    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//    For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1,
//            2, 3, 4]. Return its length: 4.
//    Your algorithm should run in O(n) complexity
    //思路：简单的方法就是先排序，再找到连续子序列，这样最快为O(logn)，不可以
    //O(n)只能进行常数次的遍历，看见O(n)想hash表，hash表一方面用来存储所有元素用来O(1)时间查找，一方面存放元素对应的连续值
    public int longestConsecutive(int[] nums){
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(!m.containsKey(nums[i])){
                int l = m.containsKey(nums[i]-1)?m.get(nums[i]-1):0;
                int r = m.containsKey(nums[i]+1)?m.get(nums[i]+1):0;
                int sum = l+r+1;
                m.put(nums[i],sum);
                max = Math.max(max,sum);
                //更新相邻子序列的sum值
                m.put(nums[i]-l,sum);
                m.put(nums[i]+r,sum);
            }
        }
        return max;
    }

//    2.1.7 Two Sum
//    Given an array of integers, find two numbers such that they add up to a specific target number.
//    The function twoSum should return indices of the two numbers such that they add up to the target, where
//    index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not
//    zero-based.
//    You may assume that each input would have exactly one solution.
//            Input: numbers={2, 7, 11, 15}, target=9
//    Output: index1=1, index2=2
    //思路：快排后左右夹逼O(nlogn)+o(n)
    //利用hash，O(n)可以结束，直接搜索target-a[i]
    public void twoSum(int a[],int target){
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        int index1=-1,index2=-1;
        for(int i = 1;i<=a.length;i++)
            hashMap.put(a[i-1],i);
        for(int i = 1;i<=a.length;i++){
            int num = target-a[i-1];
            if(hashMap.containsKey(num)){
                index1 = i;
                index2 = hashMap.get(num);
                break;
            }
        }
        System.out.println("index1="+index1+",index2="+index2);
    }

    /*
        Given an array S of n integers, are there elements a; b; c in S such that a + b + c = 0? Find all unique
        triplets in the array which gives the sum of zero.
        Note:
        • Elements in a triplet (a; b; c) must be in non-descending order. (ie, a ≤ b ≤ c)
        • The solution set must not contain duplicate triplets.
        For example, given array S = {-1 0 1 2 -1 -4}.
        A solution set is:
        (-1, 0, 1)
        (-1, -1, 2)
     */
    public void threeSum(int a[],int target){
        Arrays.sort(a);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<a.length;i++){
            for(int j=i+1,k=a.length-1;j<k;){
                int targetSum = target-a[i];
                if(targetSum>a[j]+a[k]){
                    j++;
                }else if(targetSum<a[j]+a[k])
                    k--;
                else{
                    if(hashMap.containsKey(a[i])&&hashMap.get(a[i])==a[j]){

                    }else{
                        System.out.println("("+a[i]+","+a[j]+","+a[k]+")");
                        hashMap.put(a[i],a[j]);
                    }
                    j++;
                    k--;
                }
            }
        }
    }

    /*
    3Sum Closest
        描述
        Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
        target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
        For example, given array S = {-1 2 1 -4}, and target = 1.
        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
     */
    //思路，先排序再夹逼，缓存最小值和对应的坐标
    //开始做的时候想多了，
    public int threeSumCloset(int a[],int target){
        Arrays.sort(a);
        int min = Math.abs(target - a[0] -a[1] -a[2]);
        int result[]= {0,1,2};
        for (int i=0;i<a.length;i++){
            int targetSum = target - a[i];
            for(int low = i+1,high=a.length-1;low<high;){
                int tempMin = a[high] + a[low];
                if(Math.abs(target-a[i]-a[low]-a[high])<min){
                    min = Math.abs(target-a[i]-a[low]-a[high]);
                    result[0] = a[i];
                    result[1] = a[low];
                    result[2] = a[high];
                }
                if(a[low] + a[high] == targetSum)
                    return target*(-1);
                else if(a[low]+a[high]<targetSum){
                    low++;
                }else if(a[low]+a[high]>targetSum){
                    high--;
                }
            }
        }
        return result[0]+result[1]+result[2];
    }

    /*
    描述
        Given an array S of n integers, are there elements a; b; c, and d in S such that a + b + c + d = target?
        Find all unique quadruplets in the array which gives the sum of target.
        Note:
        • Elements in a quadruplet (a; b; c; d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
        • The solution set must not contain duplicate quadruplets.
        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
        A solution set is:
        (-1, 0, 0, 1)
        (-2, -1, 1, 2)
        (-2, 0, 0, 2)
     */
    public void fourSum(int a[],int target){
        Arrays.sort(a);
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            int targetSum = target - a[i];
            int low=i+1,mid = i+2,high = a.length-1;
            if(mid>=high)
                break;
            for(;low<high-1;low++){
                for(mid=low+1;mid<high;){
                    if(a[i]+a[low]+a[mid]+a[high]==target){
                        ArrayList<Integer> tempArr = new ArrayList<>();
                        tempArr.add(a[i]);
                        tempArr.add(a[low]);
                        tempArr.add(a[mid]);
                        tempArr.add(a[high]);
                        arrList.add(tempArr);
                        break;
                    }else if(a[i]+a[low]+a[mid]+a[high]>target)
                        high--;
                    else
                        mid++;
                }
            }
        }
        for(ArrayList arr : arrList){
            System.out.println("("+arr.get(0)+","+arr.get(1)+","+arr.get(2)+","+arr.get(3)+")");
        }
    }

/*
    2.1.11 Remove Element
    描述
    Given an array and a value, remove all instances of that value in place and return the new length.
    The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
 */
    //遍历一次，直接在原基础改，遇到重复的直接跳过
    public int removeElement(int a[],int item){
        int len = a.length,count=0,index=0;
        for(int i=0;i<len;i++){
            if(a[i]==item){
                count++;
                continue;
            }
            a[index]=a[i];
            index++;
        }
        return len-count;
    }

    /*
    2.1.12 Next Permutation
        描述
        Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
        The replacement must be in-place, do not allocate extra memory.
        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the
        right-hand column.
        1,2,3 → 1,3,2
        3,2,1 → 1,2,3
        1,1,5 → 1,5,1
     */
    //未完成，思路想对一部分，应该完全弄清楚在动手
    //3 6 8 7 4 3 2 第一步、从后往前遍历，找到第一个前面数值比后面小的，这里为6
    //3 6 8 7 4 3 2 第二步、从第一步找到数字的序号开始往后遍历，找到比他大的最小值，7
    //3 7 8 6 4 3 2 第三步，交换前两步涉及的两个数字
    //3 7 2 3 4 6 8 第四部，将第一步所得到数字的序号后面的所有数字逆序，即所得
    public void nextPermutation(int a[],int count){
        int len = a.length,temp;
        //flag为true代表逆序
        Boolean flag =true;
        if(len<2)
            return;
        for(int num=2;num<=len;len++){
            //后位大于前位
            if(a[len-num+1]>a[len-num]){
                if(num==2){
                    temp = a[len-num+1];
                    a[len-num+1] = a[len-num];
                    a[len-num] = temp;
                    break;
                }
                for(int j=len-1;j>len-num+1;j--){
                    //前面大于后面，分情况讨论
                    if(a[len-num+1]>a[j]){

                    }
                }
            }
        }

    }

    public void plusOne(int a1[],int a2[]){
        int len1 = a1.length;
        int len2 = a2.length;
        int minLen = Math.min(len1,len2);
        int carry = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<minLen;i++){
            int a = a1[len1-i-1];
            int b = a2[len2-i-1];
            int c = a+b+carry;
            if(c>9){
                carry = 1;
                arr.add(c-10);
            }else{
                arr.add(c);
                carry = 0;
            }
        }
        if(len2>minLen){
            for(int i=len2-minLen-1;i>=0;i--){
                arr.add(a2[i]+carry);
                carry = 0;
            }
        }
        if(len1>minLen){
            for(int i=len1-minLen-1;i>=0;i--){
                arr.add(a1[i]+carry);
                carry = 0;
            }
        }
        for(int i=0,j=arr.size()-1;i<j-1;i++,j--){
            Collections.swap(arr,i,j);
//            int temp = arr.get(i);
//            arr.remove(i);
//            arr.add(i,arr.get(j-1));
//            arr.remove(j);
//            arr.add(j-1,temp);
        }
        System.out.println();
    }





}
