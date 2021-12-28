package com.wenjie.leetcode.hot100.mid;

/**
 * Description:  79. 单词搜索
 * Tag: 回溯
 * Created on 2021/12/28 9:57
 * @author iswenjie.lu
 */
public class WordExist {


    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] used = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                boolean flag = check(board, used, i, j, word.toCharArray(), 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 回溯检查
     * @param board 原始字母棋盘
     * @param visited 保存已经使用过的格子
     * @param i 行
     * @param j 列
     * @param s word的char数组
     * @param k 当前检查的s的下表
     * @return 当前字符是否满足
     */
    public boolean check(char[][] board, boolean[][] visited, int i, int j, char[] s, int k) {
        if (board[i][j] != s[k]) {
            return false;
        } else if (k == s.length - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

}
