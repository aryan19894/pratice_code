package pratice.book.karumanchi.chapter2.striver;

import pratice.common.Out;

import java.util.*;

public class SubsetsIi_medium_90 {
    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            find(nums, 0, new ArrayList<>(), result);
            return new ArrayList<>(result);
        }

//        private void find(int[] arr, int i, ArrayList<Integer> sub, Set<List<Integer>> res) {
//            if (i == arr.length) {
//                res.add(new ArrayList<>(sub));
//                return;
//            }
//
//            //take
//            sub.add(arr[i]);
//            find(arr, i + 1, sub, res);
//            sub.remove(sub.size() - 1);
//
//            //notTake
//            find(arr, i + 1, sub, res);
//        }

        private void find(int[] arr, int idx, ArrayList<Integer> sub, List<List<Integer>> res) {
            res.add(new ArrayList<>(sub));
            for (int i = idx; i < arr.length; i++) {
                if (i > idx && arr[i] == arr[i - 1]) continue;

                sub.add(arr[i]);
                find(arr, i + 1, sub, res);
                sub.remove(sub.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 2};
        Out.print(sol.subsetsWithDup(nums));
    }
}
