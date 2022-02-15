package com.striver.DSAExperience.T5BinarySearch;

public class CapacityToShipPackagesWithinDDays_medium_1011 {
    static class Solution {
        // [Optimal] TC: O(logn*N), SC: O(1) - using binary search
        // logN - while loop filtering the mid index
        // N is for checking possibility of allocations
        public int shipWithinDays(int[] weights, int days) {
            if (days > weights.length) return -1;
            int low = weights[0];
            int high = 0;
            for (int w : weights) {
                low = Math.min(low, w);
                high += w;
            }

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (allocationPossible(weights, mid, days))
                    high = mid - 1;
                else low = mid + 1;
            }
            return low;
        }

        private boolean allocationPossible(int[] weights, int mid, int days) {
            int cnt = 0, sum = 0;
            for (int w : weights) {
                if (w > mid) return false;
                if (sum + w > mid) {
                    cnt++;
                    sum = w;
                } else
                    sum += w;
            }
            if (cnt >= days) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] weights = {1,2,3,1,1};
        int days = 4;
        System.out.println(sol.shipWithinDays(weights, days));
    }
}
