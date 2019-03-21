package com.hauwei;


import java.util.Scanner;

public class LastWordLength {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] s = string.split(" ");
        String finalString = s[s.length-1];
        int finalStringLength = finalString.split("").length;
        System.out.println(finalStringLength);
    }

}
