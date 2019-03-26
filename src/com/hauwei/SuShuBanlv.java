package com.hauwei;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 素数伴侣
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 *
 * 输入:
 *
 * 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
 *
 * 输出:
 *
 * 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 *
 *
 * 输入描述:
 * 输入说明
 * 1 输入一个正偶数n
 * 2 输入n个整数
 *
 * 输出描述:
 * 求得的“最佳方案”组成“素数伴侣”的对数。
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * 2 5 6 13
 * 输出
 * 复制
 * 2
 */
public class SuShuBanlv {


    /**
     * Author: 王俊超
     * Date: 2016-01-06 10:43
     * Declaration: All Rights Reserved !!!
     */

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                System.out.println(countPrimePairs(arr));
            }

            scanner.close();
        }


        private static boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }

            int sqrt = (int) Math.sqrt(n);
            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }

        /**
         * 从后向前看
         * 利用动态规划解题，dp[i]表示(n-1)~i最多有的伴侣数；
         * 当v[i]+v[j]为素数。dp[i]+dp[j+1] = dp[i+1]+dp[j+1]+1;
         * 由于伴侣数成对出现，必然只能在i-1和j-1的基础上出现一对。
         * 当v[i]+v[j]不为素数。dp[i]=dp[i+1]
         *
         * @param v
         * @return
         */
        private static int countPrimePairs(int[] v) {

            int[] dp = new int[v.length + 1];

            for (int i = v.length - 2; i > -1; i--) {
                for (int j = v.length - 1; j > i; j--) {
                    int cnt = isPrime(v[i] + v[j]) ? (dp[i + 1] - dp[j - 1] + dp[j + 1] + 1) : dp[i + 1];
                    dp[i] = (cnt > dp[i]) ? cnt : dp[i];
                }
            }

//        System.out.println(Arrays.toString(v));
//        System.out.println(Arrays.toString(dp));

            return dp[0];
        }
    }

