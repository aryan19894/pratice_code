package pratice.gfg.companywise.google;

import pratice.common.Out;

public class MaximumIndex {
    static int maxIndexDiff(int A[], int N) {
        int i = 0, max = 0;
        for (int j = i + 1; j < N; j++) {
            if (A[i] <= A[j] && j >= i)
                max = Math.max(max, j - i);
            if (j == N - 1) {
                j = max + i + 1;
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int A[] = {97, 65, 24, 84, 10, 82, 2, 51, 1, 91, 62, 59, 80, 76, 26, 66, 11};
        int N = 0;
        Out.print(maxIndexDiff(A, A.length));
    }
}
