package com.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最大乘积
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * <p>
 * 输入描述:
 * 无序整数数组A[n]
 * <p>
 * 输出描述:
 * 满足条件的最大乘积
 * <p>
 * 输入例子1:
 * 3 4 1 2
 * <p>
 * 输出例子1:
 * 24
 */
public class MaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] nums = new long[n];

        if (n < 3) {
            System.out.println("0");
            return;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        if (nums[1] < 0 || nums[0] < 0) {
            if (nums[0] * nums[1] * nums[n - 1] < nums[n - 1] * nums[n - 2] * nums[n - 3]) {
                System.out.println(nums[n - 1] * nums[n - 2] * nums[n - 3]);
            } else {
                System.out.println(nums[0] * nums[1] * nums[n - 1]);
            }
        } else {
            if (nums[0] * nums[1] * nums[2] < nums[n - 1] * nums[n - 2] * nums[n - 3]) {
                System.out.println(nums[n - 1] * nums[n - 2] * nums[n - 3]);
            } else {
                System.out.println(nums[0] * nums[1] * nums[2]);
            }
        }
    }
}