package com.wenjie.leetcode.hot100.common;

/**
 * Description:  TreeNode
 * Created on 2021/12/29 16:22
 * @author iswenjie.lu
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
