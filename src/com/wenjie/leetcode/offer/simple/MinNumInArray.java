package com.wenjie.leetcode.offer.simple;

/**
 * Description:  剑指 Offer 11. 旋转数组的最小数字
 * tag: 二分查找
 * Created on 2022/1/9 17:54
 *
 * @author iswenjie.lu
 */
public class MinNumInArray {

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int min = left;
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                min = right;
                break;
            }
            min = (left + right) >> 1;
            if (numbers[left] == numbers[right] && numbers[right] == numbers[min]){
                // 三个相等时无法判断怎么移动只能暴力
                return searchMin(numbers);
            }
            if (numbers[min] >= numbers[left]) {
                left = min;
            } else {
                right = min;
            }
        }
        return numbers[min];
    }

    private int searchMin(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            min = Math.min(numbers[i], min);
        }
        return min;
    }

}
