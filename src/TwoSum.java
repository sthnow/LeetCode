import org.junit.Test;

import java.util.Scanner;

public class TwoSum {


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        Integer[] num = twoSum.input1();

        int target = twoSum.input2();

        String[] strings =twoSum.add(num,target);
        System.out.print("和对应的序号为:" + strings[0] + "," + strings[1]);



    }


    public Integer[] input1() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的值:");
        String[] numS = sc.next().split(",");

        //先将字符数组转换成字符串,在使用Interger的parseInt方法将字符串转换成数字
        //  int num =  Integer.parseInt(String.valueOf(numS));
        //  return num;

        //将字符数组转换成int数组
        Integer[] num = new Integer[numS.length];
        for (int i = 0; i < numS.length; i++) {
            num[i] = Integer.valueOf(numS[i]);
        }
        return num;
    }


    public int input2() {
        System.out.println("请输入二者之和的值:");
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        sc.close();
        return Integer.valueOf(target);
    }

    public String[] add(Integer[] num, int target) {

        int i, j = 0;
        String[] strings = new String[2];
        outer:
        for (i = 0; i <= num.length - 1; i++) {
            for (j = i + 1; j <= num.length - 1; j++) {
                if (num[i] + num[j] == target) {
                    //一个break语句只能结束一个循环
                    //如果想要结束外层循环需要加outer标签
                    break outer;
                }
            }
        }
        // System.out.println(i + "," + j);
        strings[0] = String.valueOf(i);
        strings[1] = String.valueOf(j);
        return strings;
    }
}

