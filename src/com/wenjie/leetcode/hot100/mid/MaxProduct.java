package com.wenjie.leetcode.hot100.mid;

/**
 * Description:  152. 乘积最大子数组
 * tag: 动态规划、数组
 * Created on 2022/1/8 15:11
 * @author iswenjie.lu
 */
public class MaxProduct {


    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new MaxProduct().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int[] maxProduct = new int[nums.length];
        maxProduct[0] = nums[0];
        int[] minProduct = new int[nums.length];
        minProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxProduct[i] = Math.max(nums[i], maxProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(nums[i], minProduct[i - 1] * nums[i]);
            } else if ((nums[i] < 0)) {
                maxProduct[i] = Math.max(nums[i], minProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(nums[i], maxProduct[i - 1] * nums[i]);
            } else {
                maxProduct[i] = 0;
                minProduct[i] = 0;
            }
        }
        int max = maxProduct[0];
        for (int i : maxProduct) {
            max = Math.max(max, i);
        }
        return max;

    }

}
