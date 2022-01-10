package com.wenjie.leetcode.hot100.mid;

/**
 * Description:  200. 岛屿数量
 * Created on 2022/1/10 10:55
 * @author iswenjie.lu
 */
public class NumIslands {


    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int ans = new NumIslands().numIslands(grid);
        System.out.println(ans);

    }

    /**
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] landArr = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !landArr[i][j]) {
                    tag(landArr, grid, i, j, 0);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void tag(boolean[][] landArr, char[][] grid, int row, int column, int form) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length
            || grid[row][column] == '0' || landArr[row][column]) {
            return;
        }
        landArr[row][column] = true;
        if (form != 2) {
            tag(landArr, grid, row + 1, column, 1);
        }
        if (form != 1) {
            tag(landArr, grid, row - 1, column, 2);
        }
        if (form != 4) {
            tag(landArr, grid, row, column + 1, 3);
        }
        if (form != 3) {
            tag(landArr, grid, row, column - 1, 4);
        }
    }

}
