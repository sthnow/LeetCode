import java.util.Scanner;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int[] num = ri.reverse(ri.input());
        for (int i : num) {
            System.out.print(i + ",");
        }
    }

    //���뷽��������һ���ַ���
    public String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("����������");
        String s = sc.next();
        System.out.println("�����������Ϊ" + s);
        sc.close();
        return s;
    }

    public int[] reverse(String s) {
        //�Ƚ��ַ���ת��ΪString����
        String[] ss = s.split("");
        //����һ��int����
        int[] num = new int[ss.length];
        int[] temp = num;
        int number = 0;


        //  if(ss[0] == "+" || ss[0] == "-"){
        //
        //  }
        //��String����ת��Ϊint����
        for (int i = 0; i <= ss.length - 1; i++) {
            num[i] = Integer.parseInt(ss[i]);
        }

        /**
         * reverse����������
         *      1.123����
         *      2.+/-123����
         *      3.120����
         *
         *      ���ڵ�һ�֣�ֱ��reverse����
         *      �ڶ��֣��ж�ĩβ��û��0
         *      �����֣��ж���λ��û��������
         *
         */

        //���ڵ�һ�ֺ͵ڶ������
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

