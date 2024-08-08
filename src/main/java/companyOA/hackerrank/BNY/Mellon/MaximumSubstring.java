package companyOA.hackerrank.BNY.Mellon;

import java.util.Scanner;

public class MaximumSubstring {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(maxSubstring(str));
    }

    public static String maxSubstring(String s) {
        char fchar = s.charAt(0);
        String res = s;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (fchar <= c) {
                fchar = c;
                res = max(res, s.substring(i));
            }
        }
        return res;
    }

    private static String max(String s1, String s2) {
        if (s1.compareTo(s2) > 0)
            return s1;
        else if (s1.compareTo(s2) < 0) {
            return s2;
        }
        return s1;
    }
}
