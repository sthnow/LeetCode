package com.hauwei;

import java.util.Scanner;

/**
 * 提取不重复的数
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * <p>
 * 输入描述:
 * 输入一个int型整数
 * <p>
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * <p>
 * 示例1
 * 输入
 * 复制
 * 9876673
 * 输出
 * 复制
 * 37689
 */
public class TiQuBuChongFuDeShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] state = new int[10];
            while (num != 0) {
                int temp_num = num % 10;

                if (state[temp_num - 1] == 0) {
                    System.out.print(temp_num);
                    state[temp_num - 1] = 1;
                }
                num = num / 10;
            }
            System.out.println();
        }
    }
}
