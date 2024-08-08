package companyOA.hackerrank.Vitech;

import java.util.Scanner;

public class MaximumSubstring {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(maxSubstring(str));
    }

    public static String maxSubstring(String str) {
        String mx = "";
        for (int i = 0; i < str.length(); ++i) {
            if (mx.compareTo(str.substring(i)) <= 0) {
                mx = str.substring(i);
            }
        }
        return mx;
    }
}
