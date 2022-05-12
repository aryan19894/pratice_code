package pratice.striver.DSAExperience.T8Trie;

import pratice.common.Out;

public class MaximumXOROfTwoNumbersInAnArray_medium_421 {
    static class Node {
        Node[] links = new Node[2]; // 0 and 1 bit

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
        Node root = new Node();

        public void insert(int nums) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (nums >> i) & 1; // getting the ith bit
                if (!node.containsKey(bit))
                    node.put(bit, new Node());
                node = node.get(bit);
            }
        }

        public int getMax(int nums) {
            Node node = root;
            int max = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (nums >> i) & 1;// getting the ith bit
                if (node.containsKey(1 - bit)) { // 1-bit is for opposite of bit 1-1 =0, 1-0 = 1
                    max |= (1 << i);
                    node = node.get(1 - bit);
                } else
                    node = node.get(bit);
            }
            return max;
        }
    }

    static class Solution {
        // [Better Trie] TC: O(N*32) + O(M*32) - For inserting all the elements of arr1 into the trie take O(N*32) [32 Bit]
        // and O(M*32) for finding the maxXOR for every element of arr2.
        // SC: O(N*32) - Since we are inserting all the elements of arr1 into trie where every element is of size 32 bit
        // but the space complexity will be less than O(N*32) because they might have overlapped.
        public int findMaximumXOR(int[] nums) {
            Trie t = new Trie();
            int result = 0;
            for (int n : nums)
                t.insert(n);

            for (int i = 0; i < nums.length; i++)
                result = Math.max(result, t.getMax(nums[i]));

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        Out.print(sol.findMaximumXOR(nums));
    }
}
