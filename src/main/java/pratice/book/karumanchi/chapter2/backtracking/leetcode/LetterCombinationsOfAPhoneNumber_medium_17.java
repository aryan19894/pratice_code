package pratice.book.karumanchi.chapter2.backtracking.leetcode;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_medium_17 {
    static class Solution {
        private static final String[][] KEYS = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
                {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

        private static List<String> getString(char ch) {
            return Arrays.asList(KEYS[(ch - '0')]);
        }

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return new ArrayList<>();
            if (digits.length() == 1) return getString(digits.charAt(0));
            return find(digits);
        }

        private List<String> find(String digits) {
            if (digits.length() == 0) {
                List<String> output = new ArrayList<>();
                output.add("");
                return output;
            }

            List<String> smaller = find(digits.substring(0, digits.length() - 1));
            List<String> output = new ArrayList<>();
            for (String str : smaller) {
                for (String ch : getString(digits.charAt(digits.length() - 1)))
                    output.add(str + ch);
            }

            return output;
        }

        public List<String> letterCombinations2(String digits) {
            if (digits.length() == 0) return new ArrayList<>();
            if (digits.length() == 1) return getString(digits.charAt(0));
            return helper(digits, 0);
        }

        private List<String> helper(String digits, int i) {
            if (i == digits.length()) {
                List<String> output = new ArrayList<>();
                output.add("");
                return output;
            }
            List<String> output = new ArrayList<>();
            for (String s : getString(digits.charAt(i))) {
                List<String> subList = helper(digits, i + 1);
                for (String sub : subList) output.add(s + sub);
            }
            return output;
        }

        public List<String> letterCombinations3(String digits) {
            if (digits.length() == 0) return new ArrayList<>();
            if (digits.length() == 1) return getString(digits.charAt(0));

            List<String> output = new ArrayList<>();
            for (String s : getString(digits.charAt(0))) {
                List<String> subList = letterCombinations3(digits.substring(1));
                for (String sub : subList) output.add(s + sub);
            }
            return output;
        }

        public List<String> letterCombinations4(String digits) {
            if (digits.length() == 0) return new ArrayList<>();
            if (digits.length() == 1) return getString(digits.charAt(0));

            List<String> output = new ArrayList<>();
            find(digits, 0, new StringBuffer(), output);
            return output;
        }

        private void find(String str, int idx, StringBuffer sb, List<String> out) {
            if (idx == str.length()) {
                out.add(new String(sb));
                return;
            }

            for (String ch : getString(str.charAt(idx))) {
                sb.append(ch);
                find(str, idx + 1, sb, out);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String digits = "23";
        Out.print(sol.letterCombinations4(digits));
    }
}
