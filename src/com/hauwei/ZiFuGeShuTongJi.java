package com.hauwei;


import java.util.Scanner;

/**
 *
 * 字符个数统计
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 输出
 * 复制
 * 3
 */
public class ZiFuGeShuTongJi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            int length = s.length();

            int[] count = new int[128];

            int number = 0;

            for (int i = 0; i < length; i++) {
                int ascii = s.charAt(i);

                if(count[ascii] != 1){
                   count[ascii] = 1;
                   number++;
                }
            }
            System.out.println(number);
        }
    }
}
