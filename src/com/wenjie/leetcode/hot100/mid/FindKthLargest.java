package com.wenjie.leetcode.hot100.mid;

import java.util.Arrays;

/**
 * Description:  215. 数组中的第K个最大元素
 * tag: 排序
 * Created on 2022/1/12 10:09
 * @author iswenjie.lu
 */
public class FindKthLargest {


    public static void main(String[] args) {
        FindKthLargest v = new FindKthLargest();

        int[] arr = {4, 3, 2, 7, 8, 3, 2, 1};
        v.findKthLargest(arr, 2);
    }

    public int findKthLargest(int[] nums, int k) {
        mergeSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    /**
     * 快速选择
     * 在快熟排序中判断第k大在哪个区间，丢弃另外一半区间继续往下（k可能需要截取）
     * TODO
     * @param nums
     * @param start
     * @param end
     */
    private int quickSelect(int[] nums, int start, int end, int k) {
        return 0;
    }


    /**
     * 归并排序
     * @param nums
     * @param start
     * @param end
     */
    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        // 临时数组
        int[] tmp = new int[end - start + 1];
        int k = 0;
        // 将两个数组合并，结果保存到临时数组
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            tmp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }
        // 排序后的数组复制到原数组
        k = 0;
        while (k < tmp.length) {
            nums[start + k] = tmp[k++];
        }
    }

    /**
     * 快速排序
     * @param nums
     * @param start
     * @param end
     */
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        int val = nums[start];
        while (left <= right) {
            while (left <= right && nums[left] < val) {
                left++;
            }
            while (left <= right && nums[right] > val) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
        System.out.println(Arrays.toString(nums));
    }


}
