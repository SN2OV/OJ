package NowCoder.Pass;

import java.util.ArrayList;

/**
 * Created by SN2OV on 2017/6/13.
 *
     * 题目描述
     公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
     详细描述：
     接口说明
     原型：
     int GetResult(vector &list)
     输入参数：
     无
     输出参数（指针指向的内存区域保证有效）：
     list  鸡翁、鸡母、鸡雏组合的列表
     返回值：
     -1 失败
     0 成功

     输入描述:
     输入任何一个整数，即可运行程序。
     输出描述:
     输入例子:
     1
     输出例子:
     0 25 75
     4 18 78
     8 11 81
     12 4 84
 */
public class BuyHundredChicks {

    //第一次用arraylist<arraylist<>>结果add报错，不知道怎么改
    public static ArrayList<ArrayList<Integer>> calculateSum(int n,int m){
        int x,y,z,sum=0;
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        /*
        x + y + z = 100
        5x+ 3y + z/3 = 100
         */
        for(int i = 0;i<=20;i++){
            for(int j=1;j<=(100-5*i)/3;j++){
                int k = (100 -5*i -3*j)*3;
                if(i + j + k == 100){
                    arrayList.add(new ArrayList<>());
                    arrayList.get(sum).add(i);
                    arrayList.get(sum).add(j);
                    arrayList.get(sum).add(k);
                    sum++;
                }
            }
        }
        return arrayList;
    }

    //第二次直接用StringBuilder把结果保存，结果多输出一个空格报错--
    public static StringBuilder calculateSum(int n){
        int x,y,z;
        StringBuilder str=new StringBuilder();
        for(int i = 0;i<=20;i++){
            for(int j=1;j<=(100-5*i)/3;j++){
                int k = (100 -5*i -3*j)*3;
                if(i + j + k == 100){
                    str.append( i +" " +j +" " +k);
                    str.append("\n");
                }
            }
        }
        //删除多余的空格
        return str.deleteCharAt(str.length()-1);
    }
}
