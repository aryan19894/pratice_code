package pratice.gfg.companywise.facebook;

import pratice.common.Out;

public class LookAndSayPattern {
    static String lookandsay(int n) {
        if (n == 1) return "1";
        StringBuilder res = new StringBuilder();
        String s = lookandsay(n - 1) + "0";
        for (int i = 0, count = 1; i < s.length() - 1; i++, count++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                res.append(count).append(s.charAt(i));
                count = 0;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int n = 11;
        Out.print(lookandsay(n));
    }
}
