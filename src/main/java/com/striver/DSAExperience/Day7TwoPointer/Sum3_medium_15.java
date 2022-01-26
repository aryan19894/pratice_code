package com.striver.DSAExperience.Day7TwoPointer;/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

import com.common.Obj;

import java.util.*;

// @lc code=start
public class Sum3_medium_15 {
    static class Solution {
        static class Triplet {
            private int[] data;

            public Triplet(int n1, int n2, int n3) {
                data = new int[]{n1, n2, n3};
                Arrays.sort(data);
            }

            public int at(int index) {
                return data[index];
            }

            public int[] get() {
                return this.data;
            }

            public boolean equals(Triplet other) {
                return null != other &&
                        this.data[0] == other.data[0] &&
                        this.data[1] == other.data[1] &&
                        this.data[2] == other.data[2];
            }

            public boolean equals(Object obj) {
                return equals((Triplet) obj);
            }

            public int hashCode() {
                return 2 * data[0] + 3 * data[1] + 5 * data[2];
            }

            public List<Integer> asList() {
                List<Integer> ref = new ArrayList<>();
                for (int d : data)
                    ref.add(d);
                return ref;
            }
        }

        // [Basic] O(n3logm), O(m) - find each subset and check sum of triplets are zero
        // [Better] O(n2logm), O(m)+O(n) - create hashmap and iterate with a and b.
        public List<List<Integer>> threeSum1(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            HashSet<Triplet> result = new HashSet<>();
            List<List<Integer>> res = new ArrayList<>();

            for (int n : nums)
                update(map, n, 1);

            int n = nums.length;
            for (int i = 0; i < n; i++) {
                update(map, nums[i], -1);
                for (int j = i + 1; j < n; j++) {
                    update(map, nums[j], -1);
                    int c = -1 * (nums[i] + nums[j]);
                    if (map.containsKey(c))
                        result.add(new Triplet(nums[i], nums[j], c));
                    update(map, nums[j], 1);
                }
                update(map, nums[i], 1);
            }

            for (Triplet r : result) {
                res.add(r.asList());
            }
            return res;
        }

        private void update(HashMap<Integer, Integer> map, int num, int i) {
            map.putIfAbsent(num, 0);
            if (i == 1)
                map.put(num, map.get(num) + 1);
            else if (i == -1) {
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }

        //[Optimal] O(n2logm), O(m)+O(n) - create hashmap and iterate with a and b.
        public List<List<Integer>> threeSum2(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0)
                return res;

            Arrays.sort(nums);
            HashSet<Triplet> result = new HashSet<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int left = i + 1;
                int right = n - 1;
                int remain = -1 * nums[i];

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum < remain) left++;
                    else if (sum > remain) right--;
                    else {
                        Triplet t = new Triplet(nums[i], nums[left], nums[right]);
                        result.add(t);

                        //Processing the duplicates of number2
                        while (left < right && nums[left] == t.at(1)) left++;
                        //Processing the duplicates of number4
                        while (left < right && nums[right] == t.at(2)) right--;
                    }
                }
            }
            for (Triplet r : result) {
                res.add(r.asList());
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(sol.threeSum1(nums));
        System.out.println(sol.threeSum2(nums));
    }
}

// @lc code=end

