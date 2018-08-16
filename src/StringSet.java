import java.util.Arrays;

public class StringSet {
    public void reverseString(String s) {
        //定义变量
        String rs = "";
        StringBuffer sb = new StringBuffer();
        String[] array = s.split("");
        String[] reArray = new String[array.length];

        //颠倒字符串
        for (int i = 0; i < array.length; i++) {
            reArray[i] = array[array.length - 1 - i];
            sb.append(reArray[i]);
        }
        rs = sb.toString();
        //输出
        System.out.println(rs);

    }

    /**
     * 字符串中的第一个唯一字符
     * <p>
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * <p>
     * 案例:
     * <p>
     * s = "leetcode"
     * 返回 0.
     * <p>
     * s = "loveleetcode",
     * 返回 2.
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.split("").length; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.split("").length; i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;


       /* if (s.isEmpty()) {
            return -1;
        } else if (s.split("").length == 1) {
            return 0;
        } else {
            String[] ss = s.split("");
            int index = -1;

            for (int i = 0; i < ss.length; i++) {
                for (int j = i + 1; j < ss.length; j++) {

                    if (!ss[i].equals(ss[j])) {
                        if (j == ss.length - 1 && i != ss.length -2) {
                            index = i;
                            return index;
                        }
                    } else {
                        break;
                    }
                }
            }
            return index;
        }
    }
}

*/
    }

    public int strStr(String haystack, String needle) {
        String[] str = haystack.split(needle);
        if (str.length == 0 || str[0].length() == haystack.length()) {
            if (needle.equals("") || str.length == 0) {
                return 0;
            } else {
                return -1;
            }

        } else {
            return str[0].length();
        }
    }

    public int reverse(int x) {
        long res = 0;
        int flag = 0;

        if (x < 0) {
            x = x * -1;
            flag = 1;
        }
        while (x / 10 > 0) {
            res += x % 10;
            res *= 10;
            x = x / 10;
        }
        res += x;
        if (flag == 1) {
            res *= -1;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) res;

    }

    /**
     * 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * <p>
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        boolean flag = false;

        if (s.length() != t.length()) {
            return flag;
        }

        for (int i = 0; i < s.length(); i++) {
            //统计每一个字母出现的次数
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }
        if (Arrays.equals(countS, countT)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 加一
     * 解法：更高位的进位由低位的进位而来，若低位无进位，则高位不用进位
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;

        //循环判断低位是否有进位
        //若有进位，则继续计算；若无进位，则返回结果
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                return digits;
            }
            int temp = digits[i] + carry;
            carry = temp / 10;
            digits[i] = temp % 10;
        }

        //如果最高位有进位
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }


    /**
     *两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     *
     *    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     *    我们可以不考虑输出结果的顺序。
     * 进阶:
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * @param nums1
     * @param nums2
     * @return
     */
  /*  public int[] intersect(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = 0; j < nums2.length - 1; j++) {
                if(nums1[i] - nums2[j] == 0 ){

                }
            }
        }
    }
    */


    /**
     * 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int length = prices.length;
        int profit = 0;
        if(length == 0){
            return profit;
        }

        for (int i = 0; i < length - 1; i++) {
            if((prices[i+1] - prices[i]) > 0 ){
                profit += (prices[i+1] - prices[i]);
            }
        }

        return profit;
    }
}


