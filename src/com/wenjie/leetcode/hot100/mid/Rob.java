package com.wenjie.leetcode.hot100.mid;

/**
 * Description:  198. 打家劫舍
 * Created on 2022/1/8 16:42
 * @author iswenjie.lu
 */
public class Rob {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        new Rob().rob(nums);
    }


    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int pre = nums[0];
        int max = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(max, pre + nums[i]);
            pre = tmp;
        }
        return max;
    }

}
