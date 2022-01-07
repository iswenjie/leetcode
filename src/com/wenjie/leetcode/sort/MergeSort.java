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
        // 对 arr 进行拷贝，不改变参数内容
        if (sourceArray.length < 2) {
            return sourceArray;
        }
        tmp = new int[sourceArray.length];
        merge(sourceArray, 0, sourceArray.length - 1);
        return sourceArray;
    }

    private void merge(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        merge(nums,  l, mid);
        merge(nums,  mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
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
