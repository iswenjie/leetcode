package com.wenjie.leetcode.sort;

/**
 * Description:  归并排序
 * Created on 2022/1/7 16:40
 * @author iswenjie.lu
 */
public class MergeSort implements Sort {

    int[] tmp;

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        Sort sort = new MergeSort();
        int[] ans = sort.sortArray(arr);
        System.out.println(ans[0]);
    }

    @Override
    public int[] sortArray(int[] sourceArray) {
        if (sourceArray.length < 2) {
            return sourceArray;
        }
        tmp = new int[sourceArray.length];
        mergeSort(sourceArray, 0, sourceArray.length - 1);
        return sourceArray;
    }

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

    private int[] merge(int[] left, int[] right) {
        int[] ans = new int[left.length + right.length];
        int i = 0, j = 0;
        while (i + j <= ans.length - 1) {
            if (i == left.length) {
                ans[i + j] = right[j];
                j++;
                continue;
            } else if (j == right.length) {
                ans[i + j] = left[i];
                i++;
                continue;
            }
            if (left[i] > right[j]) {
                ans[i + j] = right[j];
                j++;
            } else {
                ans[i + j] = left[i];
                i++;
            }
        }
        return ans;
    }

}
