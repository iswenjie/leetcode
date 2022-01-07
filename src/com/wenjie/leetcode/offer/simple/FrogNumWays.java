package com.wenjie.leetcode.offer.simple;

/**
 * Description:  剑指 Offer 10- II. 青蛙跳台阶问题
 * tag: dp
 * Created on 2022/1/6 17:54
 * @author iswenjie.lu
 */
public class FrogNumWays {

    public int numWays(int n) {
        if (n < 3) {
            return Math.max(1, n);
        }
        int result = 3;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            result = (pre + prePre) % 1000000007;
            prePre = pre;
            pre = result;
        }
        return result;
    }

}
