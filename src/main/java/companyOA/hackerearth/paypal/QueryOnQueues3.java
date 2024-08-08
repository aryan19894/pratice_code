package companyOA.hackerearth.paypal;

import java.util.Scanner;
import java.util.Stack;

public class QueryOnQueues3 {
    public QueryOnQueues3() {
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int var2 = scn.nextInt();

        while(var2-- > 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] a = new int[n + 1];

            for(int i = 1; i <= n; ++i) {
                a[i] = scn.nextInt();
            }

            int[] idx = new int[k + 1];

            for(int i = 1; i <= k; ++i) {
                idx[i] = scn.nextInt();
            }

            int[] result = solveQuery(a, idx);
            int[] var8 = result;
            int var9 = result.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                int r = var8[var10];
                System.out.println(r);
            }
        }

    }

    private static int[] solveQuery(int[] a, int[] xa) {
        int n = a.length;
        int k = xa.length;
        int[] ans = new int[k];
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack();
        st.push(0);

        int i;
        for(i = 1; i <= n; ++i) {
            while(a[(Integer)st.peek()] <= a[i]) {
                st.pop();
            }

            left[i] = (Integer)st.peek();
            st.push(i);
        }

        st.clear();
        st.push(n + 1);

        for(i = n; i > 0; --i) {
            while(a[(Integer)st.peek()] <= a[i]) {
                st.pop();
            }

            right[i] = (Integer)st.peek();
            st.push(i);
        }

        for(i = 0; i < k; ++i) {
            int x = xa[i];
            ans[i] = x - left[x] + right[x] - x - 1;
        }

        return ans;
    }
}
