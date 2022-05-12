package pratice.gfg.companywise.facebook;

import pratice.common.Out;

public class ImplementStrstr {
    static public class Solution {
        // [Basic - brute] compare each char to substring
        int strstr(String s, String x) {
            int n = s.length();
            int m = x.length();
            for (int i = 0; i <= n - m; i++) {
                int j = 0;
                while (j < m && s.charAt(i + j) == x.charAt(j))
                    j++;
                if (j == m)
                    return i;
            }
            return -1;
        }

        // [Better - KMP] will create prefixTable
        int strstr2(String s, String x) {
            int n = s.length();
            int m = x.length();
            int[] prefix = calcPrefix(x, m);
            int i = 0, j = 0;
            while (i < n) {
                if (s.charAt(i) == x.charAt(j)) {
                    if (j == m - 1) return i - j;
                    else {
                        i++;
                        j++;
                    }
                } else if (j > 0)
                    j = prefix[j - 1];
                else i++;
            }
            return -1;
        }

        private int[] calcPrefix(String x, int m) {
            int[] prefix = new int[m];
            int i = 1, j = 0;
            while (i < m) {
                if (x.charAt(i) == x.charAt(j))
                    prefix[i++] = ++j;
                else if (j > 0)
                    j = prefix[j - 1];
                else i++;
            }
            return prefix;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "GeeksForGeeks";
        String x = "For";
        Out.print(sol.strstr(s, x));
        Out.print(sol.strstr2(s, x));
    }
}
