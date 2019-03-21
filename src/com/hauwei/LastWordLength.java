package com.hauwei;


import java.util.Scanner;

/**
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 * 示例1
 * 输入
 * 复制
 * hello world
 * 输出
 * 复制
 * 5
 */
public class LastWordLength {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] s = string.split(" ");
        String finalString = s[s.length-1];
        int finalStringLength = finalString.split("").length;
        System.out.println(finalStringLength);
    }

}
