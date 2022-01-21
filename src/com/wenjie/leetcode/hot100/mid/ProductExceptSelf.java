package com.wenjie.leetcode.hot100.mid;

import java.util.Arrays;

/**
 * Description:  238. 除自身以外数组的乘积
 *
 * Created on 2022/1/21 10:09
 * @author iswenjie.lu
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(arr)));
    }


    public int[] productExceptSelf(int[] nums) {
        // 核心逻辑 ans[i] = 左边的所有数的乘积 乘以 右边所有数的乘积
        int[] ans = new int[nums.length];
        // 先算左边，第0位没有左边 所以等于1
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        // 算右边
        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = r * ans[i];
            r = r * nums[i];
        }
        return ans;
    }

}
