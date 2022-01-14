package com.wenjie.leetcode.hot100.mid;

/**
 * Description:  221. 最大正方形
 * tag: dp 动态规划
 * Created on 2022/1/13 10:13
 * @author iswenjie.lu
 */
public class MaximalSquare {

    int rows;
    int columns;

    public static void main(String[] args) {
        char[][] matrix = {{'1'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }


    public int maximalSquareDp(char[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        int maxSide = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    /**
     * 暴力+剪枝法 52ms
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;
        int ans = 0;
        int maxSide = 0;
        for (int i = 0; i < rows - maxSide; i++) {
            for (int j = 0; j < columns - maxSide; j++) {
                if (matrix[i][j] == '1') {
                    ans = Math.max(maximalSquare(matrix, i, j), ans);
                    maxSide = (int) Math.sqrt(ans);
                }
            }
        }
        return ans;
    }

    public int maximalSquare(char[][] matrix, int m, int n) {
        int l = 0, w = rows - m;
        int pl = n;
        while (pl <= columns - 1) {
            if (matrix[m][pl++] != '1') {
                break;
            }
            l++;
        }
        if (l > 0) {
            for (int i = 0; i < l; i++) {
                int vw = 0, pm = m;
                while (pm <= rows - 1 && vw < l) {
                    if (matrix[pm++][n + i] != '1') {
                        break;
                    }
                    vw++;
                }
                w = Math.min(w, vw);
                l = w;
            }
        }
        return l * w;
    }

}
