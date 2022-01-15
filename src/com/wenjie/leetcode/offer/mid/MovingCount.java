package com.wenjie.leetcode.offer.mid;


/**
 * Description:  剑指 Offer 13. 机器人的运动范围
 * tag: 回溯
 * Created on 2022/1/15 14:11
 * @author iswenjie.lu
 */
public class MovingCount {


    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(1, 2, 1));
    }


    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return backTrack(visited, m, n, k, 0, 0);

    }

    private int backTrack(boolean[][] visited, int m, int n, int k, int i, int j) {
        if (accept(visited, m, n, k, i, j)) {
            visited[i][j] = true;
            return 1 + backTrack(visited, m, n, k, i + 1, j)
                + backTrack(visited, m, n, k, i - 1, j)
                + backTrack(visited, m, n, k, i, j + 1)
                + backTrack(visited, m, n, k, i, j - 1);
        }
        return 0;
    }

    private boolean accept(boolean[][] visited, int m, int n, int k, int i, int j) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || visited[i][j]) {
            return false;
        }
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
        }
        return k >= sum;
    }

}
