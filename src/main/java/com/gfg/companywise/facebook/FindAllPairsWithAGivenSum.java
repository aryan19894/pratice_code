package com.gfg.companywise.facebook;

import com.common.Out;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllPairsWithAGivenSum {
    static class pair {
        long first, second;

        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    static public class Solution {
        // [Optimal] O(n2) - checking each pair and verify it with sum
        public pair[] allPairs(long A[], long[] B, long N, long M, long X) {
            ArrayList<pair> pairs = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if ((A[i] + B[j]) == X)
                        pairs.add(new pair(A[i], B[j]));
                }
            }
            int i = 0;
            pair[] result = new pair[pairs.size()];
            for (pair p : pairs)
                result[i++] = p;
            return result;
        }

        // [Optimal] O(nlogn) - sorting both array and then find pairs
        public pair[] allPairs2(long A[], long[] B, long N, long M, long X) {
            Arrays.sort(A);
            Arrays.sort(B);

            ArrayList<pair> pairs = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = (int) M - 1; j >= 0; j--) {
                    if ((A[i] + B[j]) == X) {
                        pairs.add(new pair(A[i], B[j]));
                        break;
                    }
                }
            }
            int i = 0;
            pair[] result = new pair[pairs.size()];
            for (pair p : pairs)
                result[i++] = p;
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long A[] = {-113, 147, 65, 37, 6, -27, -73, 109, 31, -8, -102, -74, -183, -186, 131, 40, 150, -123, -111, -91,
                176, 170, -4, -165, -49, 93, -68, 142, 171, 98, -60, -196, 99, 69, 138, -20, -143, -63, 129, -158,
                -103, -30, 73, 32, 151, 136, 82, -150, -31, -37, -164, 101, -69, -62, -100, -14, 111, -97, 119, -137,
                68, -130, -127, -161, 124};
        long[] B = {-122, 102, -67, 152, -169, 48, -52, -134, 33, -91, 188, 6, -148, -109, -35, 64, 32, 75, 198, 22,
                65, -168, 185, -66, -127, -147, 145, -29, 104, 51, 93, 71, 129, 39, 76, 10, 70};
        long N = 0;
        long M = 0;
        long X = 0;
        // Out.print(sol.allPairs(A, B, A.length, B.length, 9));
        Out.print(sol.allPairs(A, B, A.length, B.length, 2));
    }
}
