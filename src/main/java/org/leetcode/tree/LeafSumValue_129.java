package org.leetcode.tree;

import org.leetcode.utils.TreeNode;

public class LeafSumValue_129 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(new LeafSumValue_129().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sum(root, 0);
//        return sum1(root, 0);
    }

    /**
     * 使用回溯方法
     *
     * @param root
     * @param sum
     * @return
     */
    private int sum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = sum(root.left, sum);
        int right = sum(root.right, sum);
        return left + right;
    }

    /**
     * 结果不对
     *
     * @param root
     * @param sum
     * @return
     */
    private int sum1(TreeNode root, int sum) {
        int current = 10 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int ans = 0;
        if (root.left != null) {
            ans += sum1(root.left, current);
        }
        if (root.right != null) {
            ans += sum1(root.right, current);
        }
        return ans;
    }
}
