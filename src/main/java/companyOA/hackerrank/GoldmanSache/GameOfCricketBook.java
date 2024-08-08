package companyOA.hackerrank.GoldmanSache;

import java.util.Scanner;

public class GameOfCricketBook {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(noOfWaysToDrawTheGame(n));
    }

    static int noOfWaysToDrawTheGame(int n) {
        int[] dp = new int[n + 7];

        if (n % 2 != 0)
            return 0;

        dp[0] = 1;
        dp[2] = 1;
        dp[4] = 2;
        dp[6] = 4;

        if (n < 8)
            return dp[n];

        for (int i = 8; i <= n; i = i + 2) {
            dp[i] = dp[i - 2] + dp[i - 4] + dp[i - 6];
        }

        return dp[n];
    }
}
