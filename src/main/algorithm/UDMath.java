public class UDMath {


    /**
     * x 的平方根
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) throws Exception {

        if (x == 0)
            return 0;

        //定义变量的初始值
        int left = 1, right = x, ans = 0;

        //循环条件，当左 <= 右时
        while (left <= right) {

            //取中间值为 left + (rigth - left ) / 2
            int mid = left + (right - left) / 2;

            //如果 mid的平方小于 x
            if (mid <= x / mid) {
                //调整左端点的值
                left = mid + 1;

                ans = mid;

                //如果 mid 的平方大于x
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }


    /**
     * 阶乘后的零
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * 示例 2:
     * <p>
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     * 说明: 你算法的时间复杂度应为 O(log n) 。
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        /*通过计算规律可以发现
         * 当n为5的倍数时,阶乘后的零为5的倍数
         * 当n为25的倍数时,阶乘后零的数目会 +1*/
        boolean flag = true;
        int num = 0;

        while (flag) {
            n = n / 5;
            num += n;
            if (n / 5 == 0)
                flag = false;
        }
        return num;
    }


    //类结束括号
}
