package pratice.book.karumanchi.chapter2.backtracking.leetcode;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class Permutations_medium_46 {
    static class Solution {
        static class MultiList extends ArrayList<List<Integer>> {
            public void add(int[] ele) {
                ArrayList<Integer> d = new ArrayList();
                for (int ar : ele)
                    d.add(ar);
                this.add(d);
            }
        }

        public MultiList permute(int[] nums) {
            MultiList output = new MultiList();
            find(nums, 0, output);
            return output;
        }

        private void find(int[] nums, int idx, MultiList output) {
            if (idx == nums.length) {
                output.add(nums);
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                swap(nums, i, idx);
                find(nums, idx + 1, output);
                swap(nums, i, idx);
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i != j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

//        public MultiList permute(int[] nums) {
//            return find(nums, 0);
//        }
//
//        private MultiList find(int[] nums, int idx) {
//            if (idx == nums.length - 1) {
//                MultiList output = new ArrayList<>();
//                output.add(Arrays.asList(new Integer[]{nums[idx]}));
//                return output;
//            }
//
//            MultiList sub = find(nums, idx + 1);
//            MultiList output = new ArrayList<>();
//            for (List<Integer> s : sub) {
//                for (int i = 0; i <= s.size(); i++) {
//                    List<Integer> ref = new ArrayList<>(s);
//                    ref.add(i, nums[idx]);
//                    output.add(new ArrayList<>(ref));
//                }
//            }
//            return output;
//        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        Out.print(sol.permute(nums));
    }
}
