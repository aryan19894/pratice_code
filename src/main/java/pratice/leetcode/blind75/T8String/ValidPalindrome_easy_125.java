package pratice.leetcode.blind75.T8String;

import pratice.common.Out;

public class ValidPalindrome_easy_125 {
    static class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) return false;
            StringBuilder sb = new StringBuilder("");
            for (char ch : s.toCharArray()) {
                int x = (int) ch;
                if ((x >= 65 && x <= 90) || (x >= 97 && x <= 122) || (x >= 48 && x <= 57))
                    sb.append(Character.toLowerCase(ch));
            }
            if (sb.toString().equals("")) return true;
            s = sb.toString();
            int n = s.length();
            for (int i = 0; i <= n / 2; i++)
                if (s.charAt(i) != s.charAt(n - i - 1)) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "A man, a plan, a canal: Panama";
        Out.print(sol.isPalindrome(s));
    }
}
