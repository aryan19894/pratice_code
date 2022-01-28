package com.striver.DSAExperience.T1Array;

import com.common.Obj;
import java.util.Arrays;

public class SortColors_Medium_75 {

    static class Solution {

        Solution() {
        }

        public void mergeSort(int nums[], int l, int r) {
            if (l < r) {
                int m = l + (r - l) / 2;
                mergeSort(nums, l, m);
                mergeSort(nums, m + 1, r);
                merge(nums, l, m, r);
            }
        }

        private void merge(int nums[], int l, int m, int r) {
            int n1 = (m - l) + 1;
            int n2 = r - m;
            int L[] = new int[n1];
            int R[] = new int[n2];
            int i;
            for (i = 0; i < n1; i++)
                L[i] = nums[l + i];

            for (i = 0; i < n2; i++)
                R[i] = nums[m + 1 + i];

            i = 0;
            int j = 0;
            int k;
            for (k = l; i < n1 && j < n2; k++)
                if (L[i] <= R[j])
                    nums[k] = L[i++];
                else
                    nums[k] = R[j++];

            while (i < n1)
                nums[k++] = L[i++];
            while (j < n2)
                nums[k++] = R[j++];
        }

        public void sortColors1(int nums[]) {
            mergeSort(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
        }

        public void sortColors2(int nums[]) {
            int n = nums.length;
            int count[] = new int[3];
            Arrays.fill(count, 0);
            int i;
            for (i = 0; i < n; i++)
                count[nums[i]]++;

            i = 0;
            int j = 0;
            int k = 0;
            while (i < n)
                if (j < count[k]) {
                    nums[i++] = k;
                    j++;
                } else {
                    j = 0;
                    k++;
                }
        }

        public void sortColors3(int nums[]) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            int m = 0;
            do {
                if (m > r)
                    break;
                if (nums[m] == 0) {
                    Obj.swap(nums, l, m);
                    l++;
                    m++;
                } else if (nums[m] == 1)
                    m++;
                else if (nums[m] == 2) {
                    Obj.swap(nums, m, r);
                    r--;
                }
            } while (true);
        }
    }

    public static void main(String args[]) {
        int nums[] = {
                0, 1, 1, 0, 1, 2, 1, 2, 0, 0,
                0, 1
        };
        Solution sol = new Solution();
        sol.sortColors3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
