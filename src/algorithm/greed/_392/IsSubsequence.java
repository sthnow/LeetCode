package algorithm.greed._392;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 * <p>
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        /*
        首先判断s和t是否为null或者是空串
        遍历t，如果t[i]中有s[j]的字符，那么j+1，继续遍历
        如果j == s。length,则表示t中含有s的全部字符
        如果遍历完后 j != s.length，则表示t中不含有s的全部字符
         */
        if (s == null ||  t == null ) return false;
        if(s.equals("") || s.equals("") && t.equals(""))return true;

        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if(j == s.length()){
                return true;
            }
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
        }
        if(j == s.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "";
        String t = "ahcss";
        System.out.println(isSubsequence(s, t));
    }
}
