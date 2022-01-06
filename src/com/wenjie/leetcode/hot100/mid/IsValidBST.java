package com.wenjie.leetcode.hot100.mid;

import com.wenjie.leetcode.common.TreeNode;

/**
 * Description:  98. 验证二叉搜索树
 * TAG: 递归
 * Created on 2021/12/29 16:21
 * @author iswenjie.lu
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

}
