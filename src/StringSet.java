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

        return(int) res;

    }

    /**
     * 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        boolean flag = false;

        if(s.length() != t.length()){
            return flag;
        }

        for (int i = 0; i < s.length(); i++) {
            //统计每一个字母出现的次数
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }
        if (Arrays.equals(countS,countT)) {
            flag = true;
        }
        return flag;
    }
}


