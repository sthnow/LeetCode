package main.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MyMath {


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


    /**
     * 两数相除
     给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

     返回被除数 dividend 除以除数 divisor 得到的商。

     示例 1:

     输入: dividend = 10, divisor = 3
     输出: 3
     示例 2:

     输入: dividend = 7, divisor = -3
     输出: -2
     说明:

     被除数和除数均为 32 位有符号整数。
     除数不为 0。
     假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        // 相除时溢出处理
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 求符号位
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // 求绝对值，为防止溢出使用long
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        // 记录结果
        int result = 0;

        // 被除数大于除数
        while (dvd >= dvs) {
            // 记录除数
            long tmp = dvs;
            // 记录商的大小
            long mul = 1;

            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }

            // 减去最接近dvd的dvs的指数倍的值（值为tmp）
            dvd -= tmp;

            // 修正结果
            result += mul;
        }

        return result * sign;
    }


    /**
     * 移位运算实现加减乘除详解以及java源码实现
     */
    /**
     * 使用位运算实现数字加法
     *
     * @param a
     * @param b
     * @return
     */
    public int myAdd(int a, int b) {

        //不进位加法
        int result, carry;
        result = a ^ b;

        //如果两数相加有进位
        carry = (a & b) << 1;

        //当进位不为0时
        while (carry != 0) {
            //不带进位的结果加上进位
            result = a ^ b;
            //判断有没有进位
            carry = (a & b) << 1;
            a = result;
            b = carry;
        }
        return result;
    }


    public int mySub(int a, int b) {
        return myAdd(a, myAdd(~b, 1));
    }


    /**
     * 二进制乘法
     * 先看一个实例：1011*1010：
     * <p>
     * 1011
     *    * 1010
     *  ----------
     *     10110 < 左移一位，乘以0010
     * + 1011000 < 左移3位，乘以1000
     * ----------
     *   1101110
     * <p>
     * 因而乘法可以通过系列移位和加法完成。最后一个1可通过b&~(b-1)求得，可通过b& (b-1)去掉，为了高效地得到左移的位数，可提前计算一个map。
     * ---------------------
     * 作者：tingting256
     * 来源：CSDN
     * 原文：https://blog.csdn.net/tingting256/article/details/52550188
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     *
     * @param a
     * @param b
     * @return
     */
    public int MyMuti(int a, int b) {

        Boolean flag = (b < 0);
        if (flag) b = -b;

        //多态的体现，使用父类的引用指向子类的实现
        //这样做的好处是只用关心接口的方法而不用关心具体的实现
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 32; i++) {
            map.put(1 << i, i);
        }
        int sum = 0;
        while (b > 0) {
            int last = b & (~b + 1);    //取得最后一个1
            int count = map.get(last);  //获取移位的次数
            sum += a << count;
            b = b & (b - 1);  //去掉最后一个1

        }

        if (flag) sum = -sum;
        return sum;
    }


    public int myDiv(int a, int b) {
        boolean flag = (a < 0) ^ (b < 0);
        if (a < 0) a = -a;
        if (b < 0) b = -b;

        int msb = 0;

        //找到 b 大于 a 时的比例
        while ((b << msb) < a) {
            msb++;
        }

        //q是余数
        int q = 0;
        for (int i = msb; i >= 0; i--) {

            //处理越界问题,即 b 左移 i 位后大于 a 的情况
            //如果 b 越界,忽略这次循环
            if ((b << i) > a) continue;

            //加上每次的商,因为每次的 i 不可能相同,因此这里的 或 就相当于 加
            q |= (1 << i);

            //更新被除数的值
            a -= (b << i);
        }
        if (flag) return -q;
        return q;
    }


    /**
     * 思路：
     * 除法就是看 被除数 里面有多少个 除数
     *
     * @param a
     * @param b
     * @return
     */
    public int myDiv_v2(int a, int b) {
        //先去除符号的影响，都转换为正数

        int dividend = a > 0 ? a : myAdd(~a, 1);    //被除数
        int divisor = b > 0 ? b : myAdd(~b, 1);  //除数

        int quotient = 0;   //商
        int remainder = 0;  //余数

        for (int i = 31; i >= 0; i--) {
            if ((dividend >> i) >= divisor) {
                quotient = myAdd(quotient, 1 << i);
                dividend = mySub(dividend, divisor << i);
            }
        }
        if ((a ^ b) < 0) {
            quotient = myAdd(~quotient, 1);
        }

        remainder = b > 0 ? dividend : myAdd(~dividend, 1);
        return quotient;

    }


    /**
     * Pow(x, n)
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     *
     * 示例 1:
     *
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     *
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     *
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     * 说明:
     *
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 1.0){
            return x;
        }


        double sum = 1;
        double temp = x;
        boolean flag = false;
        if(n < 0){
            flag = true;
            n = -n;
        }
        while(n != 0){
            if(n % 2 == 1){
                sum = sum * temp;
            }

            temp = temp * temp;
            n = n >>> 1;
        }
        if(flag == false)
            return sum;
        else
            return 1/sum;


    }
    //类结束括号
}
