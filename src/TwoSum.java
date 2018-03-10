import java.util.Scanner;

public class TwoSum {


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        Integer[] num = twoSum.input1();
        int target = twoSum.input2();
        String[] strings = twoSum.add(num, target);

        System.out.print("�Ͷ�Ӧ�����Ϊ:" + strings[0] + "," + strings[1]);
    }

    //��������Ĵ���
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

    //����targetֵ�Ĵ���
    public int input2() {
        System.out.println("���������֮�͵�ֵ:");
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        sc.close();
        return Integer.valueOf(target);
    }

    //�����߼��Ĵ���
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
        /**
         * �쳣���������:
         *      1.Ŀ��ֵ̫��
         *      2.Ŀ��ֵ̫С
         * �����������쳣�����з���
         *      1.Ҫô��forѭ���������,�ȱ���һ��ÿ��ֵ�ĺ��Ƿ�������target,�ڱ���һ��Ѱ��target��ֵ
         *      2.Ҫô��ԭ���Ĵ���ĩβ����if���,��Ϊ����Ѱ����ɺ�,���û���ҵ�target��ֵ,i��j��ֵ����5,��������ص���Լ���
         *      ���ĵ�if���,����target̫С�����,��num[0]��ʼ���𼴿�
         */
        if (num[i - 1] + num[j - 2] < target || num[0] + num[1] > target)
            throw new RuntimeException("����������ֵ֮�Ͳ��ܵ��ڶ�Ӧ��Ŀ��ֵ");
        // System.out.println(i + "," + j);
        strings[0] = String.valueOf(i);
        strings[1] = String.valueOf(j);
        return strings;
    }
}

