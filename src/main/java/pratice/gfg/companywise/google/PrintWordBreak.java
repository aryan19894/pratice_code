package pratice.gfg.companywise.google;

import pratice.common.converter.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PrintWordBreak {
    public static void wordBreak(String A, ArrayList<String> B) {
        Set<String> dict = new HashSet<>();
        for (String d : B)
            dict.add(d);

        printWordBreak(A.length(), A, dict, "");
    }

    private static void printWordBreak(int n, String str, Set<String> dict, String ans) {
        for (int i = 1; i <= n; i++) {
            String prefix = str.substring(0, i);
            if (dict.contains(prefix)) {
                if (i == n) {
                    ans += prefix;
                    System.out.println(ans);
                    return;
                }
                printWordBreak(n - i, str.substring(i, n), dict, ans + prefix + " ");
            }
        }
    }

    public static void main(String[] args) {
        String A = "ilikesamsung";
        String dict[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};
        ArrayList<String> B = Array.toList(dict);
        wordBreak(A, B);
    }
}
