package com.pinduoduo;

import com.secondleetcod.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 大整数相加
 */
public class DaZhengShuXiangJia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextBigDecimal().toString();
        String num2 = sc.nextBigDecimal().toString();

        StringBuffer n1 = new StringBuffer(num1).reverse();
        StringBuffer n2 = new StringBuffer(num2).reverse();

        int len1 = n1.length();
        int len2 = n2.length();
        int[] sum;
        int maxLen;
        int carry = 0;
        //将两个字符串变为相同长度
        if (len1 < len2) {
            //考虑到进位
            sum = new int[len2 + 1];
            maxLen = len2;

            for (int i = len1; i < len2; i++) {
                n1.append("0");
            }
        } else {
            maxLen = len1;
            sum = new int[len1 + 1];
            for (int i = len2; i < len1; i++) {
                n2.append("0");
            }
        }
        for (int i = 0; i < maxLen; i++) {
            int add1 = n1.charAt(i) - '0';
            int add2 = n2.charAt(i) - '0';

            sum[i] = (add1 + add2 + carry) % 10;
            carry = (add1 + add2 + carry) / 10;

//            if (sum[i] + (add1 + add2) / 10 > 1) {
//                flag = 1;
//                sum[i] = sum[i] + (add1 + add2) % 10;
//                sum[i + 1] = flag + (add1 + add2) / 10;
//                flag = 0;
//            }else{
//                sum[i] = sum[i] + (add1 + add2) % 10;
//                sum[i + 1] =(add1 + add2) / 10;
//            }
//
//        }
        }
        if(carry == 1){
            sum[sum.length-1] = 1;
        }

        for (int i = sum.length-1; i >=0; i--) {
            if(i==sum.length-1 && sum[sum.length-1] == 0) continue;
            System.out.print(sum[i]);
        }
    }
}
