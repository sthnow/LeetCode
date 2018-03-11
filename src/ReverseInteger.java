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


        //�ַ�֮��ıȽϲ����� "==",����Ǳ�����
        //�����ַ������
        if (ss[0].equals("+") || ss[0].equals("-")) {
            System.out.print(ss[0]);

            int[] num = new int[ss.length - 1];
            int[] temp = num;
            int number = 0;

            //��String����ת��Ϊint����
            for (int i = 1; i <= ss.length - 1; i++) {
                num[i - 1] = Integer.parseInt(ss[i]);
            }

            ReverseInteger ri = new ReverseInteger();
            return temp = ri.normalReverse(num);


        } else {
            //�������ַ������
            int[] num = new int[ss.length];
            int[] temp = num;
            int number = 0;


            //��String����ת��Ϊint����
            for (int i = 0; i <= ss.length - 1; i++) {
                num[i] = Integer.parseInt(ss[i]);
            }
            ReverseInteger ri = new ReverseInteger();
            return temp = ri.normalReverse(num);
        }
    }



    //��ת�ķ���,��reverse����
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





