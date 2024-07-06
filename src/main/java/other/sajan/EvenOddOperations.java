package other.sajan;

import java.util.List;

public class EvenOddOperations {
    public static long getMaximumScore(List<Integer> a) {
        int n = a.size();
        long []prefixSum = new long[n];

        prefixSum[0] = a.get(0);
        for (int i = 1; i < n; i++) {
            prefixSum[i]
                    = prefixSum[i - 1] + a.get(i);
        }

        long [][][]dp = new long[n+1][n+1][1000];
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=n;j++){
                for(int l=0;l<1000;l++)
                    dp[i][j][l]=-1;
            }
        }

        return maximumScoreDP(0, n - 1, prefixSum, 1, dp);

    }

    static long maximumScoreDP(int l, int r, long prefixSum[], int num, long [][][]dp) {
        if (l > r) return 0;
        if (dp[l][r][num] != -1) return dp[l][r][num];

        long current_sum = prefixSum[r] - (l - 1 >= 0 ? prefixSum[l - 1] : 0);

        if (num % 2 == 0) current_sum *= -1;
        dp[l][r][num] = current_sum + Math.max(
                maximumScoreDP(l + 1, r,
                        prefixSum, num + 1, dp),
                maximumScoreDP(l, r - 1,
                        prefixSum, num + 1, dp));

        return dp[l][r][num];
    }

    public static void main(String[] args) {

    }
}
