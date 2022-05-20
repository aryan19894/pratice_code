package pratice.leetcode.blind75.T10Heap;

import pratice.common.Out;

import java.util.*;

public class TopKFrequentElements_medium_347 {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int n : nums)
                map.put(n, map.getOrDefault(n, 0) + 1);

            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                    (a, b) -> b.getValue() - a.getValue());

            for (Map.Entry<Integer, Integer> e : map.entrySet())
                pq.offer(e);

            int[] result = new int[k];
            for (int i = 0; i < k; i++)
                result[i] = pq.remove().getKey();

            return result;
        }

        public int[] topKFrequent2(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int n : nums)
                map.put(n, map.getOrDefault(n, 0) + 1);

            List<Integer>[] bucket = new List[nums.length + 1];

            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                int freq = e.getValue();

                if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
                bucket[freq].add(e.getKey());
            }

            int[] result = new int[k];
            int x = 0;
            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i] != null) {
                    for (int a : bucket[i]) {
                        result[x++] = a;
                        k--;
                    }
                    if (k == 0) return result;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Out.print(sol.topKFrequent(nums, k));
        Out.print(sol.topKFrequent2(nums, k));
    }
}
