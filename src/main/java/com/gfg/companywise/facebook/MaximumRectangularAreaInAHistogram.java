package com.gfg.companywise.facebook;

import com.common.Out;

import java.util.Stack;

public class MaximumRectangularAreaInAHistogram {
    // [Better] TC: O(5n) = O(n): O(n) + O(n) - left and right array
    public static long getMaxArea(long hist[], long len) {
        int n = (int) len;
        int[] left = new int[(int) n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && hist[st.peek()] >= hist[i])
                st.pop();
            left[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }
        int[] right = new int[(int) n];
        st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && hist[st.peek()] >= hist[i])
                st.pop();
            right[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = Math.max(max, (right[i] - left[i] + 1) * hist[i]);

        return max;
    }

    // [Optimal] TC: O(2n) = O(n): O(n) + O(n) - iteration of original array and throughout stack processing,
    public static long getMaxArea2(long hist[], long len) {
        int n = (int) len;
        Stack<Integer> st = new Stack<>();
        long max = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || hist[st.peek()] >= hist[i])) {
                long height = hist[st.pop()];
                long width = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max, height * width);
            }
            st.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        long hist[] = {6, 2, 5, 4, 5, 1, 6};
        long n = 0;
        //Out.print(getMaxArea(hist, hist.length));
        Out.print(getMaxArea2(hist, hist.length));
    }
}
