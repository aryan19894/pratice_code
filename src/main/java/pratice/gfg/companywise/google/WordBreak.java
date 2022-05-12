package pratice.gfg.companywise.google;

import pratice.common.Out;
import pratice.common.converter.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static int wordBreak(String A, ArrayList<String> B) {
        Set<String> dict = new HashSet<>();
        for (String d : B)
            dict.add(d);

        return check(A, dict) ? 1 : 0;
    }

    private static boolean check(String str, Set<String> dict) {
        int n = str.length();
        if (n == 0) return true;
        for (int i = 1; i <= n; i++) {
            if (dict.contains(str.substring(0, i)) && check(str.substring(i, n), dict))
                return true;
        }
        return false;
    }

    public static int wordBreak2(String A, ArrayList<String> B) {
        int n = A.length();
        if (n == 0) return 1;

        Set<String> dict = new HashSet<>();
        for (String d : B)
            dict.add(d);

        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (dict.contains(A.substring(0, i))) dp[i] = true;
            if (dp[i]) {
                if (i == n) return 1;
                for (int j = i + 1; j <= n; j++) {
                    if (!dp[j] && dict.contains(A.substring(i, j))) dp[j] = true;
                    if (j == n && dp[j]) return 1;
                }
            }
        }

        return 0;
    }

    public static int wordBreak3(String A, ArrayList<String> B) {
        int n = A.length();
        if (n == 0) return 1;

        Set<String> dict = new HashSet<>();
        for (String d : B)
            dict.add(d);

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n] ? 1 : 0;
    }

    public static void main(String[] args) {
        String A = "ilikesamsung";
        String dict[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};
        ArrayList<String> B = Array.toList(dict);
        Out.print(wordBreak(A, B));
        Out.print(wordBreak2(A, B));
        Out.print(wordBreak3(A, B));
    }
}
