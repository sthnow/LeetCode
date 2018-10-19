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
     * 移位运算实现加减乘除详解以及java源码实现
     */
    /**
     * 使用位运算实现数字加法
     *
     * @param a
     * @param b
     * @return
     */
    public int UDAdd(int a, int b) {

        //不进位加法
        int result,carry;
        result= a ^ b;

        //如果两数相加有进位
        carry = (a & b) << 1;

        //当进位不为0时
        while (carry != 0) {
            //不带进位的结果加上进位
            result = a ^ b;
            //判断有没有进位
            carry = (a & b) <<1;
            a = result;
            b = carry;
        }
        return result;
    }


    public int UDSub(int a, int b){
        return UDAdd(a,UDAdd(~b,1));
    }


    /**
     * 二进制乘法
     * 先看一个实例：1011*1010：
     *
     * 1011
     *    * 1010
     *  ----------
     *     10110 < 左移一位，乘以0010
     * + 1011000 < 左移3位，乘以1000
     * ----------
     *   1101110
     *
     * 因而乘法可以通过系列移位和加法完成。最后一个1可通过b&~(b-1)求得，可通过b& (b-1)去掉，为了高效地得到左移的位数，可提前计算一个map。
     * ---------------------
     * 作者：tingting256
     * 来源：CSDN
     * 原文：https://blog.csdn.net/tingting256/article/details/52550188
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     * @param a
     * @param b
     * @return
     */
    public int MyMuti(int a, int b){

        Boolean flag = (b < 0);
        if(flag) b = -b;

        //多态的体现，使用父类的引用指向子类的实现
        //这样做的好处是只用关心接口的方法而不用关心具体的实现
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 32; i++) {
            map.put(1<<i,i);
        }
        int sum = 0;
        while(b > 0){
            int last = b & (~b + 1);    //取得最后一个1
            int count = map.get(last);  //获取移位的次数
            sum += a << count;
            b = b & (b-1);  //去掉最后一个1

        }

        if(flag) sum = -sum;
        return sum;

    }
    //类结束括号
}
