package com.striver.DSAExperience.T7RecursionBacktracking.theory;

import com.common.Out;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequenceSumK {
    // [Recursive] O(2n) - each n element has 2 option - pick or not pick
    private static void subsequence(int i, int[] arr, int n, List<Integer> res, int sum, int K) {
        if (i == n) {
            if(sum == K)
                Out.print(res);
            return;
        }

        res.add(arr[i]);
        subsequence(i + 1, arr, n, res, sum + arr[i], K);
        res.remove(res.size() - 1);
        subsequence(i + 1, arr, n, res, sum, K);
    }

    //return only any1 subsequence which has sum is K
    // [Recursive] O(2n) - each n element has 2 option - pick or not pick
    private static boolean subsequence2(int i, int[] arr, int n, List<Integer> res, int sum, int K) {
        if (i == n) {
            if(sum == K){
                Out.print(res);
                return true;
            }
            return false;
        }

        res.add(arr[i]);
        if(subsequence2(i + 1, arr, n, res, sum + arr[i], K)) return true;
        res.remove(res.size() - 1);
        if(subsequence2(i + 1, arr, n, res, sum, K)) return true;

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        List<Integer> list = new ArrayList<>();
        //subsequence(0, arr, arr.length, list, 0, 2);
        subsequence2(0, arr, arr.length, list, 0, 2);
    }
}
