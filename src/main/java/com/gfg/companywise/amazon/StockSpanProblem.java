package com.gfg.companywise.amazon;

import com.common.Out;

import java.util.Stack;

public class StockSpanProblem {
    public static int[] calculateSpan(int price[], int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && price[st.peek()] <= price[i])
                st.pop();

            result[i] = st.empty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int price[] = {100, 80, 60, 70, 60, 75, 85};
        int n = 0;
        Out.print(calculateSpan(price, price.length));
    }
}
