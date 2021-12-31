package com.wenjie.leetcode.hot100.mid;

import java.util.HashMap;
import java.util.Map;

import com.wenjie.leetcode.hot100.common.TreeNode;

/**
 * Description:  105. 从前序与中序遍历序列构造二叉树
 * Tag: 二叉树
 * Created on 2021/12/30 10:16
 * @author iswenjie.lu
 */
public class BuildTree {

    /**
     * 存储
     */
    private Map<Integer, Integer> indexMap;

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = new BuildTree().buildTree(preorder, inorder);
        System.out.println(root.val);
    }

    /**
     * 前序遍历：根结点 ---> 左子树 ---> 右子树
     *
     * 中序遍历：左子树---> 根结点 ---> 右子树
     * @param preorder 前序
     * @param inorder 中序
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right || inorder_left > inorder_right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorder_left]);
        int rootIdx = indexMap.get(root.val);
        // 得到左子树中的节点数目
        int size_left_subtree = rootIdx - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, rootIdx - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, rootIdx + 1, inorder_right);


        return root;
    }

}
