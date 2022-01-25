package com.wenjie.leetcode.hot100.simple;

import java.util.Arrays;

/**
 * Description:  283. 移动零
 * Created on 2022/1/25 9:51
 * @author iswenjie.lu
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {1, 0};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void moveZeroes(int[] nums) {
        // 双指针
        int i = 0, j = 0;
        while (j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (i < j && j < nums.length) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
            j++;
        }
    }

    public void moveZeroes2(int[] nums) {
        // 改变索引值
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

}
