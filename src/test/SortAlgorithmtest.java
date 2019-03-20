package test;


import algorithm.sort.SortAlgorithm;

import java.util.Arrays;

public class SortAlgorithmtest {

    public static void main(String[] args) {
        SortAlgorithm sort = new SortAlgorithm();
        int[] unSort = new int[]{5,4,1,3,2};

        //冒泡排序
//        System.out.println("冒泡排序结果"+ Arrays.toString(sort.bubbleSort(unSort)));
//        System.out.println("=================================");
//        System.out.println("选择排序结果"+ Arrays.toString(sort.selectSort(unSort)));
//        System.out.println("=================================");
//        System.out.println("插入排序结果"+ Arrays.toString(sort.insertSort(unSort)));
//        System.out.println("=================================");
//        System.out.println("快速排序结果"+ Arrays.toString());
//        sort.quickSortMid(unSort,0,5);
//        sort.quickSortLeft(unSort,0,5);
//        sort.selectSort_v1(unSort);
//        sort.insertSort_v1(unSort);
        sort.quickSort_v1(unSort,0,4);
        System.out.println(Arrays.toString(unSort));

    }
}
