package com.gfg.companywise.amazon;

import com.common.Out;

import java.util.Stack;

public class SpecialStack {
    static public class Solution {
        int min = 0;

        public void push(int a, Stack<Integer> s) {
            if (isEmpty(s)) {
                min = a;
                s.push(a);
            } else if (a < min) {
                min = a;
                s.push(2 * a - min);
            } else s.push(a);
        }

        public int pop(Stack<Integer> s) {
            int top = s.peek();
            if (top < min)
                min = 2 * min - top;
            return s.pop();
        }

        public int min(Stack<Integer> s) {
            return min;
        }

        public boolean isFull(Stack<Integer> s, int n) {
            return s.size() == n;
        }

        public boolean isEmpty(Stack<Integer> s) {
            return s.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int a = 0;
        Stack<Integer> s = new Stack<>();
        sol.push(18, s);
        sol.push(19, s);
        sol.push(29, s);
        sol.push(15, s);
        sol.push(16, s);
        Out.print(sol.min(s));
    }
}
