package com.Second;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args){
        Array array = new Array();
        int[] nums = new int[]{1,2,3,3,4,5};

        array.removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));
    }
}
