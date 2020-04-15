package org.leetcode.utils;

public class TreeNodeUtils {
    /**
     * 中序遍历
     * @param treeNode
     */
    public static void printInOrder(TreeNode treeNode) {
        printInOrder(treeNode.left);
        System.out.println(treeNode.val);
        printInOrder(treeNode.right);
    }

    /**
     * 前序遍历
     * @param treeNode
     */
    public static void printPreOrder(TreeNode treeNode) {
        System.out.println(treeNode.val);
        printPreOrder(treeNode.left);
        printPreOrder(treeNode.right);
    }

    /**
     * 后序遍历
     * @param treeNode
     */
    public static void printPostOrder(TreeNode treeNode) {
        printPostOrder(treeNode.left);
        printPostOrder(treeNode.right);
        System.out.println(treeNode.val);
    }

    public static TreeNode generate(){
        return null;
    }
}
