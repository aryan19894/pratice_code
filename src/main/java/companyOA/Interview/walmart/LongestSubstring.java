package companyOA.Interview.walmart;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubstring {

    static final int NO_OF_CHARS = 256;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(longestUniqueSubsttr(str));
    }

    private static int longestUniqueSubsttr(String str) {
        int n = str.length();
        int res = 0;

        int[] lastIndex = new int[NO_OF_CHARS];
        Arrays.fill(lastIndex, -1);

        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);
            res = Math.max(res, j - i + 1);
            lastIndex[str.charAt(j)] = j;
        }

        return res;
    }

}
