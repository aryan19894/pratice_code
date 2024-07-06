package pratice.book.karumanchi.chapter2.backtracking.leetcode;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_medium_22 {
    static class Solution {
//        public List<String> generateParenthesis(int n) {
//            if (n == 1) {
//                List<String> output = new ArrayList<>();
//                output.add("()");
//                return output;
//            }
//            List<String> result = new ArrayList<>();
//            generate(n, n, "", result);
//            return result;
//        }
//
//        private void generate(int left, int right, String curr, List<String> result) {
//            if (left == 0 && right == 0) {
//                result.add(curr);
//                return;
//            }
//
//            if (left > 0)
//                generate(left - 1, right, curr + "(", result);
//            if (right > left)
//                generate(left, right - 1, curr + ")", result);
//        }

//        public List<String> generateParenthesis(int n) {
//            if (n == 1) {
//                List<String> output = new ArrayList<>();
//                output.add("()");
//                return output;
//            }
//
//            List<String> subList = generateParenthesis(n - 1);
//            Set<String> result = new HashSet<>();
//            for (String sub : subList) {
//                for (int i = 1; i <= sub.length(); i++)
//                    result.add(sub.substring(0, i) + "()" + sub.substring(i));
//            }
//            return new ArrayList<>(result);
//        }

        public List<String> generateParenthesis(int n) {
            List<String> output = new ArrayList<>();
            if (n == 0) return output;
            if (n == 1) {
                output.add("()");
                return output;
            }
            List<String> result = new ArrayList<>();
            generate(0, 0, n, "", result);
            return result;
        }

        private void generate(int open, int close, int n, String curr, List<String> result) {
            if (open == n && close == n) {
                result.add(curr);
                return;
            }

            if (open < n)
                generate(open + 1, close, n, curr + "(", result);

            if (close < open)
                generate(open, close + 1, n, curr + ")", result);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3;
        Out.print(sol.generateParenthesis(n));
    }
}
