package com.hauwei;
import java.util.Scanner;
/**
 * 合唱队
 *题目描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 *
 *
 * 输入描述:
 * 整数N
 *
 * 输出描述:
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入
 * 复制
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出
 * 复制
 * 4
 *
 */
public class HeChangDui {



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                System.out.println(countChorus(arr));
            }

            scanner.close();
        }

        /**
         * <pre>
         * 解题思路
         * 乍一看这道题好像无从下手？难不成要枚举出所有的情况才能得出结果。一般来说是不会有那种枚举所有情况的题的。
         * 实际上这是一道简单动态规划的题。但是一眼看上去不是很直观。题目所谓的合唱队形就是一个最长上升子序列的拼接。
         * 只要求出从队列首到位置 i 的最长上升子序列长度加上从队尾开始到位置 i 的最长上升子序列的长度就能求出合唱队
         * 形的总长度。 我们还知道总的人数，减一下就能得出要出列的人数了。
         *
         * 求最长上升子序列
         * 现在有一个序列，要求他的最长上升子序列。直观上并不是很好求得，反过来看的话就能比较好理解：
         * 现在对于总序列里的第i个元素来说，包含元素i的最长子序列是多少呢？如果i前面有能构成最长上升序列的（设它为j），
         * 而且i数值比j大，那很显然到第i个元素(包含元素i)的最长子序列是到第j个元素的最长子序列+1；否则到第i个元素
         * (包含元素i)的最长子序列就是是1。因为前面没有比他更小的了，只有自身构成一个子序列。
         * </pre>
         *
         * @param arr
         * @return
         */
        private static int countChorus(int[] arr) {

            int[] ltr = getRiseLongestSequenceLeftToRight(arr);
            int[] rtl = getRiseLongestSequenceRightToLeft(arr);
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                if (max < ltr[i] + rtl[i]) {
                    max = ltr[i] + rtl[i] - 1;
                }
            }

            return arr.length - max;
        }

        private static int[] getRiseLongestSequenceLeftToRight(int[] arr) {
            int[] ltr = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                ltr[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j] && ltr[i] <= ltr[j]) {
                        ltr[i] = ltr[j] + 1;
                    }
                }
            }

            return ltr;
        }

        private static int[] getRiseLongestSequenceRightToLeft(int[] arr) {
            int[] rtl = new int[arr.length];

            for (int i = arr.length - 1; i >= 0; i--) {
                rtl[i] = 1;
                for (int j = arr.length - 1; j > i; j--) {
                    if (arr[i] > arr[j] && rtl[i] <= rtl[j]) {
                        rtl[i] = rtl[j] + 1;
                    }
                }
            }

            return rtl;
        }

    }


