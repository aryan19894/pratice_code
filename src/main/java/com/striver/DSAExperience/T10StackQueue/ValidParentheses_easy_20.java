package com.striver.DSAExperience.T10StackQueue;

import java.util.Stack;

public class ValidParentheses_easy_20 {
    static class Solution {
        // [Optimal] TC: O(n) or O(n), SC: O(n) - pushing each opening character to stack and
        // verify if there is closing bracket
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[')
                    stack.push(ch);
                else {
                    if (stack.isEmpty()) return false;
                    char pop = stack.pop();
                    if ((ch == ')' && pop == '(') || (ch == ']' && pop == '[') || (ch == '}' && pop == '{')) continue;
                    else return false;
                }

            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "[()[]{}";
        System.out.println(sol.isValid(s));
    }
}
