package com.secondleetcod;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args){
        Array array = new Array();
        int[] nums = new int[]{1,2};

//        array.removeDuplicates(nums);
          array.rotate_v2(nums,5);
        System.out.println(Arrays.toString(nums));
    }
}
