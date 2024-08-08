package companyOA.hackerrank.swiggy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FlexibleStrings {
    public static boolean isFlexible(String s, List<Pair> pairs) {
        Collections.sort(pairs);
        for (Pair p : pairs)
            s = s.replace(p.from, p.to);

        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) != s.charAt(i + 1))
                return false;

        return true;
    }

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            String inputStr = in.next();
            List<Pair> pairs = new ArrayList<>();
            int M = in.nextInt();
            while (M-- > 0) {
                String from = in.next();
                String to = in.next();
                pairs.add(new Pair(from.charAt(0), to.charAt(0)));
            }
            System.out.println(isFlexible(inputStr, pairs) ? "YES" : "NO");
        }
    }

    public static class Pair implements Comparable<Pair> {
        char from;
        char to;

        public Pair(char from, char to) {
            super();
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.to <= o.from)
                return -1;
            else
                return 0;
        }
    }
}