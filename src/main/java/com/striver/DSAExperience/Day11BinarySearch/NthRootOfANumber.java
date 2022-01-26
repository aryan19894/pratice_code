package com.striver.DSAExperience.Day11BinarySearch;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NthRootOfANumber {
    // [Optimal] TC: O(N*logn2(M*10)d) = n times for find multiply of each mid value
    // d = no of digits after decimal point
    // check each cell with all 4 directions
    // 10*M = 0 numbers with M with 1digit decimal point - 1.1,1.2,1.3........
    // SC: O(1)
    private static double findNthRoot(int num, int power) {
        if (power == 0) return 1;
        if (power == 1) return num;

        double low = 0;
        double high = num;
        double eps = 1e-6;
        while ((high - low) > eps) {
            double mid = (high + low) / 2.0;
            if (Math.pow(mid, power) < num)
                low = mid;
            else
                high = mid;
        }
        return round(high, "#.#####");
    }

    private static double round(double n, String decimalFormat) {
        DecimalFormat df = new DecimalFormat(decimalFormat);
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.valueOf(df.format((double) n));
    }

    public static void main(String[] args) {
        double ans = findNthRoot(27, 3);
        System.out.println(ans);
    }
}
