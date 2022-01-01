package com.hackerearth.pratice.paypal;

import java.util.Scanner;
import java.util.Stack;

public class QueryOnQueues {
    public QueryOnQueues() {
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int var2 = scn.nextInt();

        while(var2-- > 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] a = new int[n];

            for(int i = 0; i < n; ++i) {
                a[i] = scn.nextInt();
            }

            int[] left = findNextGreaterElementFromLeft(a, n);
            int[] right = findNextGreaterElementFromRight(a, n);

            for(int i = 0; i < k; ++i) {
                int x = scn.nextInt();
                --x;
                System.out.println(left[x] + right[x] + 1);
            }
        }

    }

    private static int[] findNextGreaterElementFromLeft(int[] a, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack();
        st.push(0);

        for(int i = 1; i < n; ++i) {
            if (a[(Integer)st.peek()] > a[i]) {
                ans[i] = 0;
            } else {
                while(!st.isEmpty() && a[(Integer)st.peek()] < a[i]) {
                    ans[i] = Math.abs(i - (Integer)st.peek());
                    st.pop();
                }
            }

            st.push(i);
        }

        return ans;
    }

    private static int[] findNextGreaterElementFromRight(int[] a, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack();
        st.push(n - 1);

        for(int i = n - 2; i >= 0; --i) {
            if (a[(Integer)st.peek()] > a[i]) {
                ans[i] = 0;
            } else {
                while(!st.isEmpty() && a[(Integer)st.peek()] < a[i]) {
                    ans[i] = Math.abs(i - (Integer)st.peek());
                    st.pop();
                }
            }

            st.push(i);
        }

        return ans;
    }
}
