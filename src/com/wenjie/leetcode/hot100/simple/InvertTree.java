package com.wenjie.leetcode.hot100.simple;

import com.wenjie.leetcode.common.TreeNode;

/**
 * Description:  226. 翻转二叉树
 * Created on 2022/1/14 11:08
 * @author iswenjie.lu
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = tmp;
        }
        return root;
    }

}
