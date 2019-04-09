package algorithm.greed._376;

/**
 * 376. 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * <p>
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * <p>
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 * <p>
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 * <p>
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 */
public class WiggleSubsequence {
    /*
    如果数组长度小于2，返回数组的长度
    如果数组长度==2，如果两个数差值为0，那么摆动序列长度为1.如果差值不为0，则摆动序列长度为2
    如果前一个差与后一个差异号，那么说明是摆动序列，计数+1
    如果前一个差为0，那么后一个差不为0也算是摆动序列
     */
    public static int wiggleMaxLength(int[] nums) {

        int p = 1, q = 1, n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) p = q + 1;
            else if (nums[i] < nums[i - 1]) q = p + 1;
        }
        return Math.min(n, Math.max(p, q));
//        int n = nums.length;
//        if (n < 2) return n;
//
//        int result = nums[1] != nums[0] ? 2 : 1;
//        int flag = nums[1] - nums[0];
//        for (int i = 2; i < nums.length ; i++) {
//            if((nums[i] - nums[i-1]) * flag < 0 || (flag == 0 &&(nums[i]-nums[i-1]) != 0)){
//                result++;
//                flag = nums[i] - nums[i - 1];
//            }
//        }
//        return  result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 2, 5};
        System.out.println(wiggleMaxLength(nums));
    }
}
