package pratice.hackerrank.contest.HackTheInterview.II.Global.QuesI;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Result {
    public static int maxScore1(List<Integer> a, int m) {
        Collections.sort(a);
        long res = 0L;
        long seg = 1L;
        long sum = 0L;
        int noSegment = a.size() / m;
        if (noSegment == 1) {
            return sumOfElement(a);
        } else {
            for(int i = 0; i < a.size(); ++i) {
                sum += (long)(Integer)a.get(i);
                if (noSegment != 1 && i % m == m - 1) {
                    res += seg++ * sum;
                    --noSegment;
                    sum = 0L;
                }
            }

            res += seg++ * sum;
            return (int)(res % 1000000007L);
        }
    }

    public static int maxScore2(List<Integer> a, int m) {
        Collections.sort(a);
        int mod = 1000000007;
        long seg = 1L;
        long sum = 0L;
        int n = a.size();
        int noSegment = n / m;
        int start = 0;

        for(int end = m; noSegment > 1; --noSegment) {
            sum += seg++ * sumOfElement(a, start, end);
            start = end;
            end += m;
        }

        sum += seg * sumOfElement(a, start, n);
        return (int)(sum % (long)mod);
    }

    public static int maxScore3(List<Integer> a, int m) {
        Collections.sort(a);
        int mod = 1000000007;
        long sum = 0L;
        int n = a.size();
        int seg = n / m;
        int start = n - m - n % m;

        for(int end = n; seg > 0; start -= m) {
            sum += (long)(seg--) * sumOfElement(a, start, end);
            end = start;
        }

        return (int)(sum % (long)mod);
    }

    private static int sumOfElement(List<Integer> a) {
        long r = 0L;

        Integer i;
        for(Iterator var3 = a.iterator(); var3.hasNext(); r += (long)i) {
            i = (Integer)var3.next();
        }

        return (int)(r % 1000000007L);
    }

    private static long sumOfElement(List<Integer> a, int start, int end) {
        long r = 0L;

        for(int i = start; i < end; ++i) {
            r += (long)(Integer)a.get(i);
        }

        return r;
    }

}
