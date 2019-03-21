package com.hauwei;
import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * 输入描述:
 * 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * ABCDEF A
 * 输出
 * 复制
 * 1
 */
public class CotainStringNum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //读取第一个字符串
        String first = sc.next();
        //转换成小写
        String firstString = first.toLowerCase();
        //读取第二个字符串
        String second = sc.next();
        //转换成小写
        String secondString = second.toLowerCase();

        if(firstString.length() <= 1 || firstString == null) {
            System.out.println("0");
            return;
        }

        int count = 0;

        for(int i = 0; i < firstString.length(); i++){
            if(firstString.charAt(i) == secondString.charAt(0))
                count++;
        }
        System.out.println(count);
        }


    }

