import org.junit.Test;

import java.util.Scanner;

public class num2eng {
    //定义了若干个成员变量
    //该成员变量为类变量
    private String[] eng = {"", "one", "two", "three", "four", "five", "six","seven", "eight", "nine"};
    private String[] Number = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy","eighty", "ninety"};
    private String[] ShiWei = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private String[] Qian   = {"", "thousand","thousand","thousand","thousand","thousand","thousand","thousand","thousand","thousand" };
    private String[] Bai    = {"", "hundred", "hundred","hundred","hundred","hundred","hundred","hundred","hundred","hundred"};

    //定义了名为divide的方法
    //分割数字的位数
    public static int[] divide(int num) {
        int num30 = num / 1000;
        int num20 = (num-num30*1000) / 100;
        int num10 = (num-num30*1000-num20*100) / 10;
        int num0 = num - num30 * 1000 - num20 * 100 - num10 * 10;
        //定义一个包含了num30，num20，num10，num0的数组
        int[] numSum = new int[]{num30, num20, num10, num0};
        return  numSum;
    }

    //定义了名为toEngStr的方法
    //将分割后的数字转换成英文
   public  String toEngStr(){
       String result = "";
       int[] numSum ;
       Scanner sc = new Scanner(System.in);
       System.out.println("请输入数字：");
       int n = sc.nextInt();
       sc.close();
       numSum = divide(n);

       //根据位数判断该输出什么
       if ((numSum[2] == 1) && numSum[1] != 1) {
           result += ShiWei[numSum[3]];
       }else if((numSum[2] == 1) && numSum [1] == 1){
           result += eng[numSum[1]] + " " + Bai[numSum[1]] + " " + ShiWei[numSum[3]];
       }else if(numSum[3] == 0) {
           result += "zero";
       }else {
           result += eng[numSum[0]] + " " + Qian[numSum[0]] + " " + eng[numSum[1]] + " " + Bai[numSum[1]] + " " + Number[numSum[2]] + " " + eng[numSum[3]];
       }return  result;
    }

    public static void main(String[] args) {
       //使用构造器构造了一个名为ne的num2eng的类
        num2eng ne = new num2eng();
        System.out.print(ne.toEngStr());

    }

}
