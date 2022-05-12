package pratice.hackerrank.pratice.java.advance;

public class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public static PerformOperation isOdd() {
        return (n) -> {
            return (n & 1) == 1;
        };
    }

    public static PerformOperation isPrime() {
        return (n) -> {
            if (n < 2) {
                return false;
            } else {
                int sqrt = (int)Math.sqrt((double)n);

                for(int i = 2; i <= sqrt; ++i) {
                    if (n % i == 0) {
                        return false;
                    }
                }

                return true;
            }
        };
    }

    public static PerformOperation isPalindrome() {
        return (n) -> {
            String original = Integer.toString(n);
            String reversed = (new StringBuilder(Integer.toString(n))).reverse().toString();
            return original.equals(reversed);
        };
    }
}
