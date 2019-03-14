package main.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class ArrayQ {

    /**
     * 2的幂
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     *
     * 示例 1:
     *
     * 输入: 1
     * 输出: true
     * 解释: 20 = 1
     * 示例 2:
     *
     * 输入: 16
     * 输出: true
     * 解释: 24 = 16
     * 示例 3:
     *
     * 输入: 218
     * 输出: false
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
//       //第一种方法，使用Math函数
//        if(n <= 0){
//            return false;
//        }
//        //1是任何数得幂
//        if( 0 < n  &&  n <= 3){
//            return true;
//        }
//        /*
//        * 思想：
//        *   对n取对数得num，然后对结果在取num幂次，如果等于n，则是2的幂
//        *   如果不等于2，则不为2得幂*/
//            int num = (int) (Math.log(n) / Math.log(2));
//            if(Math.pow(2,num) == n){
//                return true;
//            }else{
//                return false;
//            }


//        //第二种方法
//        //时间复杂度太大
//        //首先排除n<=0的情况
//        if(n <= 0){
//            return false;
//        }
//        //1是任何数的幂
//        if(n == 1){
//            return true;
//        }
//
//        //接下来开始判断
//        int small = 2;
//        int big = 4;
//        while(small != n && big != n){
//            if(small < n && n < big){
//                return  false;
//            }
//            small *=2;
//            big *= 2;
//        }
//        return true;

        //第三种方法
        if (n <= 0)
            return false;
        if (n == 1) {
            return true;
        }
        String[] num = Integer.toBinaryString(n).split("");

        for (int i = num.length - 1; i > 0; i--) {
            if (!num[i].equals("0")) {
                return false;
            }

        }
        if (num[0].equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 三数之和
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i, j, k, reverse;

        for (i = 0; i < nums.length; i++) {
            j = i + 1;
            k = nums.length - 1;
            reverse = -nums[i];

            while (j < k) {
                if (nums[j] + nums[k] == reverse) {
                    List<Integer> tem = new ArrayList<Integer>();
                    tem.add(nums[i]);
                    tem.add(nums[j]);
                    tem.add(nums[k]);
                    result.add(tem);
                    j++;

                    //如果在j<k的前提下, j和之前的数相等,则后移一位
                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                    //第一个数没变,若变第二个数则第三个数必须也要变,否则三者之和不为0
                    k--;

                    //如果三者之和不为0,保持第一个数不变,变剩下的两个
                } else if (nums[j] + nums[k] < reverse) {
                    j++;
                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }

                    //保证了第二个数和之前的不一样,那么三者和为0的话,第三个数必定和之前不一样
                } else {
                    k--;
                }
            }

            //变动第一个数
            //首先保证i不能越界
            while (i +1 < nums.length -2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }


    /**
     * 无重复字符的最长子串
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     *      请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        //创建动态数组
        int maxLength = 1;
        List<Character> list = new ArrayList<Character>();
        list.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            //如果不包含该字符
            if(!list.contains(s.charAt(i))){
                //添加到list中
                list.add(s.charAt(i));
                //计算list的长度;
                maxLength = Math.max(maxLength,list.size());


                //如果包含了某字符
            }else{
                //去掉该字符,将新的字符添加进去
                int index = list.indexOf(s.charAt(i));
                list = list.subList(index+1, list.size());
                list.add(s.charAt(i));
                maxLength = Math.max(maxLength, list.size());
            }
        }
        return maxLength;
    }


    /**
     * 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba"也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     * @param s
     * @return
     */
//    public String longestPalindrome(String s) {
//        //将字符串分割成字符串数组
//        String[] ss = s.split("");
//        //实例化StringBuffer对象
//        StringBuffer tem = new StringBuffer();
//        int j = 1;
//        int count = 0;
//        //进入循环
//        for (int i = 0; i < ss.length; i++) {
//            String current = ss[i];
//            while (ss[i + j] != ss[i]) {
//                tem.append()
//                j++;
//                count++;
//            }
//
//
//        }
//
//
//
//        //终止条件
//
//       return tem.toString();
//    }

    public static class binary_search {


        int[] num = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        public static void main(String[] args) {
            binary_search bs = new binary_search();
            bs.search(bs.input(), bs.num);

        }

        public int input() {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数字");
            String s = sc.next();
            System.out.println("您输入的数字为" + s);
            sc.close();
            int num = Integer.valueOf(s);
            return num;
        }

        public void search(int target, int[] num) {

            int low = 0;
            int counter = 0;
            int high = num.length - 1;

            while (low <= high) {


                counter = counter + 1;

                int mid = (low + high) / 2;
                int guess = num[mid];
                if (guess == target) {
                    System.out.println("已找到该数字,迭代了：" + counter + " 次");
                    break;
                } else if (guess < target && guess < num[high]) {
                    low = mid + 1;
                } else if (guess > target && guess > num[low]) {
                    high = mid - 1;
                } else {
                    System.out.println("未能找到该数字");
                    break;

                }

            }
        }
    }

    public static class containsDuplicate {
        public boolean containsDuplicate(int[] nums) {
            boolean flag = false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return flag = true;
                    }
                }
            }
            return flag;
        }
    }

    public static class MoveZeroes {
        public void moveZeroes(int[] nums) {

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[count] = nums[i];
                    count++;
                }
            }
            while (count < nums.length) {
                nums[count++] = 0;
            }

            System.out.println(Arrays.toString(nums));

        }
    }

    public static class num2eng {
        //定义了若干个成员变量
        //该成员变量为类变量
        private String[] eng = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        private String[] Number = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        private String[] ShiWei = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        private String[] Qian = {"", "thousand", "thousand", "thousand", "thousand", "thousand", "thousand", "thousand", "thousand", "thousand"};
        private String[] Bai = {"", "hundred", "hundred", "hundred", "hundred", "hundred", "hundred", "hundred", "hundred", "hundred"};

        //定义了名为divide的方法
        //分割数字的位数
        public static int[] divide(int num) {
            int num30 = num / 1000;
            int num20 = (num - num30 * 1000) / 100;
            int num10 = (num - num30 * 1000 - num20 * 100) / 10;
            int num0 = num - num30 * 1000 - num20 * 100 - num10 * 10;
            //定义一个包含了num30，num20，num10，num0的数组
            int[] numSum = new int[]{num30, num20, num10, num0};
            return numSum;
        }

        public static void main(String[] args) {
            //使用构造器构造了一个名为ne的num2eng的类
            num2eng ne = new num2eng();
            System.out.print(ne.toEngStr());

        }

        //定义了名为toEngStr的方法
        //将分割后的数字转换成英文
        public String toEngStr() {
            String result = "";
            int[] numSum;
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数字：");
            int n = sc.nextInt();
            sc.close();
            numSum = divide(n);

            //根据位数判断该输出什么
            if ((numSum[2] == 1) && numSum[1] != 1) {
                result += ShiWei[numSum[3]];
            } else if ((numSum[2] == 1) && numSum[1] == 1) {
                result += eng[numSum[1]] + " " + Bai[numSum[1]] + " " + ShiWei[numSum[3]];
            } else if (numSum[3] == 0) {
                result += "zero";
            } else {
                result += eng[numSum[0]] + " " + Qian[numSum[0]] + " " + eng[numSum[1]] + " " + Bai[numSum[1]] + " " + Number[numSum[2]] + " " + eng[numSum[3]];
            }
            return result;
        }

    }

    public static class quicksort {


        static quicksort qs = new quicksort();
        private int[] less;
        private int[] greater;

        public static void main(String[] args) {
            int[] result = qs.sort(new int[]{6, 5, 4, 3, 2, 1});
            System.out.println(Arrays.toString(result));
        }

        public int[] sort(int[] num) {
            /**
             * 使用了递归的思想
             * 步骤
             *      1.基线条件：若数组中的数小于2，则结束递归（若数组中只有一个数就不用排序）
             *      2.递归条件：在数组中选取一个基准值，将数组分为小于该基准的部分和大于该基准的部分
             */
            //int[] basenum = new int[]{num[0]};
            int[] less = new int[0];
            int[] greater = new int[0];

            if (num.length < 2) {
                return num;
            } else {
                int[] combition = new int[0];
                for (int i = 0; i < num.length - 1; i++) {
                    int base = num[0];
                    if (base >= num[i]) {
                        less = new int[i + 1];
                        for (int j = 0; j <= i; j++) {
                            less[j] = num[j];
                        }
                    }

                    if (base < num[i]) {
                        greater = new int[i + 1];
                        for (int j = 0; j <= i; j++) {
                            less[j] = num[j];
                        }
                    }

                    //合并数组
                    int length = less.length + 1 + greater.length;
                    combition = new int[length];
                    //将less放入数组
                    for (int j = 0; j < less.length - 1; j++) {
                        combition[j] = less[j];
                    }
                    //将基准值放入数组
                    combition[less.length] = base;
                    //将greater放入数组
                    for (int k = 0; k < greater.length - 1; k++) {
                        combition[less.length + 1 + k] = greater[k];
                    }

                    //返回合数组

                }
                return qs.sort(combition);
            }
        }
    }

    public static class ReverseInteger {

        public static void main(String[] args) {
            ReverseInteger ri = new ReverseInteger();
            int[] num = ri.reverse(ri.input());
            for (int i : num) {
                System.out.print(i + ",");
            }
        }

        //输入方法，返回一个字符串
        public String input() {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数字");
            String s = sc.next();
            System.out.println("你输入的数字为" + s);
            sc.close();
            return s;
        }


        public int[] reverse(String s) {
            //先将字符串转换为String数组
            String[] ss = s.split("");


            //字符之间的比较不能用 "==",这个是比引用
            //带有字符的情况
            if (ss[0].equals("+") || ss[0].equals("-")) {
                System.out.print(ss[0]);

                int[] num = new int[ss.length - 1];
                int[] temp = num;
                int number = 0;

                //将String数组转换为int数组
                for (int i = 1; i <= ss.length - 1; i++) {
                    num[i - 1] = Integer.parseInt(ss[i]);
                }

                ReverseInteger ri = new ReverseInteger();
                return temp = ri.normalReverse(num);


            } else {
                //不带有字符的情况
                int[] num = new int[ss.length];
                int[] temp = num;
                int number = 0;


                //将String数组转换为int数组
                for (int i = 0; i <= ss.length - 1; i++) {
                    num[i] = Integer.parseInt(ss[i]);
                }
                ReverseInteger ri = new ReverseInteger();
                return temp = ri.normalReverse(num);
            }
        }


        //反转的方法,由reverse调用
        public int[] normalReverse(int[] num) {
            int number = 0;
            for (int i = num.length - 1; i >= 0; i--) {
                if (num[i] == 0) {
                    number = number + 1;
                } else {
                    break;
                }
            }
            int[] end = new int[num.length - number];
            for (int j = num.length - 1 - number; j >= 0; j--) {
                end[num.length - 1 - number - j] = num[j];
            }
            return end;
        }
    }

    public static class singleNumber {
        public int singleNumber(int[] nums) {

            int xor = 0;
            for (int i = 0; i < nums.length; i++) {
                xor ^= nums[i];
            }
            return xor;
        }
    }

    public static class TwoSum {


        public static void main(String[] args) {
            TwoSum twoSum = new TwoSum();
            Integer[] num = twoSum.input1();
            int target = twoSum.input2();
            String[] strings = twoSum.add(num, target);

            System.out.print("和对应的序号为:" + strings[0] + "," + strings[1]);
        }

        //输入数组的代码
        public Integer[] input1() {

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数组的值:");
            String[] numS = sc.next().split(",");

            //先将字符数组转换成字符串,在使用Interger的parseInt方法将字符串转换成数字
            //  int num =  Integer.parseInt(String.valueOf(numS));
            //  return num;

            //将字符数组转换成int数组
            Integer[] num = new Integer[numS.length];
            for (int i = 0; i < numS.length; i++) {
                num[i] = Integer.valueOf(numS[i]);
            }
            return num;
        }

        //输入target值的代码
        public int input2() {
            System.out.println("请输入二者之和的值:");
            Scanner sc = new Scanner(System.in);
            String target = sc.next();
            sc.close();
            return Integer.valueOf(target);
        }

        //处理逻辑的代码
        public String[] add(Integer[] num, int target) {

            int i, j = 0;
            String[] strings = new String[2];
            outer:
            for (i = 0; i <= num.length - 1; i++) {
                for (j = i + 1; j <= num.length - 1; j++) {
                    if (num[i] + num[j] == target) {
                        //一个break语句只能结束一个循环
                        //如果想要结束外层循环需要加outer标签
                        break outer;
                    }
                }
            }
            /* *
             * 异常有两种情况:
             *      1.目标值太大
             *      2.目标值太小
             * 处理这两种异常有两中方法
             *      1.要么在for循环里面遍历,先遍历一遍每个值的和是否能满足target,在遍历一遍寻找target的值
             *      2.要么在原来的代码末尾加上if语句,因为遍历寻找完成后,如果没能找到target的值,i和j的值都是5,根据这个特点可以加上
             *      下文的if语句,还有target太小的情况,从num[0]开始算起即可*/
            if (num[i - 1] + num[j - 2] < target || num[0] + num[1] > target)
                throw new RuntimeException("数组内两个值之和不能等于对应的目标值");
            // System.out.println(i + "," + j);
            strings[0] = String.valueOf(i);
            strings[1] = String.valueOf(j);
            return strings;
        }


        /**
         * 两整数之和
         * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
         *
         * 示例 1:
         *
         * 输入: a = 1, b = 2
         * 输出: 3
         * 示例 2:
         *
         * 输入: a = -2, b = 3
         * 输出: 1
         * @param a
         * @param b
         * @return
         */

    }

    public int getSum(int a, int b) {
        //按位取异或
        int result = a^b;
        //判断是否需要进位
        int forward = (a&b) <<1;
        if(forward!=0){
            //如有进位，则将二进制数左移一位，进行递归
            return getSum(result,forward);
        }
        return result;
    }



}


