package pratice.gfg.companywise.amazon;

import pratice.common.Out;

import java.util.Arrays;

public class PythagoreanTriplet {
    static public class Solution {
        boolean checkTriplet(int[] arr, int n) {
            for (int i = 0; i < n; i++)
                arr[i] *= arr[i];

            Arrays.sort(arr);
            for (int i = n - 1; i >= 0; i--) {
                int l = 0;
                int r = i - 1;
                while (l < r) {
                    if (arr[l] + arr[r] == arr[i]) return true;

                    if (arr[l] + arr[r] < arr[i]) l++;
                    else r--;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3, 1, 4, 6, 5};
        int n = 0;
        Out.print(sol.checkTriplet(arr, arr.length));
    }
}
