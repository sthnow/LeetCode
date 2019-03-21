package com.hauwei;

import java.util.Scanner;

public class StringCut {
    public static void main(String[] args) {
//        System.out.println("需要输入的字符串个数：");
//        Scanner sc = new Scanner(System.in);
//        int count = sc.nextInt();
//        System.out.println("请输入字符串");
//        while (sc.hasNext()) {
//
//            String s1 = sc.nextLine();
//
//            //第一行
//            int flag1 = 0;
//            for(int i=0 ;i<s1.length() ;i++){
//                if(flag1!=7){
//                    System.out.print(s1.charAt(i));
//                    flag1++;
//                }else{//flag1==7  输出的字符已经有8个
//                    System.out.println(s1.charAt(i));
//                    flag1 = 0;//更新flag1
//                }
//            }
//
//            //跳出循环后，如果flag1==0那么说明原来字符的个数是8的倍数
//            //跳出循环后，如果flag1！=0那么说明需要补0
//            if(flag1!=0){
//                for(int i=0 ;i<8-flag1 ;i++){
//                    System.out.print("0");
//                }
//                System.out.println();
//            }
//
//            if(count == 0)
//                return;
//            count--;


//            System.out.println("需要输入的字符串个数：");
            Scanner sc = new Scanner(System.in);
            int count = sc.nextInt();
//            System.out.println("请输入字符串:");
            while (sc.hasNext()) {
                String s = sc.next();

                int flag7 = 0;

                for (int i = 0; i < s.length(); i++) {
                    if (flag7 != 7) {
                        System.out.print(s.charAt(i));
                        flag7 = flag7 + 1;
                    } else {
                        System.out.println(s.charAt(i));
                        flag7 = 0;
                    }
                }

                if (flag7 != 0) {
                    for (int i = 0; i < 8 - flag7; i++)
                        System.out.print("0");
                    System.out.println();
                }
                if (count == 0)
                    return;
                count--;
            }

        }
    }


