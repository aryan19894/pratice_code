package pratice.leetcode.blind75.T5Interval;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_medium_57 {
    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> res = new ArrayList<>();
            int idx = 0;
            int n = intervals.length;
            while (idx < n && intervals[idx][1] < newInterval[0])
                res.add(intervals[idx++]);

            while (idx < n && intervals[idx][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
                idx++;
            }
            res.add(newInterval);

            while (idx < n)
                res.add(intervals[idx++]);
            return res.toArray(new int[res.size()][2]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        Out.print(sol.insert(intervals, newInterval));
    }
}
