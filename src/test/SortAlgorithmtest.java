package test;


import algorithm.sort.SortAlgorithm;

import java.util.Arrays;

public class SortAlgorithmtest {

    public static void main(String[] args) {
        SortAlgorithm sort = new SortAlgorithm();
        int[] unSort = new int[]{2,1,5,3,6,3,5,3,7,3,8,9,7,4};

        //冒泡排序
//        System.out.println("冒泡排序结果"+ Arrays.toString(sort.bubbleSort(unSort)));
//        System.out.println("=================================");
//        System.out.println("选择排序结果"+ Arrays.toString(sort.selectSort(unSort)));
//        System.out.println("=================================");
//        System.out.println("插入排序结果"+ Arrays.toString(sort.insertSort(unSort)));
//        System.out.println("=================================");
//        System.out.println("快速排序结果"+ Arrays.toString());
        sort.quickSort(unSort,0,13);
        System.out.println(Arrays.toString(unSort));
    }
}
