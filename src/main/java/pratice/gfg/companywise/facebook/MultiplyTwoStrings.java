package pratice.gfg.companywise.facebook;

import pratice.common.Out;

public class MultiplyTwoStrings {
    static public class Solution {
        public String multiplyStrings(String s1, String s2) {
            String result = "";
            if ((s1.charAt(0) == '-' || s2.charAt(0) == '-') &&
                    (s1.charAt(0) != '-' || s2.charAt(0) != '-'))
                result = "-";

            while (s1.length() > 0 && (s1.charAt(0) == '-' || s1.charAt(0) == '0'))
                s1 = s1.substring(1);
            while (s1.length() > 0 && (s2.charAt(0) == '-' || s2.charAt(0) == '0'))
                s2 = s2.substring(1);

            int n = s1.length();
            int m = s2.length();
            if (n == 0 || m == 0) return "0";

            int res[] = multiply(s1, n, s2, m);

            int i = res.length - 1;
            while (res[i] == 0) i--;
            while (i >= 0) {
                result += res[i--];
            }
            return result;
        }

        private int[] multiply(String s1, int n, String s2, int m) {
            int res[] = new int[n + m];
            int idx1 = 0;
            for (int i = n - 1; i >= 0; i--) {
                int n1 = s1.charAt(i) - '0';
                int carry = 0;
                int idx2 = 0;
                for (int j = m - 1; j >= 0; j--) {
                    int n2 = s2.charAt(j) - '0';
                    int sum = n1 * n2 + res[idx1 + idx2] + carry;
                    carry = sum / 10;
                    res[idx1 + idx2] = sum % 10;
                    idx2++;
                }
                if (carry > 0)
                    res[idx1 + idx2] += carry;
                idx1++;
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "-10";
        String s2 = "0";
        Out.print(sol.multiplyStrings(s1, s2));
    }
}
