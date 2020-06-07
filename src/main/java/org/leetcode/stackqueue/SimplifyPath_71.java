package org.leetcode.stackqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath_71 {
    public static void main(String[] args) {
        String input = "/../";
        System.out.println(new SimplifyPath_71().simplifyPath(input));
        System.out.println(Arrays.toString("////..//..///".split("/")));
    }

    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        String result = "";
        System.out.println(Arrays.toString(arr));
        for (String c :
                arr) {
            if (".".equals(c)) {
                continue;
            } else if ("..".equals(c)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!"".equals(c)) {
                stack.push(c);
            }
        }
        for (String dir :
                stack) {
            result += ("/" + dir);

        }
        return "".equals(result) ? "/" : result;
    }
}
