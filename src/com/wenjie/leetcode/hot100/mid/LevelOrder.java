package com.wenjie.leetcode.hot100.mid;

import com.wenjie.leetcode.hot100.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:  102. 二叉树的层序遍历
 * TAG: 二叉树
 * Created on 2022年1月5日 22点32分
 *
 * @author iswenjie.lu
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 最后的结果
        List<List<Integer>> ans = new ArrayList<>();
        // 每一层的值
        List<Integer> levelVal = new ArrayList<>();
        levelVal.add(root.val);
        // 每一层的节点
        // 这list频繁进出，可以用queue更方便（offer/poll）
        List<TreeNode> levelNode = new ArrayList<>();
        levelNode.add(root);
        do {
            ans.add(new ArrayList<>(levelVal));
            levelVal = new ArrayList<>();
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : levelNode) {
                if (node.left != null) {
                    tmp.add(node.left);
                    levelVal.add(node.left.val);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                    levelVal.add(node.right.val);
                }
            }
            // 赋值
            levelNode.clear();
            levelNode.addAll(tmp);
        } while (!levelNode.isEmpty());
        return ans;
    }


}
