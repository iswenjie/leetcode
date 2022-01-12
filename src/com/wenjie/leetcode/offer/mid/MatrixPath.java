package com.wenjie.leetcode.offer.mid;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * Description:  剑指 Offer 04. 二维数组中的查找
 * Created on 2022/1/12 22:52
 *
 * @author iswenjie.lu
 */
public class MatrixPath {


    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}};
        System.out.println(new MatrixPath().exist(board, "ab"));
    }

    int rows;
    int columns;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (hasPath(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[][] board, boolean[][] visited, String word, int m, int n, int k) {
        boolean ans = false;
        if (!visited[m][n] && board[m][n] == word.charAt(k)) {
            visited[m][n] = true;
            ans = (k == word.length() - 1) ||
                    (m > 0 && hasPath(board, visited, word, m - 1, n, k + 1))
                    || (n > 0 && hasPath(board, visited, word, m, n - 1, k + 1))
                    || (m < rows - 1 && hasPath(board, visited, word, m + 1, n, k + 1))
                    || (n < columns - 1 && hasPath(board, visited, word, m, n + 1, k + 1));
            visited[m][n] = ans;
        }
        return ans;
    }

}
