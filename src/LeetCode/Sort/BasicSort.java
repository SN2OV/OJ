package LeetCode.Sort;

/**
 * Created by SN2OV on 2017/7/25.
 */
public class BasicSort {

    public void printArr(int a[]) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    //本次全部讨论升序
    //插入排序
    //插排的关键是每n轮排序过后，前面的n个数字相对顺序
//    public void insertSort(int k[]){
//        for(int i=1;i<=k.length-1;i++){
//            int j = i-1,temp;
//            while (j>=0 && k[i]<k[j]){
//                temp = k[i];
//                k[i] = k[j];
//                k[j] = temp;
//                j--;
//                //不应该变动i啊
//                i--;
//            }
//        }
//    }

    public void insertSort(int k[]) {
        for (int i = 1; i <= k.length - 1; i++) {
            int j = i - 1, temp = k[i];
            while (j >= 0 && temp < k[j]) {
                k[j + 1] = k[j];
                j--;
            }
            k[j + 1] = temp;
        }
    }

    public void insertSort2(int k[]) {
        for (int i = 1; i < k.length; i++) {
            int temp = k[i], j = i;
            for (j = i; j > 0 && k[j] < k[j - 1]; j--)
                k[j] = k[j - 1];
            k[j] = temp;
        }
    }

    //折半插入排序
    //二分查找最后把low和它后面的元素后移即可，不是mid!
    public void binInsertSort(int k[]) {
        for (int i = 1; i <= k.length - 1; i++) {
            int j, temp = k[i];
            int low = 0, high = i;
            while (low < high) {
                int mid = (low + high) / 2;
                if (k[mid] > temp) {
                    high = mid - 1;
                }
                //注意这里不用单独考虑等号的情况，但是
                else {
                    low = mid + 1;
                }
            }
            for (j = i - 1; j >= low; j--)
                k[j + 1] = k[j];
            k[low] = temp;
        }

    }

    //选择排序
    public void selectSort(int k[]) {
        for (int i = 0; i < k.length; i++) {
            //這句話第一次写的时候弄错了
            int min = i;
            for (int j = i + 1; j < k.length; j++) {
                if (k[j] < k[min])
                    min = j;
            }
            if (min != i) {
                int temp = k[min];
                k[min] = k[i];
                k[i] = temp;
            }
        }
    }

    //冒泡排序
    public void bubbleSort(int k[]) {
        for (int i = 0; i < k.length - 1; i++) {
            for (int j = 0; j < k.length - 1 - i; j++) {
                if (k[j + 1] < k[j]) {
                    int temp = k[j];
                    k[j] = k[j + 1];
                    k[j + 1] = temp;
                }
            }
        }
    }

    //冒泡排序？？
    public void bubbleSort2(int k[]) {
        for (int i = 0; i < k.length - 1; i++) {
            for (int j = i + 1; j < k.length; j++) {
                if (k[j] < k[j - 1]) {
                    int temp = k[j];
                    k[j] = k[j - 1];
                    k[j - 1] = temp;
                }
            }
        }
    }


    //快速排序
//    public void quickSort(int k[],int s,int begin,int end){
//        if(end<0||s<=0)
//            return;
//        int i = begin,j = end-1;
//        while (i<j){
//            while (k[i]<k[s]&&i<j)
//                i++;
//            while (k[j]>k[s]&&i<j)
//                j--;
//            int temp = k[i];
//            k[i] = k[j];
//            k[j] = temp;
//        }
//        int temp = k[s];
//        k[s] = k[j];
//        k[j] = temp;
//        quickSort(k,j-1,0,j-1);
//        quickSort(k,s,j+1,s);
//    }

//    public void quickSortA(int k[],int s){
//        quickSort(k,k[k.length-1],0,k.length-1);
//    }

    //将第一个设置为参照元素
    //快速排序
    //优化1、当待排序序列的长度分割到一定大小后，使用插入排序。
    //优化2、在一次分割结束后，可以把与Key相等的元素聚在一起，继续下次分割时，不用再对与key相等元素分割
    public void quickSort(int k[], int begin, int end) {
        int i = begin + 1, j = end, s = begin;
        //这句很关键！！循环结束标识
        if (i > j)
            return;
        while (i < j) {
            //二刷的时候，循环条件写错了，写成&&i<j了，导致思路错误
            //不加等号死循环了 3,1,2,3,3,5
            while (k[i] < k[s] && i != end)
                i++;
            while (k[j] > k[s] && j != begin)
                j--;
            if (i < j) {
                int temp = k[i];
                k[i] = k[j];
                k[j] = temp;
            }
        }
        int temp = k[j];
        k[j] = k[s];
        k[s] = temp;
        quickSort(k, begin, j - 1);
        quickSort(k, j + 1, end);
    }

    //将第一个设置为参照元素
    //快速排序
    public void quickSort2(int k[], int begin, int end) {
        int i = begin + 1, j = end, s = begin;
        //这句很关键！！循环结束标识
        if (i > j)
            return;
        while (i < j) {
            //二刷的时候，循环条件写错了，写成&&i<j了，导致思路错误
            //三刷的时候发现没加等号，结果死循环
            while (k[i] <= k[s] && i != end)
                i++;
            while (k[j] >= k[s] && j != begin)
                j--;
            if (i < j) {
                int temp = k[i];
                k[i] = k[j];
                k[j] = temp;
            }
        }
        int temp = k[j];
        k[j] = k[s];
        k[s] = temp;
        quickSort(k, begin, j - 1);
        quickSort(k, j + 1, end);
    }

