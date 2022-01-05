package com.wenjie.leetcode.hot100.mid;

import java.util.ArrayDeque;
import java.util.Queue;

import com.wenjie.leetcode.hot100.common.TreeNode;

/**
 * Description:  114. 二叉树展开为链表
 * Created on 2021/12/31 10:49
 * @author iswenjie.lu
 */
public class Flatten {

    public static void main(String[] args) {
        new Flatten().flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6))));
    }

    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        preOrder(root, queue);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            curr.left = null;
            curr.right = queue.peek();
        }
    }

    private void preOrder(TreeNode node, Queue<TreeNode> queue) {
        if (node != null) {
            queue.add(node);
            preOrder(node.left, queue);
            preOrder(node.right, queue);
        }
    }

}
