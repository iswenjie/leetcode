package com.wenjie.leetcode.hot100.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:  448. 找到所有数组中消失的数字
 * Created on 2022/1/11 17:10
 * @author iswenjie.lu
 */
public class FindDisappearedNumbers {

    /**
     * x 位置上都加上 len,最后判断数字是否大于n
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            // num有可能加过len,必须求余，否则下标溢出
            int x = (num - 1) % nums.length;
            nums[x] += nums.length;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    /**
     * 模仿 剑指 Offer 03. 数组中重复的数字 效率不高
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            while (x != -1 && nums[x - 1] != -1) {
                int tmp = nums[x - 1];
                nums[x - 1] = -1;
                x = tmp;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

}