    //希尔排序（自己实现）
    public void shellSort(int[] a) {
        int gap = a.length / 2;
        while (gap != 0) {
            for (int i = gap; i < a.length; i++) {
                int j = i - gap;
                //注意内层循环中，除了初始化不要用到上层的变量，因为上层的变量在这里是常数
                //写希尔排序时，可以先把插入排序思路想好，在上面再改造
                while (j >= 0 && a[j + gap] < a[j]) {
                    //二刷时没有使用交换，使用的是插入排序的那种，替换的方法
                    int temp = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = temp;
                    j = j - gap;
                }
            }
            gap = gap / 2;
        }

    }

    //书上的方法是错的！！！！！！！
    public void shellSort2(int k[], int n) {
        int i, j, flag, gap = n;
        int temp;
        while (gap > 1) {
            gap = gap / 2;
            do {
                flag = 0;
                for (i = 1; i <= n - gap; i++) {
                    j = i + gap;
                    if (k[i] > k[j]) {
                        temp = k[i];
                        k[i] = k[j];
                        k[j] = temp;
                        flag = 1;
                    }
                }
            } while (flag != 0);
        }
    }

    //相比之前的插排比较的次数变多了，移动的次数没变
    public int[] shellSort3(int[] A, int n) {
        int gap = n / 2;// 初始步长
        while (gap > 0) {
            // 从数组下标为 gap的元素开始排序
            for (int i = gap; i < n; i++) {
                // 每个元素只与自己组内的元素进行直接排序，组内相邻元素比较
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (A[j] > A[j + gap]) {
                        int temp = A[j + gap];
                        A[j + gap] = A[j];
                        A[j] = temp;
                    }
                }
            }
            gap /= 2;
        }
        return A;
    }

    //堆排序
    //堆调整,注意序号从0还是1开会时
    //关键点：在获取左右孩子的值之前进行判断是否存在
    //之前未使用参数n，直接用a.length代替，是不行的，后面堆排序需要本参数
    //本方法表示对长度为n的堆，以i为根节点去调整
    public void adjust(int a[], int i, int n) {
        int index = i;
        int temp = a[i];
        while (index < n) {
            //左孩子右孩子都不存在时
            //这个算法写错了，因为没有考虑左孩子存在右孩子不存在的情形
            if (n - 1 <= index * 2 + 1)
                break;
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (a[left] > a[right]) {
                if (temp > a[left])
                    break;
                a[index] = a[left];
                index = left;
            } else {
                if (temp > a[right])
                    break;
                a[index] = a[right];
                index = right;
            }
        }
        a[index] = temp;
    }

    //书中的做法(这个是对的)
    //n为数组的长度,二刷忘记参数n了
    public void adjust2(int a[], int i, int n) {
        int len = n;
        int left, bigger = i, temp = a[i];
        //左孩子存在
        left = 2 * i + 1;
        while (left < len) {
            //右孩子存在，这个left+1在&&左边很精髓
            if (left + 1 < len && a[left] < a[left + 1])
                left++;
            if (temp >= a[left])
                break;
            //二刷时把这步写成交换了，其实不用
            a[(left - 1) / 2] = a[left];
            left = left * 2 + 1;
        }
        a[(left - 1) / 2] = temp;
    }

    //堆排序
    //思路：先通过n/2此adjust调整好初始堆，将堆顶取出因为
    public void heapSort(int a[]) {
        int len = a.length;
        //初始堆，二刷忘记了这步
        for (int i = len / 2; i >= 0; i--)
            adjust(a, i, len);
        for (int i = len - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjust(a, 0, i);
        }

//        //正确的
//        int len = a.length;
//        //初始堆
//        for(int i=len/2;i>=0;i--)
//            adjust2(a,i,len);
//        for(int i=len-1;i>=0;i--){
//            int temp = a[0];
//            a[0] = a[i];
//            a[i] = temp;
//            adjust2(a,0,i);
//        }
    }

    //二路归并排序
    //将low~mid和mid+1~high两段合并成一个有序数组
    public void merge(int s[], int low, int mid, int high) {
        int i = low, j = mid + 1, index = 0;
        //先申请数组存放
        int temp[] = new int[high - low + 1];
        while (i <= mid && low <= high) {
            if (s[i] < s[j])
                temp[index++] = s[i++];
            else
                temp[index++] = s[j++];
        }

        //注意这里i<=mid
        while (i <= mid) {
            temp[index++] = s[i++];
        }
        while (j <= high) {
            temp[index++] = s[j++];
        }
        for (int k = 0; k < temp.length; k++)
            s[k] = temp[k];
    }

    //思路是这个，但是哪里错了不晓得
    public void mergeSortRecursion(int s[], int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSortRecursion(s, start, mid);
            mergeSortRecursion(s, mid + 1, end);
            merge(s, start, mid, end);
        }
    }

    //k个元素为步长归并
    //负责将数组中的相邻的有k个元素的字序列进行归并
    public void mPass(int s[], int step) {
        int i = 0, j, len = s.length;
        while (len - i + 1 > 2 * step) {
            merge(s, i, i + step - 1, i + step * 2 - 1);
            i = i + 2 * step;
        }
        //走到这里已经保证不足两个step了
        if (i + step < len)
            merge(s, i, i + step - 1, len - 1);
    }

    public void mergeSortWithoutRecursion(int s[]) {
        int len = s.length;
        int step = 1;
        while (step < len) {
            mPass(s, step);
            step = step * 2;
        }
    }

}
