package pratice.leetcode.blind75.T4Graph;

import pratice.common.Out;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence_medium_128 {
    static class DisjointSet {
        HashMap<Integer, Integer> parents, rank;
        int n;

        public DisjointSet(int[] num) {
            parents = new HashMap<>();
            rank = new HashMap<>();
            this.n = num.length;

            for (int n : num) {
                parents.put(n, n);
                rank.put(n, 1);
            }
        }

        public int maxSize() {
            int max = 0;
            for (int n : rank.values())
                max = Math.max(max, n);
            return max;
        }

        public int find(int ele) {
            int root = ele;
            while (root != parents.get(root)) {
                root = parents.get(root);
                parents.put(root, parents.get(parents.get(root)));
            }
            return root;
        }

        public void union(int u, int v) {
            int p1 = find(u);
            int p2 = find(v);

            if (p1 == p2) return;
            if (rank.get(p1) < rank.get(p2)) {
                parents.put(p1, p2);
                rank.put(p2, rank.get(p1) + rank.get(p2));
                rank.put(p1, 0);
            } else {
                parents.put(p2, p1);
                rank.put(p1, rank.get(p1) + rank.get(p2));
                rank.put(p2, 0);
            }
        }
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            int n = nums.length;
            if (nums == null || n == 0) return 0;

            HashSet<Integer> set = new HashSet<>();
            for (int num : nums)
                set.add(num);

            int result = 1;
            for (int num : nums) {
                if (!set.contains(num - 1)) {
                    int curr = num;
                    int len = 1;
                    while (set.contains(++curr))
                        len++;
                    result = Math.max(result, len);
                }
            }
            return result;
        }

        public int longestConsecutive2(int[] nums) {
            int n = nums.length;
            if (nums == null || n == 0) return 0;

            HashSet<Integer> set = new HashSet<>();
            DisjointSet ds = new DisjointSet(nums);

            for (int num : nums) {
                if (set.contains(num - 1))
                    ds.union(num, num - 1);
                if (set.contains(num + 1))
                    ds.union(num, num + 1);
                set.add(num);
            }
            return ds.maxSize();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        Out.print(sol.longestConsecutive(nums));
        Out.print(sol.longestConsecutive2(nums));
    }
}
