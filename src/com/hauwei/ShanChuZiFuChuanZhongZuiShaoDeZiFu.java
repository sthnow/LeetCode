package com.hauwei;
import java.util.Scanner;
/**
 * 删除字符串中出现次数最少的字符
 *
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入
 * 复制
 * abcdd
 * 输出
 * 复制
 * dd
 */
public class ShanChuZiFuChuanZhongZuiShaoDeZiFu {


        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            while (scanner.hasNext()) {
                String string = scanner.nextLine();
                judge(string);
                System.out.println();
            }
        }

        private static void judge(String string) {
            int[] counter_ch = new int[26];
            int min = string.length();
            for (int i = 0; i < string.length(); i++) {
                counter_ch[string.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (counter_ch[i] != 0) {
                    if (min > counter_ch[i]) {
                        min = counter_ch[i];
                    }
                }
            }
            for (int i = 0; i < string.length(); i++) {
                if (counter_ch[string.charAt(i) - 'a'] != min) {
                    System.out.print(string.charAt(i));
                }
            }
        }
    }

