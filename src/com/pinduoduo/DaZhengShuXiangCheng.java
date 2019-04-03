package com.pinduoduo;

import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/0f0badf5f2204a6bb968b0955a82779e
 * 来源：牛客网
 *
 * 大整数相乘
 * 热度指数：17181时间限制：1秒空间限制：32768K
 *  算法知识视频讲解
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 * 输入描述:
 * 空格分隔的两个字符串，代表输入的两个大整数
 *
 *
 * 输出描述:
 * 输入的乘积，用字符串表示
 * 示例1
 * 输入
 * 72106547548473106236 982161082972751393
 * 输出
 * 70820244829634538040848656466105986748
 */
public class DaZhengShuXiangCheng {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.nextBigDecimal().toString();
        String num2 = in.nextBigDecimal().toString();

        int[] ret = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';

                ret[i + j] += (ret[i + j + 1] + x * y) / 10;
                ret[i + j + 1] = (ret[i + j + 1] + x * y) % 10;

            }
        }

        String s = "";
        for (int i = 0; i < ret.length; i++) {
            if (i == 0 && ret[i] == 0) continue;
            s += ret[i];
        }
        System.out.println(s);
    }
}
