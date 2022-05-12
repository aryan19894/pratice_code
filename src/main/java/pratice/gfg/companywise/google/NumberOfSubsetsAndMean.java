package pratice.gfg.companywise.google;

import pratice.common.Out;

import java.util.Arrays;

public class NumberOfSubsetsAndMean {
    private static final int MOD = (int) 1e9 + 7;

    static int[] numOfSubsets(int[] Arr, int N) {
        int[] result = new int[2];
        int maxVal = Arrays.stream(Arr).max().getAsInt();
        int minVal = Arrays.stream(Arr).min().getAsInt();
        for (int a : Arr) {
            if (a == minVal) result[1]++;
            if (a == maxVal) result[0]++;
        }
        for (int i = 0; i < 2; i++)
            result[i] = (int) ((Math.pow(2, result[i]) - 1) % MOD);

        return result;
    }

    public static void main(String[] args) {
        int[] Arr = {3, 1, 2, 3, 4};
        int N = 4;
        Out.print(numOfSubsets(Arr, N));
    }
}
