package pratice.striver.DSAExperience.T9StackQueue;

import pratice.common.converter.Array;
import pratice.common.Out;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement_Easy {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        java.util.Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && stack.peek() >= A.get(i)) stack.pop();
            res.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(A.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        ArrayList<Integer> ans = prevSmaller(Array.toList(nums));
        Out.print(ans);
    }
}
