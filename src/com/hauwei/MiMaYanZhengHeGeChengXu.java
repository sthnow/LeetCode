package com.hauwei;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 密码验证合格程序
 *
 * 题目描述
 * 密码要求:
 *
 *
 *
 *
 *
 *
 *
 * 1.长度超过8位
 *
 *
 *
 *
 *
 *
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 *
 *
 *
 *
 *
 *
 * 3.不能有相同长度超2的子串重复
 *
 *
 *
 *
 *
 *
 *
 * 说明:长度超过2的子串
 *
 *
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 *
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入
 * 复制
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * 复制
 * OK
 * NG
 * NG
 * OK
 */
public class MiMaYanZhengHeGeChengXu {

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                while (sc.hasNext()) {
                    String s = sc.next();
                    if (f(s)) {
                        System.out.println("OK");
                    } else {
                        System.out.println("NG");
                    }
                }
            }

            // 数字，大小写字母，符号
            static boolean f(String s) {
                int flag = 0;
                Pattern p1 = Pattern.compile(".*[a-z]+.*");//小写字母
                Pattern p2 = Pattern.compile(".*[0-9]+.*");//数字
                Pattern p3 = Pattern.compile(".*[^0-9a-zA-Z]+.*");//符号(除了字母和数字)
                Pattern p4 = Pattern.compile(".*[A-Z]+.*");//大写字母

                Matcher m1 = p1.matcher(s);
                Matcher m2 = p2.matcher(s);
                Matcher m3 = p3.matcher(s);
                Matcher m4 = p4.matcher(s);

                if (m1.matches()) {
                    flag++;

                }
                if (m2.matches()) {
                    flag++;

                }
                if (m3.matches()) {
                    flag++;

                }
                if (m4.matches()) {
                    flag++;

                }

                if (s.length() > 8 && flag >= 3 && f1(s)) {
                    return true;
                }
                return false;
            }

            //判断是否有长度为3的字符子串相同
            static boolean f1(String s) {

                for (int i = 0; i < s.length()-3; i++) {
                    String s1 = s.substring(i,i+3);
                    String s2 = s.substring(i+3);

                    if (s2.contains(s1)) {

                        return false;

                    }
                }

                return true;
            }
        }
