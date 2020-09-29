package org.leetcode.stackqueue;

/**
 * TODO
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
 */
public class IsValidSerialization_331 {
    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(new IsValidSerialization_331().isValidSerialization(s));
    }

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node :
                nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}
