package com.hauwei;


import java.util.Scanner;

/**
 * 字符串反转
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
 * 输入描述:
 * 输入N个字符
 *
 * 输出描述:
 * 输出该字符串反转后的字符串
 *
 * 示例1
 * 输入
 * 复制
 * abcd
 * 输出
 * 复制
 * dcba
 */
public class ZiFuChuanFanZhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            String[] strings = s.split("");
            for (int i = strings.length-1; i >= 0 ; i--) {
                System.out.print(strings[i]);

            }

        }
    }
}
