import java.util.Scanner;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int[] num = ri.reverse(ri.input());
        for (int i : num) {
            System.out.print(i + ",");
        }
    }

    //输入方法，返回一个字符串
    public String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        String s = sc.next();
        System.out.println("你输入的数字为" + s);
        sc.close();
        return s;
    }

    public int[] reverse(String s) {
        //先将字符串转换为String数组
        String[] ss = s.split("");
        //定义一个int数组
        int[] num = new int[ss.length];
        int[] temp = num;
        int number = 0;


        //  if(ss[0] == "+" || ss[0] == "-"){
        //
        //  }
        //将String数组转换为int数组
        for (int i = 0; i <= ss.length - 1; i++) {
            num[i] = Integer.parseInt(ss[i]);
        }

        /**
         * reverse分三种类型
         *      1.123这种
         *      2.+/-123这种
         *      3.120这种
         *
         *      对于第一种，直接reverse即可
         *      第二种，判断末尾有没有0
         *      第三种，判断首位有没有正负号
         *
         */

        //对于第一种和第二种情况
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] == 0) {
                number = number + 1;
            } else {
                break;
            }
        }

        int[] end = new int[num.length - number];
        for (int j = num.length - 1 - number; j >= 0; j--) {
            end[num.length - 1 - number - j] = num[j];
            //        System.out.print(end[num.length - 1 - number - j]);
        }

        return end;

    }
}

