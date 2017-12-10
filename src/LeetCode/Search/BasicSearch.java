package LeetCode.Search;

/**
 * Created by SN2OV on 2017/7/25.
 */
public class BasicSearch {

    //排序数组折半查找
    public int binSearch(int key[],int k){
        int low=0,high = key.length-1,mid;
        while (low<=high){
            mid = (low + high)/2;
            if(key[mid] == k)
                return mid;
            if(key[mid]>k)
                high = mid -1;
            else
                low = mid + 1;
        }
        return -1;
    }


    //排序数组折半查找(递归)
    public int binSearchRecur(int key[],int low,int high,int k){
        int mid = -1;
        if (low <= high){
            mid = (low + high)/2;
            if(key[mid] == k)
                return mid;
            if(key[mid] >k)
                return binSearchRecur(key,low,mid-1,k);
            else
                return binSearchRecur(key,mid+1,high,k);
        }
        return -1;
    }
}
