package com.wenjie.leetcode.offer.mid;

import com.wenjie.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * Description:  剑指 Offer 04. 二维数组中的查找
 * Created on 2022/1/5 10:21
 *
 * @author iswenjie.lu
 */
public class BuildTreeOffer {

    private Map<Integer, Integer> idxMap;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        idxMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdxInInorder = idxMap.get(root.val);
        // 左子节点数目
        int leftNum = rootIdxInInorder - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftNum, inStart, rootIdxInInorder - 1);
        root.right = buildTree(preorder, preStart + leftNum + 1, preEnd, rootIdxInInorder + 1, inEnd);
        return root;
    }
}
