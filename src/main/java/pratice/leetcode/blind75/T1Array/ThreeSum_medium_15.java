package pratice.leetcode.blind75.T1Array;

import pratice.common.Out;

import java.util.*;

public class ThreeSum_medium_15 {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Set<List<Integer>> set = new HashSet<>();
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int l = i + 1;
                int r = n - 1;
                int remain = -1 * nums[i];

                while (l < r) {
                    int sum = nums[l] + nums[r];
                    if (sum == remain) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[l]);
                        subList.add(nums[r]);
                        set.add(subList);

                        while (l < r && nums[l] == subList.get(1)) l++;
                        while (l < r && nums[r] == subList.get(2)) r--;
                    } else if (sum < remain) l++;
                    else r--;
                }
            }
            result.addAll(set);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        Out.print(sol.threeSum(nums));
    }
}
