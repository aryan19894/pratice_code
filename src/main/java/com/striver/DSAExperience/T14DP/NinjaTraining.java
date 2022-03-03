package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;

public class NinjaTraining {
    // [Better DP: Memo] TC: O(N*4*3):  There are N*4 states and for every state,
    // we are running a for loop iterating three times.
    // SC: O(N) + O(N*4): using a recursion stack space(O(N)) and a 2D array (again O(N*4)).
    // Therefore, total space complexity will be O(N) + O(N) ≈ O(N)
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return countDays(points, dp, n - 1, 3);
    }

    private static int countDays(int[][] points, int[][] dp, int day, int lastDay) {
        if (dp[day][lastDay] != -1) return dp[day][lastDay];
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < points[0].length; i++) {
                if (i != lastDay)
                    max = Math.max(max, points[0][i]);
            }
            return dp[day][lastDay] = max;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points[0].length; i++) {
            if (i != lastDay)
                max = Math.max(max, points[day][i] + countDays(points, dp, day - 1, i));
        }
        return dp[day][lastDay] = max;
    }

    // [Better DP: Tab] TC: O(N*4*3): three nested loops
    // SC: O(N*4): 3 is no of task. using an external array of size ‘N*4’’.
    public static int ninjaTraining2(int n, int points[][]) {
        int[][] dp = new int[n + 1][4];
        for (int task = 0; task <= 3; task++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != task)
                    max = Math.max(max, points[0][i]);
            }
            dp[0][task] = max;
        }
        for (int day = 1; day < n; day++) {
            for (int last = 0; last <= 3; last++) {
                for (int task = 0; task < 3; task++) {
                    if (last != task)
                        dp[day][last] = Math.max(dp[day][last], points[day][task] + dp[day - 1][task]);
                }
            }
        }

        return dp[n-1][3];
    }

    // [Better DP: Tab] TC: O(N*4*3): three nested loops
    // SC: O(4): 3 is no of task. using an external array of size ‘4’ to store only one row.
    public static int ninjaTraining3(int n, int points[][]) {
        int[] prev = new int[4];
        for (int task = 0; task <= 3; task++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != task)
                    max = Math.max(max, points[0][i]);
            }
            prev[task] = max;
        }
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last <= 3; last++) {
                for (int task = 0; task < 3; task++) {
                    if (last != task)
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                }
            }
            prev = temp;
        }

        return prev[3];
    }

    public static void main(String[] args) {
        int n = 0;
        int points[][] = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};
//        Out.print(ninjaTraining(points.length, points));
        //Out.print(ninjaTraining2(points.length, points));
        Out.print(ninjaTraining3(points.length, points));
    }
}
