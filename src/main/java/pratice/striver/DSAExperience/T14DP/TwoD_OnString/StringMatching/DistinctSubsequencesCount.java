package pratice.striver.DSAExperience.T14DP.TwoD_OnString.StringMatching;

//import com.platform.testcase.TestCaseRunnerMain;
//import com.platform.testcase.bean.TestCase;
import pratice.common.Out;

import java.util.Arrays;
import java.util.List;

public class DistinctSubsequencesCount {
    private static final int MOD = (int) (1e9 + 7);
    // [Better DP: Recur] TC: O(2powN) + O(2powM):  each character has option with match or not match

    // [Better DP: Memo] TC: O(N*M) + O(N):  N*M character combination
    // SC: O(N*M) + O(N+M): using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
    public static int subsequenceCounting(String t, String s, int lt, int ls) {
        int[][] dp = new int[lt + 1][ls + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);

        return count(t, lt, s, ls, dp);
    }

    private static int count(String t, int i, String s, int j, int[][] dp) {
        if (j == 0) return 1;
        if (i == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (t.charAt(i - 1) == s.charAt(j - 1))
            return dp[i][j] = (count(t, i - 1, s, j - 1, dp) + count(t, i - 1, s, j, dp)) % MOD;
        else
            return dp[i][j] = count(t, i - 1, s, j, dp) % MOD;
    }

    // [Better DP: Tab] TC: O(N*M) + O(N):  N*M character combination
    // SC: O(N*M):using an external array of size ‘N*M’. Stack Space is eliminated.
    public static int subsequenceCounting2(String t, String s, int lt, int ls) {
        int[][] dp = new int[lt + 1][ls + 1];

        for (int i = 1; i <= lt; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= lt; i++) {
            for (int j = 1; j <= ls; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                else
                    dp[i][j] = dp[i - 1][j] % MOD;
            }
        }
        return dp[lt][ls];
    }

    // [Better DP: Tab] TC: O(N*M) + O(N):  N*M character combination
    // SC: O(N):using an external array of size ‘N*M’. Stack Space is eliminated.
    public static int subsequenceCounting3(String t, String s, int lt, int ls) {
        int[] prev = new int[ls + 1];

        prev[0] = 1;
        for (int i = 1; i <= lt; i++) {
            int[] curr = new int[ls + 1];
            curr[0] = 1;
            for (int j = 1; j <= ls; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    curr[j] = (prev[j - 1] + prev[j]) % MOD;
                else
                    curr[j] = prev[j] % MOD;
            }
            prev = curr;
        }
        return prev[ls];
    }

    public static void main(String[] args) {
        String t = "cbbaaacbabbacbbcccbcabbcabbabacbcbccccbcbababccbcbbcaacbbacbcbacbccbcbabccbaacccabcbbbaaccbcccc";
        String s = "acccabccbbbccbccbc";
        int lt = 0;
        int ls = 0;
        Out.print(subsequenceCounting(t, s, t.length(), s.length()));
        Out.print(subsequenceCounting2(t, s, t.length(), s.length()));
        Out.print(subsequenceCounting3(t, s, t.length(), s.length()));
        //494038327
        boolean fileTestcase = true;
        if(fileTestcase) {
//            List<TestCase> testcase = TestCaseRunnerMain.run();
//            for (TestCase ts : testcase) {
//                String expectedOut = ts.getOutput();
//                int actualOut = subsequenceCounting(ts.getInput().get(0), ts.getInput().get(1),
//                        ts.getInput().get(0).length(), ts.getInput().get(1).length());
//
//                if (expectedOut.equals("" + actualOut))
//                    continue;
//                else
//                    System.out.println("[Failed]: " + ts + ",\n\t actualOut: " + actualOut);
//            }
        }
    }
}
