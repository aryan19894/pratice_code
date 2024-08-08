package companyOA.Interview.gartner.round2;

public class PerfectSquare {
    public static void main(String[] args) {
        int n = 41;
        System.out.println(isPerfectSquare(n));
    }

    private static boolean isPerfectSquare(int num) {
        long l = 1, r = num;

        while (l <= r) {
            long mid = (l + r) / 2;
            if (mid * mid == num)
                return true;
            if (mid * mid < num)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return false;
    }
}
