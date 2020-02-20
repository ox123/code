package org.code.tree;

import org.code.utils.TreeNode;

import java.util.ArrayList;

/**
 * TODO 待完成
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 详细讲解：https://blog.csdn.net/zangdaiyang1991/article/details/90177273
 */
public class IsValidBST_97 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;
        System.out.println(new IsValidBST_97().isValidBST(root));
    }

    public ArrayList<Integer> result = new ArrayList();


    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        inOrder(root);
//        for (int i = 0; i < result.size() - 1; i++) {
//            if (result.get(i) >= result.get(i + 1)) {
//                return false;
//            }
//        },
//        return true;
        return new IsValidBST_97().isValidBST(root, null, null);
    }

    /**
     * 中序遍历 数组 o(n)复杂度，栈深度问题，导致效率较低。
     *
     * @param root
     * @return
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 39.1 MB, less than 81.40% of Java online submissions for Validate Binary Search Tree
     * 只是使用递归，速度高效
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        if (!isValidBST(root.left, min, root)) return false;
        if (!isValidBST(root.right, root, max)) return false;
//        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        return true;
    }

}
