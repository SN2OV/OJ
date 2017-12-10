package LeetCode.Character;

/**
 * Created by SN2OV on 2017/7/31.
 */
public class LeetCodeCharacterAlgo {

    /*
    3.1 Valid Palindrome
        描述
        Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring
        cases.
        For example,
        ”A man, a plan, a canal: Panama” is a palindrome.
        ”race a car” is not a palindrome
     */
    //回文，忘记判断传入的字符为空的情况了。。。
    public Boolean isPalindrome(String str){
        if(str == null)
            return true;
        int low = 0,high = str.length()-1;
        while(low<high){
            char l = str.charAt(low);
            char h = str.charAt(high);
            if(!isAlphabet(l)){
                low++;
                continue;
            }
            if(!isAlphabet(h)){
                high--;
                continue;
            }
            if(l!=h&&Math.abs(l-h)!=32)
                return false;
            low++;
            high--;
        }
        return true;
    }

    public Boolean isAlphabet(char ch){
        if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
            return true;
        else
            return false;
    }

    /*
        3.2实现strstr()
        strstr(str1,str2) 函数用于判断字符串str2是否是str1的子串
     */
    public Boolean strStr(String str1,String str2){
        //要先判空，不然到后面又忘记了。。
        int i = 0,j=0,count=0;
        int len1 = str1.length(),len2 = str2.length();
        while(i<=len1-len2){
            int temp = i;
            //注意这里要把j<len2放在前面，否在会出现越界的情况
            while(j<len2&&str1.charAt(temp) ==str2.charAt(j)){
                temp++;
                j++;
                count++;
            }
            if(j==len2)
                return true;
            else
                i = i+count;
            j = 0;
            count = 0;
            i++;
        }
        return false;
    }


    /*
    字符串的全排列
     */
    public void PrintPermutation(char[] array,int index){
        if(index == array.length-1){
            System.out.println(array);
            //递归注意结束标识，开始忘记return
            return ;
        }
        for(int i=index;i<array.length;i++){
            char temp = array[index];
            array[index] = array[i];
            array[i]=temp;
            PrintPermutation(array,++index);
            //注意这里递归操作完需要减回来
            index--;
            temp = array[index];
            array[index] = array[i];
            array[i]=temp;
        }
    }

//    public double findMid(double[] arr1,int start1,int end1,double[] arr2,int start2,int end2){
//        //确保arr1为长度较短的那个数组
//        if(arr1.length>arr2.length)
//            return findMid(arr2,start2,end2,arr1,start1,end1);
//        if
//        int mid1 = (start1+end1)/2;
//        int mid2 = (start2+end2)/2;
//        if(arr1[mid1]==arr2[mid2])
//            return arr1[mid1];
//        else if(arr1[mid1]<arr2[mid2])
//            return findMid(arr1,mid1,end1,arr2,start2,mid2);
//        else
//            return findMid(arr1,start1,mid1,arr2,mid2,end2);
//    }

    //求两个有序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        if(total%2==0){
            return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
        }else{
            return findKth(total/2+1, nums1, nums2, 0, 0);
        }
    }

    public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
        if(s1>=nums1.length)
            return nums2[s2+k-1];

        if(s2>=nums2.length)
            return nums1[s1+k-1];

        if(k==1)
            return Math.min(nums1[s1], nums2[s2]);

        int m1 = s1+k/2-1;
        int m2 = s2+k/2-1;

        int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;
        int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;

        if(mid1<mid2){
            return findKth(k-k/2, nums1, nums2, m1+1, s2);
        }else{
            return findKth(k-k/2, nums1, nums2, s1, m2+1);
        }
    }



    /**
      * 合并两个已排好序的数组s[left...mid]和s[mid+1...right]
      *
      * @param arr
      * @param left
      * @param mid
      * @param right
      * @return 返回合并过程中累加逆序对
      */
   public int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];    // 辅助存储空间 O(n)
        int index = 0;
        int i = left;
        int j = mid + 1;
        int inverseNum = 0;       // 新增，用来累加数组逆序对
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                // 当前一个数组元素大于后一个数组元素时，累加逆序对
                // s[i] > s[j] -> s[i]...s[mid] > s[j]
                inverseNum += (mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left++] = temp[k];
        }
        return inverseNum;
    }

    public  int mergeSortRecursion(int[] arr, int l, int r) {
        if (l == r) // 当待排序数组长度为1时，递归开始回溯，进行merge操作
            return 0;
        int mid = (l + r) / 2;
        return mergeSortRecursion(arr, l, mid) + mergeSortRecursion(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

}
