package pratice.book.karumanchi.chapter2.striver;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum_medium_39 {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Set<List<Integer>> result = new HashSet<>();
            List<Integer> sub = new ArrayList<>();
            find(candidates, 0, target, sub, result);
            return new ArrayList<>(result);
        }

        private void find(int[] arr, int i, int k, List<Integer> sub, Set<List<Integer>> res) {
            if (i == arr.length) {
                if (k == 0) {
                    res.add(new ArrayList<>(sub));
                    return;
                }
                return;
            }

            //take
            if (arr[i] <= k) {
                sub.add(arr[i]);
                find(arr, i, k - arr[i], sub, res); // i not increase repeat is allowed
                sub.remove(sub.size() - 1);
            }
            //notTake
            find(arr, i + 1, k, sub, res);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2, 3, 5};
        int target = 8;
        Out.print(sol.combinationSum(candidates, target));
    }
}
