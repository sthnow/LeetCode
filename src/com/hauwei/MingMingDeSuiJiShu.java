package com.hauwei;

import java.util.Arrays;
import java.util.Scanner;

public class MingMingDeSuiJiShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            int[] num = new int[number];

            for (int i = 0; i < number; i++) {
                num[i] = sc.nextInt();
            }

            Arrays.sort(num);

            System.out.println(num[0]);

            for (int i = 1; i < number; i++) {
                if (num[i] == num[i - 1]) {
                    continue;
                }
                System.out.println(num[i]);
            }
        }
    }
}


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int n = in.nextInt();
//            TreeSet<Integer> ts = new TreeSet<Integer>();
//            for (int i = 0; i < n; i++) {
//                ts.add(in.nextInt());	//树在插入时进行排序.
//            }
//            // 输出所有值
//            Iterator it = ts.iterator();
//            while (it.hasNext()) {
//                System.out.println(it.next());
//            }
//        }
//    }
//}
