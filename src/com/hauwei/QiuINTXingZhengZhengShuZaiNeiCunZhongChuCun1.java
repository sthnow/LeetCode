package com.hauwei;

import java.util.Scanner;

/**
 * 求int型正整数在内存中存储时1的个数
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入
 * 复制
 * 5
 * 输出
 * 复制
 * 2
 */
public class QiuINTXingZhengZhengShuZaiNeiCunZhongChuCun1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            String s = Integer.toBinaryString(num);
            int count = 0;
            for(int i = 0; i < s.length(); i++){

                if(Integer.parseInt(String.valueOf(s.charAt(i))) == 1){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
