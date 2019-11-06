package com.springbootinit.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
 * 过程：
 * 比较相邻的两个数据，如果第二个数小，就交换位置。
 * 从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
 * 继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
 * <p>
 * 平均时间复杂度：O(n2)
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();

        // 为了检测时间，没什么用
        for (int h = 0; h < 300000; h++) {
            int temp;//临时变量
            for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共arr.length-1次。
                for (int j = arr.length - 1; j > i; j--) {

                    if (arr[j] < arr[j - 1]) {
                        temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /*
    优化：

    针对问题：
    数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，后面的比较没有意义的。

    方案：
    设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
    这样当一轮比较结束后如果flag仍为false，即：*这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去*。
     */
    private static void bubbleSort1(int[] arr) {
        long start = System.currentTimeMillis();

        // 为了检测时间，没什么用
        for (int h = 0; h < 300000; h++) {
            int temp;//临时变量
            boolean flag;//是否交换的标志
            for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共arr.length-1次。

                flag = false;
                for (int j = arr.length - 1; j > i; j--) {

                    if (arr[j] < arr[j - 1]) {
                        temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                        flag = true;
                    }
                }
                if (!flag) break;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 6, 5, 9};
        System.out.println(Arrays.toString(arr));
        bubbleSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
