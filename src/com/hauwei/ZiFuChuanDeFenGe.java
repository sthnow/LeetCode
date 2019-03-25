package com.hauwei;

import java.util.Scanner;

/**
 * 字符串的分割
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 123456789
 * 输出
 * 复制
 * abc00000
 * 12345678
 * 90000000
 */
public class ZiFuChuanDeFenGe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

            String first = sc.nextLine();
            String second = sc.nextLine();

            if(first.equals("") || first.equals(" ")) {
                System.out.println(first);
            }
            if(second.equals("") || second.equals(" ")) {
                System.out.println(second);
            }

            int flag1 = 0;
            for(int i=0 ;i<first.length() ;i++){
                if(flag1!=7){
                    System.out.print(first.charAt(i));
                    flag1++;
                }else{
                    System.out.println(first.charAt(i));
                    flag1 = 0;//更新flag1
                }
            }


            if(flag1!=0){
                for(int i=0 ;i<8-flag1 ;i++){
                    System.out.print("0");
                }
                System.out.println();
            }


            //第二行
            int flag2 = 0;
            for(int i=0 ;i<second.length() ;i++){
                if(flag2!=7){
                    System.out.print(second.charAt(i));
                    flag2++;
                }else{
                    System.out.println(second.charAt(i));
                    flag2 = 0;
                }
            }

            if(flag2!=0){
                for(int i=0 ;i<8-flag2 ;i++){
                    System.out.print("0");
                }
                System.out.println();
            }


        }
    }
}
