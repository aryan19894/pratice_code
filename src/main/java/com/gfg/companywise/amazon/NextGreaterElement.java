package com.gfg.companywise.amazon;

import com.common.Out;

import java.util.Stack;

public class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] result = new long[n];
        Stack<Long> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        long[] arr = {6, 8, 0, 1, 3};
        int n = 0;
        Out.print(nextLargerElement(arr, arr.length));
    }
}
