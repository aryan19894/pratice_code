package pratice.striver.DSAExperience.T8Trie;

import pratice.common.Out;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumXORWithAnElementFromArray_hard_1707 {
    static class Node {
        Node[] links = new Node[2];

        public Node() {
        }

        public boolean containsKey(int bit) {
            return links[bit] != null;
        }

        public Node get(int bit) {
            return links[bit];
        }

        public void put(int bit, Node node) {
            links[bit] = node;
        }
    }

    static class Trie {
        private static Node root;

        Trie() {
            root = new Node();
        }

        public void insert(int nums) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (nums >> i) & 1;
                if (!node.containsKey(bit))
                    node.put(bit, new Node());
                node = node.get(bit);
            }
        }

        public int getMax(int nums) {
            Node node = root;
            int maxNum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (nums >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    maxNum |= (1 << i);
                    node = node.get(1 - bit);
                } else
                    node = node.get(bit);
            }
            return maxNum;
        }
    }

    static class Solution {
        // [Better Trie] TC: O(2NlogN) + O(N*32) + O(Q*32) -2NlogN - sorting queries array and nums.
        // For inserting all the elements of arr1 into the trie take O(N*32) [32 Bit]
        // and O(Q*32) find max from the trie w.r.t queries
        // SC: O(Q) + O(N*32) - Firstly storing the offlineQueries and
        // then inserting all the elements of arr1 into trie where every element is of size 32 bit
        // but the space complexity will be less than O(N*32) because they might have overlapped.
        public int[] maximizeXor(int[] nums, int[][] queries) {
            int[] result = new int[queries.length];
            Arrays.fill(result, -1);
            //sorting the queries as per ai value
            int[][] offlineQueries = sortQueries(queries);
            Arrays.sort(nums);
            Trie t = new Trie();
            int idx = 0;
            for (int[] q : offlineQueries) {
                while (idx < nums.length && nums[idx] <= q[0])
                    t.insert(nums[idx++]);

                result[q[2]] = idx != 0 ? t.getMax(q[1]) : -1;
            }

            return result;
        }

        private int[][] sortQueries(int[][] queries) {
            int[][] offlineQueries = new int[queries.length][];
            for (int i = 0; i < queries.length; i++) {
                offlineQueries[i] = new int[]{queries[i][1], queries[i][0], i};
            }
            Arrays.sort(offlineQueries, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            return offlineQueries;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {5, 2, 4, 6, 6, 3};
        int[][] queries = {{12, 4}, {8, 1}, {6, 3}};
        Out.print(sol.maximizeXor(nums, queries));
    }
}
