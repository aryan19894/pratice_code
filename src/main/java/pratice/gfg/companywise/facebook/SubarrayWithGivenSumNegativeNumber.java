package pratice.gfg.companywise.facebook;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarrayWithGivenSumNegativeNumber {
    // [Better] O(n), O(n) - Using hashmap to store the sum upto that index
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0, start = 0, end = -1;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            int remain = currSum - s;
            if (remain == 0) {
                start = 0;
                end = i;
                break;
            }

            if (map.containsKey(remain)) {
                start = map.get(remain) + 1;
                end = i;
            }

            map.put(currSum, i);
        }

        if (end == -1) result.add(-1);
        else {
            result.add(start);
            result.add(end);
        }
        return result;
    }

    // [Optimal] O(n), O(1) - using single loop and convert the negative number to positive
    static ArrayList<Integer> subarraySum2(int[] arr, int n, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int minEle = Integer.MAX_VALUE;

        for (int a : arr)
            minEle = Math.min(minEle, a);

        int currSum = arr[0] + Math.abs(minEle);
        int start = 0;
        int targetSum = sum;

        for (int i = 1; i <= n; i++) {
            int num = currSum - (i - start) * Math.abs(minEle);

            while (num > targetSum && start < i) {
                currSum -= arr[start] + Math.abs(minEle);
                start++;
            }

            if (num == targetSum) {
                result.add(start);
                result.add(i - 1);
                return result;
            }

            if (i < n)
                currSum += arr[i] + Math.abs(minEle);
        }

        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, -12, 2, -2, -20, 10};
        int s = -10;
        //Out.print(subarraySum(arr, arr.length, s));
        Out.print(subarraySum2(arr, arr.length, s));
    }
}
