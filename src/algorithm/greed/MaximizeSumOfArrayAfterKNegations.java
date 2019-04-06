package algorithm.greed;

import com.secondleetcod.Array;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * <p>
 * 以这种方式修改数组后，返回数组可能的最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 * <p>
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 * <p>
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 */
public class MaximizeSumOfArrayAfterKNegations {

    public static int largestSumAfterKNegations(int[] A, int K) {
        //先对数组进行排序，
        //把最小的负数都翻转一遍
        //翻转完后若翻转次数不为0，则在对数组进行排序，在最小的数字上消耗翻转次数

        //数组的和
        int sum = 0;

        //数组中负数的个数
        int count = 0;
        Arrays.sort(A);

        //统计数组中负数的个数
        for (int i = 0; i < A.length; i++) {
            //如果出现整数，跳出循环
            if (A[i] >= 0) break;
            count++;
        }

        //如果负数的个数比翻转次数大，也就是翻转以后还有负数，将前面的负数反转后求和
        if (count >= K) {
            for (int i = 0; i < K; i++) {
                sum += -A[i];
            }
            for (int i = K; i < A.length; i++) {
                sum += A[i];
            }
            return sum;
        }
        //如果负数的个数比翻转次数小，也就是负数都被反转后还有翻转次数，这时求出把负数翻转完后剩余的翻转次数。
        //若为偶，则正常求和
        //若为奇，则对数组重新进行排序，将最小的数字反转后求和
        else {
            for (int i = 0; i < count; i++) {
                A[i] = -A[i];
            }

            if ((K - count) % 2 == 0) {
                for (int i = 0; i < A.length; i++) {
                    sum += A[i];
                }
            } else {
                Arrays.sort(A);
                sum -= A[0];
                for (int i = 1; i < A.length; i++) {
                    sum += A[i];
                }

            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,-1,0,2};
        int K = 2;
        System.out.println(largestSumAfterKNegations(A,K));
    }
}
