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


        //字符之间的比较不能用 "==",这个是比引用
        //带有字符的情况
        if (ss[0].equals("+") || ss[0].equals("-")) {
            System.out.print(ss[0]);

            int[] num = new int[ss.length - 1];
            int[] temp = num;
            int number = 0;

            //将String数组转换为int数组
            for (int i = 1; i <= ss.length - 1; i++) {
                num[i - 1] = Integer.parseInt(ss[i]);
            }

            ReverseInteger ri = new ReverseInteger();
            return temp = ri.normalReverse(num);


        } else {
            //不带有字符的情况
            int[] num = new int[ss.length];
            int[] temp = num;
            int number = 0;


            //将String数组转换为int数组
            for (int i = 0; i <= ss.length - 1; i++) {
                num[i] = Integer.parseInt(ss[i]);
            }
            ReverseInteger ri = new ReverseInteger();
            return temp = ri.normalReverse(num);
        }
    }



    //反转的方法,由reverse调用
    public int[] normalReverse(int[] num) {
        int number = 0;
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
        }
        return end;
    }
}





