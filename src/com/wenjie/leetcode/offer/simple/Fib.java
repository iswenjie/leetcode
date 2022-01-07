package com.wenjie.leetcode.offer.simple;

/**
 * Description:  剑指 Offer 10- I. 斐波那契数列
 * Created on 2022/1/6 17:26
 * @author iswenjie.lu
 */
public class Fib {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int mod = 1000000007;
        int prePre = 0, pre = 1, ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (pre + prePre) % mod;
            prePre = pre;
            pre = ans;
        }
        return ans;
    }

}
