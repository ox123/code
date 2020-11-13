package org.others.tree;

public class LowestAncestor {
    public Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || o1 == null || o2 == null) {
            return head;
        }
        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left == null ? left : right;
    }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
