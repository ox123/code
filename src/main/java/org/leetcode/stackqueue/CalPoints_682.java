package org.leetcode.stackqueue;

import java.util.Stack;

public class CalPoints_682 {
    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(new CalPoints_682().calPoints(ops));
//        System.out.println(new CalPoints_682().test(ops));
    }

    private int test(String[] ops){
        Stack<Integer> s = new Stack<>();
        int total = 0, temp;
        for(String op : ops) {           //  for each loop for string array
            if(op.equals("C")) {
                total -= s.pop();
            }
            else if(op.equals("D")) {
                temp = 2*s.peek();
                s.push(temp);
                total += temp;
            }
            else if(op.equals("+")) {
                temp = s.pop();
                int sum = temp + s.peek();
                s.push(temp);
                s.push(sum);
                total += sum;
            }
            else {
                temp = Integer.parseInt(op);
                s.push(temp);
                total += temp;
            }
        }
        return total;
    }

    public int calPoints(String[] ops) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (String str :
                ops) {
            if ("+".equals(str)) {
                int a = stack.pop(), b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            } else if ("C".equals(str)) stack.pop();
            else if ("D".equals(str)) stack.push(stack.peek() * 2);
            else stack.push(Integer.parseInt(str));
        }
        for (Integer in :
                stack) {
            ans += in;
        }
        return ans;
    }
}
