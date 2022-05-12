package pratice.gfg.companywise.amazon;

import pratice.common.Out;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class MaximumOfAllSubarraysOfSizeK {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList result = new ArrayList();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peek() <= (i - k)) dq.poll();
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) dq.pollLast();
            dq.offer(i);
            if (i >= k - 1) result.add(arr[dq.peek()]);
        }
        return result;
    }

    //Using next greater element rule with stack impl
    static ArrayList<Integer> max_of_subarrays2(int arr[], int n, int k) {
        ArrayList result = new ArrayList();
        int[] maxUpto = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                maxUpto[s.peek()] = i - 1;
                s.pop();
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            maxUpto[s.peek()] = n - 1;
            s.pop();
        }

        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            while (j < i || maxUpto[j] < i + k - 1) j++;
            result.add(arr[j]);
        }

        return result;
    }

    public static void main(String[] args) {
        //int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int arr[] = {9, 2, 3, 2, 1};
        int n = 0;
        int k = 3;
        Out.print(max_of_subarrays(arr, arr.length, k));
        Out.print(max_of_subarrays2(arr, arr.length, k));
    }
}
