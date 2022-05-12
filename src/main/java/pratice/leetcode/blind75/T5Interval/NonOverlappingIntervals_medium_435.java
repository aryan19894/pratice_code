package pratice.leetcode.blind75.T5Interval;

import pratice.common.Out;

import java.util.Arrays;

public class NonOverlappingIntervals_medium_435 {
    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int count = 0;
            if (intervals == null || intervals.length == 0) return 0;
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (end > intervals[i][0]) {
                    count++;
                    end = Math.min(end, intervals[i][1]);
                } else
                    end = intervals[i][1];
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Out.print(sol.eraseOverlapIntervals(intervals));
    }
}
