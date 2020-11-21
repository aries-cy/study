package com.cy.study.leetcode.sort;

/**
 * 排序
 *
 * @author cy
 */
public class SortDemo {


    public static void main(String[] args) {
        int[] arr = {5,8,7,1,2,3};
        int[] ints = selectSort(arr);
        System.out.println("....");

    }

    /**
     * 冒泡排序
     * @param arr
     */
    private static int[] bubbleSort(int[] arr) {
        if(arr==null || arr.length < 2 ){
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * @param numbs
     * @return
     */
    private static int[] selectSort(int[] numbs) {
        for (int i = 0; i < numbs.length; i++) {
            // 将当前下标定义为最小值下标
            int minIndex = i;
            for (int j = i+1; j <numbs.length; j++) {
                if (numbs[minIndex] > numbs[j]) {
                    minIndex = j;
                }
            }
            //如果不是同一个，就交换
            if (i != minIndex) {
                int temp = numbs[i];
                numbs[i] = numbs[minIndex];
                numbs[minIndex] = temp;
            }
        }
        return numbs;
    }



}
