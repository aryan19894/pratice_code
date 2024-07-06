package pratice.book.karumanchi.chapter2.striver;

import pratice.common.Out;

import java.util.*;

public class CombinationSumIi_medium_40 {
    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Set<List<Integer>> result = new HashSet<>();
            Arrays.sort(candidates);
            find(candidates, 0, target, new ArrayList<>(), result);
            return new ArrayList<>(result);
        }

//        private void find(int[] arr, int i, int k, ArrayList<Integer> sub, Set<List<Integer>> res) {
//            if (i == arr.length) {
//                if (k == 0) {
//                    res.add(new ArrayList<>(sub));
//                    return;
//                }
//                return;
//            }
//
//            //take
//            if (arr[i] <= k) {
//                sub.add(arr[i]);
//                find(arr, i + 1, k - arr[i], sub, res);
//                sub.remove(sub.size() - 1);
//            }
//
//            //notTake
//            find(arr, i + 1, k, sub, res);
//        }

        private void find(int[] arr, int idx, int k, ArrayList<Integer> sub, Set<List<Integer>> res) {
            if (k == 0) {
                res.add(new ArrayList<>(sub));
                return;
            }

            for (int i = idx; i < arr.length; i++) {
                if (i > idx && arr[i] == arr[i - 1]) continue;
                if (arr[i] > k) break;

                sub.add(arr[i]);
                find(arr, i + 1, k - arr[i], sub, res);
                sub.remove(sub.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {1, 1, 1, 2, 2};
        int target = 4;
        Out.print(sol.combinationSum2(candidates, target));
    }
}
