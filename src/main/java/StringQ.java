import java.util.Arrays;

public class StringQ {


    /**
     * 反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     *
     * @param s
     * @return
     */
    public String reverseWords3(String s) {

        //第一种方法
        /*//以空格切割字符串
        String[] str = s.split(" ");
        String tem = "";
        for(int i = 0; i < str.length; i++){
            char[] c = new char[str[i].length()];
            for (int j = 0; j < str[i].length(); j++) {
                c[j] = str[i].charAt(str[i].length() - 1  -j);
            }
            if(i!= str.length -1){
                tem += String.valueOf(c) + " ";
            }else{
                tem += String.valueOf(c);
            }
        }
        return tem;*/

        //第二种方法

        //以空格切割字符串
        String[] str = s.split(" ");
        StringBuilder result = new StringBuilder();

        //翻转每一个单词
        for (int i = 0; i < str.length; i++) {
            char[] tem = str[i].toCharArray();

            for (int j = 0; j < str[i].length(); j++) {
                tem[j] = str[i].charAt(str[i].length() - 1 - j);
            }
            result.append(new String(tem) + " ");
        }
        return result.toString().trim();
    }

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
        if (length == 0) {
            return profit;
        }

        for (int i = 0; i < length - 1; i++) {
            if ((prices[i + 1] - prices[i]) > 0) {
                profit += (prices[i + 1] - prices[i]);
            }
        }

        return profit;
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     * <p>
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
         /*
            先给两个数组排序，排序完后依次比较两个数字的大小。从0开始遍历数组，
                若两个数字相等，则将数组存放在新的数组当中，脚标+1
                若两个数字不等，则数字小的数组角标加一
          */
        int i = 0, j = 0, k = 0;

