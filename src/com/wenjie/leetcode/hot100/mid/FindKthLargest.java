package com.wenjie.leetcode.hot100.mid;

/**
 * Description:  215. 数组中的第K个最大元素
 * tag: 排序
 * Created on 2022/1/12 10:09
 *
 * @author iswenjie.lu
 */
public class FindKthLargest {


    public static void main(String[] args) {
        FindKthLargest v = new FindKthLargest();

        int[] arr = {3, 2, 1, 5, 6, 4};
        v.findKthLargest(arr, 2);
    }

    public int findKthLargest(int[] nums, int k) {
        quickSortBest(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[l];
        int i = l - 1, j = r + 1, g = nums[(l + r) >> 1];
        while (i < j) {
            while (nums[--j] < g) ;
            while (nums[++i] > g) ;
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        int count = j - l + 1;
        if (k <= count) return quickSelect(nums, l, j, k);
        return quickSelect(nums, j + 1, r, k - count);
    }

    /**
     * 快速部分排序 只排K在的那一部分
     * @param nums
     * @param start
     * @param end
     */
    private void quickSortBest(int[] nums, int start, int end, int k) {
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
        int rightSize = end - left + 1;
        if (rightSize >= k) {
            quickSortBest(nums, left, end, k);
        } else {
            quickSortBest(nums, start, right, k - rightSize);
        }
    }


    /**
     * 归并排序
     *
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
     *
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
    }


}
