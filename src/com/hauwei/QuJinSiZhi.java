package com.hauwei;

import java.util.Scanner;

/**
 * 取近似值
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入
 * 复制
 * 5.5
 * 输出
 * 复制
 * 6
 */
public class QuJinSiZhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            float num = sc.nextFloat();

            int decimal = (int) (num * 10 % 10);

            int integer = (int) (num * 10 / 10);

            if(decimal >= 5){
                System.out.println(integer+1);
            }else{
                System.out.println(integer);
            }
        }
    }
}
