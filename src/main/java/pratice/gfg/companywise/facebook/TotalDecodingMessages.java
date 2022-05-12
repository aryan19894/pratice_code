package pratice.gfg.companywise.facebook;

import pratice.common.Out;

public class TotalDecodingMessages {
    static public class Solution {
        // [Optimal] O(expo n) - we storing the target-sum as key to map with its frequency - how many times it is calculated
        public int CountWays(String str) {
            int n = str.length();
            if (n == 0 || (n == 1 && str.charAt(0) == '0')) return 0;
            return countDecoding(str, n);
        }

        private int countDecoding(String str, int n) {
            if (n == 0 || n == 1) return 1;
            if (str.charAt(0) == '0') return 0;

            int count = 0;
            if (str.charAt(n - 1) > '0')
                count = countDecoding(str, n - 1);

            if (str.charAt(n - 2) == '1' ||
                    (str.charAt(n - 2) == '2' && str.charAt(n - 1) < '7'))
                count += countDecoding(str, n - 2);

            return count;
        }
        private static final int MODULO = 1000000007;
        // [Optimal] O(n) - DP
        public int CountWays2(String str) {
            int n = str.length();
            int[] count = new int[n + 1];
            count[0] = count[1] = 1;
            if (str.charAt(0) == '0') return 0;

            for (int i = 2; i <= n; i++) {
                count[i] = 0;
                if (str.charAt(i- 1) > '0')
                    count[i] = count[i - 1] % MODULO;

                if (str.charAt(i- 2) == '1' ||
                        (str.charAt(i- 2) == '2' && str.charAt(i- 1) < '7'))
                    count[i] += count[i - 2] % MODULO;
            }
            return count[n] % MODULO;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "11111198119819112116111511820112111719411119111211116111711110111";
        Out.print(sol.CountWays2(str));
    }
}
