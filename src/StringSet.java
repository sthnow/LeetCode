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
        int length = str.length;
        if (str.length == haystack.length()) {
            if (needle.equals("")) {
                return 0;
            } else {
                return -1;
            }

        } else {
            return str[0].length();
        }
    }
}


