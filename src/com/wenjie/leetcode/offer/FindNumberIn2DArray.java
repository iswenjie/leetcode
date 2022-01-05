package com.wenjie.leetcode.offer;

/**
 * Description:  剑指 Offer 04. 二维数组中的查找
 * Created on 2022/1/5 10:21
 * @author iswenjie.lu
 */
public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(matrix, 20));
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int columns = 0;
        while (rows >= 0 && columns <= matrix[0].length - 1) {
            if (matrix[rows][columns] == target) {
                return true;
            } else if (matrix[rows][columns] >= target) {
                rows--;
            } else {
                columns++;
            }
        }
        return false;
    }

}
