package pratice.book.karumanchi.chapter2.striver;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class Permutations_medium_46 {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            boolean[] vis = new boolean[nums.length];
            find(nums, new ArrayList<Integer>(), vis, result);
            return result;
        }

        private void find(int[] arr, ArrayList<Integer> sub, boolean[] vis, List<List<Integer>> res) {
            if (arr.length == sub.size()) {
                res.add(new ArrayList<>(sub));
                return;
            }

            for (int i = 0; i < arr.length; i++) {
                if (vis[i]) continue;
                sub.add(arr[i]);
                vis[i] = true;
                find(arr, sub, vis, res);
                sub.remove(sub.size() - 1);
                vis[i] = false;
            }
        }

        public List<List<Integer>> permute1(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            find(nums, 0, result);
            return result;
        }

        private void find(int[] arr, int idx, List<List<Integer>> res) {
            if (idx == arr.length) {
                List<Integer> sub = new ArrayList<>();
                for (int a : arr)
                    sub.add(a);
                res.add(new ArrayList<>(sub));
                return;
            }

            for (int i = idx; i < arr.length; i++) {
                swap(arr, idx, i);
                find(arr, idx + 1, res);
                swap(arr, idx, i);
            }
        }

        private void swap(int[] arr, int i, int j) {
            if (i != j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        Out.print(sol.permute(nums));
        Out.print(sol.permute1(nums));
    }
}
