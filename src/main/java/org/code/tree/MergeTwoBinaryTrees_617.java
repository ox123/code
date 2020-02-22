package org.code.tree;

import org.code.linklist.ListNode;
import org.code.utils.Utils;
import org.code.utils.NodeUtils;
import org.code.utils.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/submissions/
 */
public class MergeTwoBinaryTrees_617 {
    public static void main(String[] args) {
        int[] array = Utils.getArray(5);

        ListNode listNode = NodeUtils.generateNodeList(array);
        ListNode listNode1 = NodeUtils.generateNodeList(Utils.getArray(5));
//        NodeUtils.printNodeWithOneLine(new MergeTwoBinaryTrees_617().mergeTrees(listNode, listNode1));

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = t1;
        if (t1 == null) return t2;
        else if (t2 != null) {
            root.val = t1.val + t2.val;
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }
}
