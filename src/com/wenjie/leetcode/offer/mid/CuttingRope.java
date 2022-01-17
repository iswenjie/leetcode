package com.wenjie.leetcode.offer.mid;

/**
 * Description:  剑指 Offer 14- I. 剪绳子
 * tag：动态规划dp、贪心
 * Created on 2022/1/17 13:46
 * @author iswenjie.lu
 */
public class CuttingRope {

    public static void main(String[] args) {
        System.out.println(new CuttingRope().cuttingRope(1));
    }


    public int cuttingRope(int n) {
        // 将绳子 以相等的长度等分为多段 ，得到的乘积最大。
        // 尽可能将绳子以长度 3 等分为多段时，乘积最大。
        if (n <= 3) {
            return Math.max(n - 1, 1);
        }
        int a = n / 3, b = n % 3;
        if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        }
        if (b == 2) {
            return (int) (Math.pow(3, a) * 2);
        }
        return (int) (Math.pow(3, a));
    }

    public int cuttingRopeDp(int n) {
        // f(0)=1,f(1)=1,f(2)=1*1,f(3)=2
        if (n <= 3) {
            return Math.max(n - 1, 1);
        }
        // dp思路：砍成两段的最大乘积是 f(n) = f(x)*f(n-x)
        // f(2)虽然=1，在计算的时候的等于2，比如4=2*2=4,不能是1*1
        // f(3)虽然=2，在计算的时候的等于3，比如6=3*3=9,不能是2*2
        // 也就是说在dp计算的时候,f(x)的最小值只能是x,不能小于x
        // 在x>=4的时候计算出来都是大于x,所以不需要特殊定义
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int ans = 1;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                ans = Math.max(ans, f[j] * f[i - j]);
            }
            f[i] = ans;
            ans = 0;
        }
        return f[n];
    }

}
