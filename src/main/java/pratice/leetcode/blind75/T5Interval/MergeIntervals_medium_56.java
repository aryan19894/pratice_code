package pratice.leetcode.blind75.T5Interval;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_medium_56 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            List<int[]> res = new ArrayList<>();
            if (intervals == null || n == 0)
                return res.toArray(new int[0][]);

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int start = intervals[0][0];
            int end = intervals[0][1];
            for (int[] interval : intervals) {
                if (interval[0] <= end)
                    end = Math.max(end, interval[1]);
                else {
                    res.add(new int[]{start, end});
                    start = interval[0];
                    end = interval[1];
                }
            }
            res.add(new int[]{start, end});
            return res.toArray(new int[0][]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Out.print(sol.merge(intervals));
    }
}
