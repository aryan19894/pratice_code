package pratice.leetcode.blind75.T8String;

import pratice.common.Out;

import java.util.Stack;

public class ValidParentheses_easy_20 {
    static class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() % 2 != 0) return false;

            Stack<Character> st = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (isOpen(ch))
                    st.push(ch);
                else {
                    if (st.isEmpty()) return false;
                    char pop = st.pop();
                    if (isClose(ch, pop)) continue;
                    else return false;
                }
            }
            return st.isEmpty();
        }

        private boolean isClose(char ch, char pop) {
            switch (pop) {
                case '(':
                    return ch == ')';
                case '{':
                    return ch == '}';
                case '[':
                    return ch == ']';
            }
            return false;
        }

        private boolean isOpen(char ch) {
            return ch == '(' || ch == '{' || ch == '[';
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "()[]{}";
        Out.print(sol.isValid(s));
    }
}
