package com.hauwei;
import java.util.Scanner;
/**
 * 字符串合并处理
 *题目描述
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 *
 * 将输入的两个字符串合并。
 *
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 *
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 *
 *
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
 *
 * 接口设计及说明：
 *
 * /*
 *
 * 功能:字符串处理
 *
 * 输入:两个字符串,需要异常处理
 *
 * 输出:合并处理后的字符串，具体要求参考文档
 *
 * 返回:无
 *
 *
 *
         *void ProcessString(char*str1,char*str2,char*strOutput)
         *
         *{
         *
         *}
         *
         *
         *
         *输入描述:
         *输入两个字符串
         *
         *输出描述:
         *输出转化后的结果
         *
         *示例1
         *输入
         *复制
         *dec fab
         *输出
         *复制
         *5D37BF
 *
 */
public class ZiFuChuanHeBIngChuLi {


    /**
     * Author: 王俊超
     * Date: 2015-12-23 16:58
     * All Rights Reserved !!!
     */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
            while (scanner.hasNext()) {
                String s1 = scanner.next();
                String s2 = scanner.next();
                System.out.println(mergeStr(s1, s2));
            }

            scanner.close();
        }

        private static String mergeStr(String m, String n) {
            char[] chars = new char[m.length() + n.length()];

            // 拷贝字符串
            for (int i = 0; i < m.length(); i++) {
                chars[i] = m.charAt(i);
            }
            for (int i = 0; i < n.length(); i++) {
                chars[i + m.length()] = n.charAt(i);
            }

            // 对奇数位下标和偶数位下标进行排序
            sort(chars, 0);
            sort(chars, 1);
            for (int i = 0; i < chars.length; i++) {
                chars[i] = convert(chars[i]);
            }
            return new String(chars);
        }

        private static void sort(char[] chars, int beg) {
            for (int i = beg; i < chars.length; i += 2) {
                int idx = i;
                char tmp;
                for (int j = i + 2; j < chars.length; j += 2) {
                    if (chars[idx] > chars[j]) {
                        idx = j;
                    }
                }

                tmp = chars[i];
                chars[i] = chars[idx];
                chars[idx] = tmp;

            }
        }

        private static char convert(char c) {
            char[] mask = {'0', '8', '4', 'C', '2', 'A', '6', 'E', '1', '9', '5', 'D', '3', 'B', '7', 'F'};
            if ( c >= '0' && c <= '9') {
                return mask[c - '0'];
            } else if (c >= 'a' && c <= 'f') {
                return mask[c - 'a' + 10];
            } else if (c >= 'A' && c <= 'F') {
                return mask[c - 'A' + 10];
            }

            return c;
        }
    }

