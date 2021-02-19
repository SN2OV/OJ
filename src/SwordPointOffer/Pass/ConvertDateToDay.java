package SwordPointOffer.Pass;

/**
 * Created by SN2OV on 2017/6/11.
 *
     * 题目描述
     根据输入的日期，计算是这一年的第几天。。
     详细描述：
     输入某年某月某日，判断这一天是这一年的第几天？。


     接口设计及说明：
     *****************************************************************************
     Description   : 数据转换
     Input Param   : year 输入年份
     Month 输入月份
     Day 输入天

     Output Param  :
     Return Value  : 成功返回0，失败返回-1（如：数据错误）
     *****************************************************************************
     public static int iConverDateToDay(int year, int month, int day)
        {
      在这里实现功能，将结果填入输入数组中
        return 0;
        }

     输入描述:
     输入三行，分别是年，月，日

     输出描述:
     成功:返回outDay输出计算后的第几天;
     失败:返回-1

     输入例子:
     2012
     12
     31

     输出例子:
     366
 */
public class ConvertDateToDay {
    public static int iConverDateToDay(int year,int month,int day){
        int days = 0;
        if(month<1||month>12)
            return -1;
        int daysAmountArr[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        if((year %4 ==0&&year%100!=0)||year%400==0)
            daysAmountArr[1] = 29;
        if(day<1||day>daysAmountArr[month-1])
            return -1;
        for(int i=0;i<month-1;i++)
            days += daysAmountArr[i];
        days += day;
        return days;
    }
}