        int[] result = new int[Math.min(nums1.length, nums2.length)];

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[k] = nums1[i];
                k++;
                i++;
                j++;
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }


        }
        return Arrays.copyOf(result, k);
    }

    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     * @param strs
     * @return
     */
   /* public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];


    }
    */

    /**
     * 验证回文字符串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "race a car"
     * 输出: false
     *
     * @param s
     * @return
     */

    public boolean isPalindrome(String s) {
        //将字符串化为小写字母
        String sLow = s.toLowerCase();
        //去掉所有的符号
        String sRep = sLow.replaceAll("[^a-z0-9]", "");
        //分割字符串
        String[] s1 = sRep.split("");

        boolean flag = true;
        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].equals(s1[s1.length - 1 - i])) {
                flag = false;
                break;
            }
        }
        return flag;
    }


    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

       /* if(strs.length == 0){
            return "";
        }

        String s0 = strs[0];
        int minIdex = 0;
        int minSize = 0;
        String comPre = "";
        minIdex = strs[0].length();

        for (int i = 0; i < strs.length ; i++) {
            if(strs[i].length() == 0){
                return "";
            }

            if(strs[i].length() < minIdex){
                minIdex = strs[i].length();
            }
        }

        for (int i = 0; i < minIdex ; i++) {
            for (int j = 0; j < strs.length; j++) {
                if(!(s0.substring(0,i).equals(strs[j].substring(0,i)))){
                    if(i == 1){
                        return "";
                    }
                    minSize = i;
                    comPre = strs[0].substring(0,minSize);
                    break;
                }
            }
        }
        return comPre;
*/

        StringBuilder prefix = new StringBuilder();
        if (strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    prefix.append(b[i]);
                } else {
                    return prefix.toString();
                }
            }
        }
        return prefix.toString();
    }


    /**
     * 计数质数
     * 统计所有小于非负整数 n 的质数的数量。
     * <p>
     * 示例:
     * <p>
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     */

    public int countPrimes(int n) {
    /*    int count = 0;
        boolean flag = false;

        if(n == 0 || n==1){
            return 0;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 2; j < i; j++) {
                if(i % j == 0 && i != j){
                    count++;
                    break;
                }

            }
        }
        return n-2-count;
        */


        int count = 0;

        boolean flag[] = new boolean[n];//初始全都false

        for (int i = 2; i < n; i++)
            if (flag[i] == false) {
                count++;
                for (int j = 1; j * i < n; j++)
                    flag[j * i] = true;
            }
        return count;
    }

    /**
     * 3的幂
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 27
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: 0
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: 9
     * 输出: true
     * 示例 4:
     * <p>
     * 输入: 45
     * 输出: false
     * 进阶：
     * 你能不使用循环或者递归来完成本题吗？
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        } else if (n == 3) {
            return true;
        } else {
            n = n / 3;
            return isPowerOfThree(n);
        }
    }

    /**
     * 151. 翻转字符串里的单词
     * 题目描述提示帮助提交记录社区讨论阅读解答
     * 随机一题
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * <p>
     * 示例:
     * <p>
     * 输入: "the sky is blue",
     * 输出: "blue is sky the".
     * 说明:
     * <p>
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * 进阶: 请选用C语言的用户尝试使用 O(1) 空间复杂度的原地解法。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        String[] str = s.trim().split(" ");

        StringBuffer result = new StringBuffer();


        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("")) {
                continue;
            } else {
                result.append(str[i] + " ");
            }
        }
        return result.toString().trim();
    }


    /**
     * 最长回文子串长度
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba"也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        //使用马拉松算法


        //首先去除字符串奇偶的影响
        int conut = 0;
        char[] tem = new char[s.length() * 2 + 1];

        for (int i = 0; i < s.length(); i++) {
            tem[conut++] = '#';
            tem[conut++] = s.charAt(i);
        }
        tem[conut] = '#';

        //分割完字符串后开始确定最长回文半径
        //mx为已知回文半径能达到的最远端
        int mx = 0;

        //id为当前回文串的对称轴，也就是中心
        int id = 0;

        //cur是整个字符串的长度
        int cur = conut;

        int result = 0;

        int[] p = new int[cur];

        //遍历整个数组的元素
        for (int i = 0; i < cur; i++) {

            //当前元素是否在已知回文半径内
            //如果在的话，当前元素的回文半径为
//                如果已知回文半径和i的距离小于其对称点的回文半径，表示当前元素的回文半径和其对称点的回文半径相同
//                反之则表示当前元素回文半径较大

//            如果当前元素在已知回文半径之外或在回文半径边上，则给当前元素回文半径赋1
            p[i] = (mx > i ? Math.min(p[2 * id - i], mx - i) : 1);

//            首先防止越界
//            其次，当左边界元素和右边界元素相等时，扩展半径
            while (i + p[i] < cur && (i - p[i] >= 0) && (tem[i + p[i]] == tem[i - p[i]]))
//            扩展半径
                ++p[i];

//            如果当前半径大于已知半径，更新回文半径
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }

//          取最大的为新的回文半径
            result = Math.max(result, p[i] - 1);
        }
        return result;
    }


    /**
     * 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba"也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
      /* if(s.equals(""))
           return "";
       if(s.length() == 1)
           return s;
        //使用循环的方法做

        int length = s.length();
        //center-对称中心
        int count = 0, maxCount = 0, center = 0;
        if (length % 2 != 0) {
            //奇数的情况下
            for (int i = 0; i < length; i++) {
                for (int j = 0; (i - j) >= 0 && (i + j) < length; j++) {
                    if (s.charAt(i + j) != s.charAt(i - j))
                        break;
                    count = j * 2 + 1;
                }
                if (maxCount < count) {
                    maxCount = count;
                    center = i;
                }
            }
        } else {
            //偶数的情况
            for (int i = 0; i < length; i++) {
                for (int j = 0; (i - j >= 0) && (i + j + 1 < length); j++) {
                    if (s.charAt(i - j) != s.charAt(i + j + 1))
                        break;
                    count = j * 2 + 2;
                }
                if (maxCount < count) {
                    maxCount = count;
                    center = i;
                }
            }
        }

        StringBuffer ss = new StringBuffer();

        //判断maxcount的奇偶
        if (maxCount % 2 == 0) {
            //如果长度是偶
            maxCount = maxCount / 2;
        } else {
            maxCount = maxCount / 2 + 1;
        }
        //找出回文子串
        for (int i = center - maxCount + 1; i <= center; i++) {
            ss.append(s.charAt(i));
        }
        ss.append(s.charAt(center + 1));
        return ss.toString();
*/

        if(s.equals(""))
            return "";
        if(s.length() == 1)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}


