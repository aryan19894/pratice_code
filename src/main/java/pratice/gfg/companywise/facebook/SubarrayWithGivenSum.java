package pratice.gfg.companywise.facebook;

import pratice.common.Out;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
    // [Better] O(n2) - 2 loops
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int currSum = arr[i];
            if (currSum == s) {
                result.add(i + 1);
                result.add(i + 1);
                return result;
            }
            for (int j = i + 1; j < n - 1; j++) {
                currSum += arr[j];
                if (currSum == s) {
                    result.add(i + 1);
                    result.add(j + 1);
                    return result;
                }
                if (s - currSum == arr[j + 1]) {
                    result.add(i + 1);
                    result.add(j + 2);
                    return result;
                }
                if (s - currSum < arr[j + 1])
                    break;
            }
        }
        result.add(-1);
        return result;
    }

    // [Optimal] O(n) - two pointer technique
    static ArrayList<Integer> subarraySum2(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int low = 0, high = 0;
        int sum = arr[0];
        while (low < n && high < n) {
            if (sum == s) {
                result.add(low + 1);
                result.add(high + 1);
                return result;
            } else if (sum < s) {
                high++;
                if (high >= n) break;
                sum += arr[high];
            } else {
                sum -= arr[low];
                low++;
                if (low >= n) break;
            }
        }
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {142, 112, 54, 69, 148, 45, 63, 158, 38, 60, 124, 142, 130, 179, 117, 36, 191, 43, 89, 107, 41,
                143, 65, 49, 47, 6, 91, 130, 171, 151, 7, 102, 194, 149, 30, 24, 85, 155, 157, 41, 167, 177, 132, 109,
                145, 40, 27, 124, 138, 139, 119, 83, 130, 142, 34, 116, 40, 59, 105, 131, 178, 107, 74, 187, 22, 146,
                125, 73, 71, 30, 178, 174, 98, 113};
        int n = 74;
        int s = 665;
        //Out.print(subarraySum(arr, n, s));
        Out.print(subarraySum2(arr, n, s));
    }
}
