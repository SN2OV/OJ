import LeetCode.Character.LeetCodeCharacterAlgo;
import LeetCode.Str.StrAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

            public class Main {

                public static void main(String[] args){
//                Scanner scanner = new Scanner(System.in);
                    int n = 0;
//                if(scanner.hasNextInt())
//                    n = scanner.nextInt();
//                for(int i=0;i<n;i++)
//                    arr[i] = scanner.nextDouble();

//                for(int i=0;i<n;i++)
//                    arrayList.add(scanner.nextDouble());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        n = Integer.parseInt(bufferedReader.readLine());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    double arr[] = new double[n];
                    for(int i=0;i<n;i++){
                        try {
                            arr[i] = Double.parseDouble(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
//                try {
//                    if(bufferedReader.readLine()!=null){
//                        n = bufferedReader.read();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                    System.out.println(getDunjiaoCount(arr));
                }

                public static int getDunjiaoCount(double arr[]){
                    int count = 0,len = arr.length;
                    Arrays.sort(arr);
                    for(int i=0;i<len;i++){
//                        二分失败了
//                        int start = i+2,end = len-1;
//                        int mid = (start+end)/2;
//                        while (start<end){
//                            if(arr[mid]-arr[i]<180&&arr[mid]-arr[i]>=180)
//                                break;
//                            else if(arr[mid]-arr[i]<180)
//                                start = mid+1;
//                            else
//                                end = mid-1;
//                        }
//                        count = count + (mid-i-1);

                        for(int j=2+i;j<len;j++){
                            if(arr[j]-arr[i]>=180)
                                break;
                            count = count + (j-i-1);
                        }
                    }
                    return count;
                }

            public static int getDunjiaoCount(ArrayList<Double> arrayList){
                int count = 0,len = arrayList.size();
                Collections.sort(arrayList);
                for(int i=0;i<arrayList.size();i++){
                    for(int j=2+i;j<arrayList.size();j++){
                        if(arrayList.get(j)-arrayList.get(i)>=180)
                            break;
                        count = count + (j-i-1);
                    }
                }
                return count;
            }


            static ArrayList<Integer> existsNum = new ArrayList<Integer>();
//
//            public static void main(String[] args) {
//                Scanner scanner = new Scanner(System.in);
//                int n = 0;
//                if(scanner.hasNextInt()){
//                    n = scanner.nextInt();
//                }
//                System.out.println(reverse(n));
//            }

            public static int getKthDoubleSuShu(int k){
                int i=10;
                while (true){
                    if(isDoubleSushu(i)){
                        k--;
                        if(k==0||i>=100000)
                            break;
                    }
                    i++;
                }
                if(i>=100000)
                    return -1;
                else
                    return i;
            }

            public static boolean isDoubleSushu(int n){
                if(existsNum.contains(n)||existsNum.contains(reverse(n)))
                    return false;
                if(reverse(n)!=n&&isSushu(n)&&isSushu(reverse(n))){
                    existsNum.add(n);
                    existsNum.add(reverse(n));
                    return true;
                }
                else
                    return false;
            }

            public static boolean isSushu(int n){
                if(n<=1)
                    return false;
                for(int i=2;i<Math.sqrt(n);i++){
                    if(n%i==0)
                        return false;
                }
                return true;
            }

            public static int reverse(int n){
                String oldNumStr = n+"";
                StringBuilder stringBuilder = new StringBuilder(oldNumStr);
                String newNumStr = stringBuilder.reverse().toString();
                int newNum = Integer.parseInt(newNumStr);
                return newNum;
            }

        //动态规划 最小张数表示amount金额的钱，用ticketArr的不同类别
        public static int coinChange(ArrayList<Integer> tickArr, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, 11111111);
            dp[0] = 0;
            for (int ticket:tickArr) {
                for (int i=ticket; i<=amount; i++) {
                    if (dp[i-ticket] != 11111111) {
                        dp[i] = Math.min(dp[i], dp[i-ticket] + 1);
                    }
                }
            }
            if(dp[amount] == 11111111)
                return -1;
            else
                return dp[amount];
        }

        public static int printMinDist(ArrayList<Integer> arrayList,int n,int s){
            Collections.sort(arrayList);
            int l=0,r=arrayList.size()-1;
            int min,max;
            if(arrayList.get(r)-arrayList.get(l)>=s){
                arrayList.set(l,arrayList.get(l) + s);
                arrayList.set(r,arrayList.get(r) - s);
                min = arrayList.get(l) + s;
                max = arrayList.get(r) - s;
            }
            else{
                return arrayList.get(r)-arrayList.get(l);
            }
            int len = arrayList.size(),i;
            for(i=1;i<len/2;i++){
                if(arrayList.get(i)-arrayList.get(len-i)>=s){
                    arrayList.set(i,arrayList.get(i) + s);
                    arrayList.set(len-i,arrayList.get(len-i) - s);
                }else{
                    if(Math.abs(arrayList.get(len-i)+s-max)<Math.abs(arrayList.get(i)-s-min)){
                        arrayList.set(i,arrayList.get(i) + s);
                        arrayList.set(len-i,arrayList.get(len-i) + s);
                    }
                }
            }
            if(len%2==1){
                arrayList.set(i,arrayList.get(i)-s);
            }
            Collections.sort(arrayList);
            int minVal = arrayList.get(len-1)-arrayList.get(0);
            arrayList.set(i,arrayList.get(i)+s);
            Collections.sort(arrayList);
            if(arrayList.get(len-1)-arrayList.get(0)<minVal)
                minVal = arrayList.get(len-1)-arrayList.get(0);
            return minVal;
        }

        public static void printAbbr(String input){
            String[] arr = input.split(" ");
            for(String str : arr)
                System.out.print(str.charAt(0));
        }


        /*
        Scanner scanner = new Scanner(System.in);
            ArrayList<Integer> heightArr = new ArrayList<>();
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
            int heightCount = 0,queryCount=0;
            if(scanner.hasNextInt()){
                heightCount = scanner.nextInt();
            }
            for(int i = 0 ;i<heightCount;i++){
                heightArr.add(scanner.nextInt());
            }
            if(scanner.hasNextInt()){
                queryCount = scanner.nextInt();
            }
            for(int i = 0 ;i<queryCount;i++){
               ArrayList<Integer> tempArr = new ArrayList<>();
               for(int j =0;j<2;j++){
                   tempArr.add(scanner.nextInt());
               }
               arrayLists.add(tempArr);
            }
            printPoint(heightArr,arrayLists);
         */

        public static void printPoint(ArrayList<Integer> heightArr,ArrayList<ArrayList<Integer>> arrayLists){
            for(ArrayList<Integer> arr : arrayLists){
                int start = arr.get(0)-1;
                int end = arr.get(1)-1;
                int count = 0;
                if(end-start<2){
                    System.out.println(count);
                    continue;
                }
                for(int i=start;i+2<=end;i++){
                    if(heightArr.get(i)<=heightArr.get(i+1)&&heightArr.get(i+1)<=heightArr.get(i+2))
                        count++;
                }
                System.out.println(count);
            }
        }

        public static BigDecimal factorial(BigDecimal n){
            BigDecimal bd1 = new BigDecimal(1);//BigDecimal类型的1
            BigDecimal bd2 = new BigDecimal(2);//BigDecimal类型的2
            BigDecimal result = bd1;//结果集，初值取1
            while(n.compareTo(bd1) > 0){//参数大于1，进入循环
                result = result.multiply(n.subtract(bd1));//实现result*（n*（n-1））
                n = n.subtract(bd1);//n-1后继续
            }
            return result;
        }

        public static void getSimplePath(String path){
//            String path = "/a/./b/../../c/";
            Stack<String> stack = new Stack<>();
            String strArr[] = path.split("/");
            for(String str : strArr){
                if(str.equals(".")||str.equals(""))
                    continue;
                else if(str.equals("..")){
                    //出栈需要校验是否为空啊
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else
                    stack.push(str);
            }
            String simplePath = "";
            if(stack.isEmpty())
                simplePath = "/";
            while (!stack.isEmpty()){
                simplePath = "/"+stack.pop() + simplePath;
            }
            System.out.print(simplePath);
        }

        /*
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = 1;
            ArrayList<Integer> arrayList = new ArrayList<>();
            if(scanner.hasNextInt())
                n = scanner.nextInt();
            for(int i=0;i<n;i++)
                arrayList.add(scanner.nextInt());
            System.out.println(findMaxK(arrayList));
        }
         */

        public static int findMaxK(ArrayList<Integer> arrayList){
            int k = 0,temp=0;
            for(int i=0;i<arrayList.size();i++){
                if(arrayList.get(i)==0){
                    k++;
                    temp = 0;
                    continue;
                }else{
                    temp = temp^arrayList.get(i);
                    if(temp==0){
                        temp = 0;
                        k++;
                        continue;
                    }
                }
            }
            return k;
        }

        /*
       public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = 1;
            ArrayList<Integer> arrayList = new ArrayList<>();
            if(scanner.hasNextInt())
                n = scanner.nextInt();
            for(int i=0;i<n;i++)
                arrayList.add(scanner.nextInt());
            System.out.println(findMaxK(arrayList));
        }

        public static int findMaxK(ArrayList<Integer> arrayList){
            int k = 0,temp=CONSTANT,temp2= 0;
            for(int i=0;i<arrayList.size();i++){
                if(arrayList.get(i)==0){
                    k++;
                    temp = CONSTANT;
                    temp2 = 0;
                    continue;
                }else{
                    temp2 = temp2^arrayList.get(i);
                    if(temp==arrayList.get(i)){
                        k++;
                        temp = CONSTANT;
                        temp2 = 0;
                        continue;
                    }else if(temp2 == 0){
                        temp2 = 0;
                        temp = CONSTANT;
                        k++;
                        continue;
                    }
                    temp = arrayList.get(i);
                }
            }
            return k;
        }
         */

        public static int getUglyNumber(int n){
            if(n == 1)
                return 1;
            int num = 2;
            for(int i=2;i<=n;i++){
                while (true){
                    if(judgeUglyNum(num))
                        break;
                    else
                        num++;
                }
                num++;
            }
            return num-1;
        }

        public static boolean judgeUglyNum(int num){
            while(num!=1){
                if(num%2==0)
                    num =num/2;
                else if(num%3 == 0)
                    num = num/3;
                else if(num%5==0)
                    num = num/5;
                else
                    return false;
            }
            return true;
        }

    public static int inversePairs(int[] data) {
        if (data == null || data.length < 1) {
            throw new IllegalArgumentException("Array arg should contain at least a value");
        }
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return inversePairsCore(data, copy, 0, data.length - 1);
    }
    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);
        // 前半段的最后一个数字的下标
        int i = start + length;
        // 后半段最后一个数字的下标
        int j = end;
        // 开始拷贝的位置
        int indexCopy = end;
        // 逆序数
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy] = data[i];
                indexCopy--;
                i--;
                count += j - (start + length); // 对应的逆序数
            } else {
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }
        for (; i >= start; i--) {
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }
        for (; j >= start + length + 1; j--) {
            copy[indexCopy] = data[j];
            indexCopy--;
            j--;
        }
        return count + left + right;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = 0;
//        if(scanner.hasNext())
//            num = scanner.nextInt();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for(int i=0;i<num;i++)
//            arrayList.add(scanner.nextInt());
//        int k = scanner.nextInt();
//        System.out.println(getMaxSubstrCount(arrayList,k));
//    }

    /*
    K 的倍数
        时间限制：C/C++语言 2000MS；其他语言 4000MS
        内存限制：C/C++语言 65536KB；其他语言 589824KB
        题目描述：
        序列中任意个连续的元素组成的子序列称为该序列的子串。
        现在给你一个序列P和一个整数K，询问元素和是K的倍数的子串的最大长度。
        比如序列【1,2,3,4,5】，给定的整数K为 5，其中满足条件的子串为{5}、{2,3}、{1,2,3,4}、{1,2,3,4,5}，
        那么答案就为 5，因为最长的子串为{1,2,3,4,5}；如果满足条件的子串不存在，就输出 0。
        输入
        第一含一个整数N, 1 ≤ 𝑁 ≤ 105 。
        第二行包含 N 个整数𝑝𝑖 ，𝑝𝑖 表示序列P第i个元素的值。0 ≤ 𝑝𝑖 ≤ 105 。
        第三行包含一个整数 K， 1 ≤ 𝐾 ≤ 105  。
        输出
        输出一个整数ANS，表示答案。

        样例输入
        Input Sample 1
        5
        1 2 3 4 5
        5
        Input Sample 2
        6
        3 1 2 7 7 7
        4
        样例输出
        Output Sample 1
        5
        Output Sample 2
        5
     */

    public static int getMaxSubstrCount(ArrayList<Integer> arrayList,int k){
        int len = arrayList.size(),sum=0;
        for(int i=len;i>0;i--){
            for(int j=0;j<=len-i;j++){
                sum = 0;
                for(int m=j;m<j+i;m++){
                    sum+=arrayList.get(m);
                }
                if(sum%k==0)
                    return i;
            }
        }
        return 0;
    }


//    List<Integer> data1 = arrayToCollection(new int[]{2,3,4,2,6,2,5,1});
//        System.out.println(data1 + "," + maxInWindows(data1, 3));
    private static List<Integer> maxInWindows(List<Integer> data, int size) {
        List<Integer> windowMax = new LinkedList<>();
        // 条件检查
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }
        Deque<Integer> idx = new LinkedList<>();
        // 窗口还没有被填满时，找最大值的索引
        for (int i = 0; i < size && i < data.size(); i++) {
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            //  添加索引
            idx.addLast(i);
        }
        // 窗口已经被填满了
        for (int i = size; i < data.size(); i++) {
            // 第一个窗口的最大值保存
            windowMax.add(data.get(idx.getFirst()));
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            // 删除已经滑出窗口的数据对应的下标
            if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
                idx.removeFirst();
            }
            // 可能的最大的下标索引入队
            idx.addLast(i);
        }
        // 最后一个窗口最大值入队
        windowMax.add(data.get(idx.getFirst()));
        return windowMax;
    }
    private static List<Integer> arrayToCollection(int[] array) {
        List<Integer> result = new LinkedList<>();
        if (array != null) {
            for (int i : array) {
                result.add(i);
            }
        }
        return result;
    }

    public static int getKstNum(int[] arr, int k) {
        if (k < 0 || k >= arr.length)
            return -1;
        int num = arr[0];
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    public void tesst() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            arrayList.add(scanner.nextInt());
        }
        int len = arrayList.size();
        int arr[] = new int[len];
        scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        System.out.println(getKstNum(arr, 2));
    }

    /*
    Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(scanner.hasNextInt()){
            arrayList.add(scanner.nextInt());
        }
        int len = arrayList.size();
        int arr[] = new int[len];
        scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        for(int i = 0 ;i<arrayList.size();i++){
            arr[i] = arrayList.get(i);
        }
        System.out.println(getKstNum(arr,2));


    public static void test(){
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        if(scanner.hasNext())
            num = scanner.nextInt();
        int arr[][] = new int[num][2];
        for(int i=0;i<num;i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        getMaxArrPrint(arr);

        scanner.close();
    }


    public static void getMaxArrPrint(int arr[][]){
        //从最后x轴最大的元素开始往回遍历，比它前一个y轴小的元素都筛掉
        int len = arr.length;
        ArrayList<Integer> maxArr = new ArrayList<>();
        maxArr.add(len-1);
        int max = arr[len-1][1];
        for(int i=len-2;i>=0;i--){
            if(arr[i][1]>max){
                maxArr.add(i);
                max = arr[i][1];
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int index : maxArr){
            stack.push(index);
        }
        for(int i=0;i<maxArr.size();i++){
            int index = stack.pop();
            //输出时控制最后一行的空格
            if(i!=maxArr.size()-1)
                System.out.println();
        }
    }
    */
}

