package org.leetcode.stackqueue;

import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        String s = "(";
        System.out.println(new ValidParentheses_20().isValid(s));
    }

    public boolean isValid(String s) {
        int lenth = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < lenth; i++) {
            char c = s.charAt(i);
            if (c == '{') {
              stack.push('{');
            } else if (c == '(') {
                stack.push('(');
            } else if (c == '[') {
                stack.push('[');
            } else if (c == '}') {
               if (stack.isEmpty() || stack.peek() != '{'){
                   return  false;
               }else{
                   stack.pop();
               }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '('){
                    return  false;
                }else{
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '['){
                    return  false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 对上面程序进行优化
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> expected = new Stack<>();

        for (char c : s.toCharArray()) {
            Character e = null;

            switch(c) {
                case '(':
                    e = ')';
                    break;
                case '{':
                    e = '}';
                    break;
                case '[':
                    e = ']';
                    break;
            }
            if (e != null) {
                expected.push(e);
            } else if(expected.size() == 0 || expected.pop() != c) {
                return false;
            }
        }

        return expected.size() == 0;
    }

    /**
     * "([)]"  对这种场景时wrong
     *
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        int a = 0, b = 0, m = 0;
        int lenth = s.length();
        for (int i = 0; i < lenth; i++) {
            char c = s.charAt(i);
            if (c == '{') {
                a++;
            } else if (c == '(') {
                b++;
            } else if (c == '[') {
                m++;
            } else if (c == '}') {
                a--;
            } else if (c == ')') {
                b--;
            } else if (c == ']') {
                m--;
            }
        }
        return a == 0 && b == 0 && m == 0;
    }
}
