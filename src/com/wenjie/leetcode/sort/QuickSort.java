package com.wenjie.leetcode.sort;

/**
 * Description:  快速排序
 * Created on 2022/1/12 10:36
 * @author iswenjie.lu
 */
public class QuickSort implements Sort {


    public static void main(String[] args) {
        Sort v = new QuickSort();

        int[] arr = {1,4, 3, 2, 7, 8, 3, 2};
        v.sortArray(arr);
    }

    @Override
    public int[] sortArray(int[] sourceArray) {
        quickSort(sourceArray, 0, sourceArray.length - 1);
        return sourceArray;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        // 获取一个值用来比较，有随机的，这里简单直接使用中间坐标
        int pivot = nums[start];
        while (left <= right) {
            // 找到左边比pivot大的数
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            // 找到右边比pivot小的数
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            // 把比pivot大的放到右边，把比pivot小的放到左边
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        // 继续排序左右两边(上面循环结束后，right已经小于left了)
        // 这样循环结束后下标[start,right]里面所有元素均小于[right,end]里面的元素
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
