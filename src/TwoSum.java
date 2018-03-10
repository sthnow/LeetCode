import org.junit.Test;

import java.util.Scanner;

public class TwoSum {


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        Integer[] num = twoSum.input1();

        int target = twoSum.input2();

        String[] strings =twoSum.add(num,target);
        System.out.print("�Ͷ�Ӧ�����Ϊ:" + strings[0] + "," + strings[1]);



    }


    public Integer[] input1() {

        Scanner sc = new Scanner(System.in);
        System.out.println("�����������ֵ:");
        String[] numS = sc.next().split(",");

        //�Ƚ��ַ�����ת�����ַ���,��ʹ��Interger��parseInt�������ַ���ת��������
        //  int num =  Integer.parseInt(String.valueOf(numS));
        //  return num;

        //���ַ�����ת����int����
        Integer[] num = new Integer[numS.length];
        for (int i = 0; i < numS.length; i++) {
            num[i] = Integer.valueOf(numS[i]);
        }
        return num;
    }


    public int input2() {
        System.out.println("���������֮�͵�ֵ:");
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
                    //һ��break���ֻ�ܽ���һ��ѭ��
                    //�����Ҫ�������ѭ����Ҫ��outer��ǩ
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

