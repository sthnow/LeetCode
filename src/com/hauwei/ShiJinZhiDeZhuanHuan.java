package com.hauwei;

import java.util.Scanner;

/**
 * 进制转换
 * 题目描述
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 * 示例1
 * 输入
 * 复制
 * 0xA
 * 输出
 * 复制
 * 10
 */
public class ShiJinZhiDeZhuanHuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String next = sc.next();
            String num = next.substring(2);
            int ans = Integer.parseInt(num, 16);
            System.out.println(ans);
        }
    }
}
