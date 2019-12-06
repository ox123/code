package org.code.tree;

import java.util.Stack;

public class PrintTrees {

    public void printTreeVertical(Node node) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);

    }

    public void trace(Stack<Node> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Node current = stack.peek();
        if (current.left == null && current.middle == null && current.right == null) {
            StringBuilder sb = new StringBuilder(100);
            for (Node item :
                    stack) {
                sb.append(item.value).append(",");
                stack.pop();
                return;
            }
        }
        if (current.left != null) {
            stack.push(current.left);
            trace(stack);
        }
        if (current.middle != null) {
            stack.push(current.middle);
            trace(stack);
        }
        if (current.right != null) {
            stack.push(current.right);
            trace(stack);
        }
    }
}
