package com.hauwei;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 字符串排序
 *
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 *        如，输入： Type   输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 *      如，输入： BabA   输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *      如，输入： By?e   输出： Be?y
 *
 * 样例：
 *
 *     输入：
 *
 *    A Famous Saying: Much Ado About Nothing(2012/8).
 *
 *     输出：
 *
 *    A  aaAAbc   dFgghh :  iimM   nNn   oooos   Sttuuuy  (2012/8).
 *
 *
 * 输入描述:
 *
 *
 * 输出描述:
 *
 *
 * 示例1
 * 输入
 * 复制
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出
 * 复制
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class ZiFuChuanPaiXu {

        public static void main(String[] args) {

            Scanner in=new Scanner(System.in);
            while(in.hasNext()){
                String string=in.nextLine();
                LinkedList<String> list=new LinkedList<>();
                char[] cs=string.toCharArray();
                for(int i=0;i<cs.length;i++){
                    if((cs[i]>='a'&&cs[i]<='z')||(cs[i]>='A'&&cs[i]<='Z')){
                        list.add(String.valueOf(cs[i]));
                    }

                }
                //字符串忽略大小写排序
                Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

                for(int i=0,j=0;i<cs.length;i++){
                    if((cs[i]>='a'&&cs[i]<='z')||(cs[i]>='A'&&cs[i]<='Z')){
                        System.out.print(list.get(j));
                        j++;
                    }else{
                        System.out.print(cs[i]);
                    }
                }
                System.out.println();
            }

        }
    }
