package org.code.tree;

import org.code.linklist.ListNode;
import org.code.utils.Utils;
import org.code.utils.NodeUtils;
import org.code.utils.TreeNode;

import java.util.LinkedList;

/**
 * 反转二叉树
 */
public class ReverseBinaryTree {
    public static void main(String[] args) {
        int[] array = Utils.getArray(5);
        ListNode listNode = NodeUtils.generateNodeList(array);
        NodeUtils.printNodeWithOneLine(listNode);

    }

    public TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = reverseTree(root.right);
        root.right = reverseTree(temp);
        return root;
    }

    /**
     * BFS 遍历
     * @param root
     * @return
     */
    public TreeNode reverseTree1(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            root.left = root.right;
            root.right = temp;
            while (current.left != null) {
                queue.add(current.left);
            }
            while (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }

}
