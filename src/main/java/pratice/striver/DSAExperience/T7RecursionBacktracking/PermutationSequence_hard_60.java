package pratice.striver.DSAExperience.T7RecursionBacktracking;/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

import java.util.ArrayList;
import java.util.Collections;

// @lc code=start
public class PermutationSequence_hard_60 {
    static class Solution {
        // [Basic] TC: O(n!*n) + O(nlogn) - n! for generating n1 permutation and n for deep copy the number to list.
        // nlogn - sorting the generated all permutation
        // SC: O(n!*n)
        public String getPermutation1(int n, int k) {
            ArrayList<String> perms = new ArrayList<>();
            String num = "";
            for (int i = 1; i <= n; i++)
                num += i;
            permute(num, 0, n - 1, perms);
            Collections.sort(perms);
            return perms.get(k - 1);
        }

        private void permute(String num, int l, int r,
                             ArrayList<String> perms) {
            if (l == r) {
                perms.add(num);
                return;
            }

            for (int i = l; i <= r; i++) {
                num = swap(num, l, i);
                permute(num, l + 1, r, perms);
                num = swap(num, l, i);
            }
        }

        private String swap(String a, int i, int j) {
            char temp;
            char[] charArray = a.toCharArray();
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            return String.valueOf(charArray);
        }

        // [Optimal1 Recursive] TC: O(n*n) - first O(n) is for generating n numbers of combination and
        // other O(n) is for removing each element from list
        // SC: O(n)
        public String getPermutation2(int n, int k) {
            ArrayList<Integer> num = new ArrayList<>();
            for (int i = 1; i <= n; i++)
                num.add(i);
            String res = "";
            res = findKth(num, k - 1, fact(n - 1), res);
            return res;
        }

        private int fact(int n) {
            return (n == 1 || n == 0) ? 1 : n * fact(n - 1);
        }

        private String findKth(ArrayList<Integer> num, int k, int fact, String res) {
            res += num.remove(k / fact);
            k %= fact;

            if (num.isEmpty()) {
                return res;
            }

            return findKth(num, k, fact / num.size(), res);
        }

        // [Optimal2 Iterative] TC: O(n*n) - first O(n) is for generating n numbers of combination and
        // other O(n) is for removing each element from list
        // SC: O(n)
        // similar to Optimal1 except recursion  process
        public String getPermutation3(int n, int k) {
            ArrayList<Integer> num = new ArrayList<>();
            int fact = 1; //finding the factorial of n-1
            for (int i = 1; i < n; i++) {
                num.add(i);
                fact *= i;
            }
            num.add(n);
            String res = "";
            k--; //maintaing the index with 0
            while (true) {
                res += num.remove(k / fact);
                if (num.size() == 0)
                    break;

                k %= fact;
                fact /= num.size();
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getPermutation1(3, 3));
        System.out.println(sol.getPermutation2(4, 17));
        System.out.println(sol.getPermutation3(4, 17));
    }
}

// @lc code=end

