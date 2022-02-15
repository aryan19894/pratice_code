package com.striver.DSAExperience.T9StackQueue;

import java.util.Stack;

class Pair {
    public int val, uptoMin;

    public Pair(int val, int uptoMin) {
        this.val = val;
        this.uptoMin = uptoMin;
    }
}

// [Optimal] TC: O(1): getMin(): Using pairs to store the value and minimum element till now.
// SC: O(2N): storing as Pair whether n element and n its minimu until that element
class MinStack {
    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(stack.peek().uptoMin, val);
        stack.push(new Pair(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().uptoMin;
    }
}

// [Optimal] TC: O(1): getMin(): using extra variable to keep track of minimum element
// PUSH: we use formula (2*val-min) while storing the value if it is smaller than min
// POP: while retrieval (2*min-val) while popping the element and returning previous min value
// SC: O(N): stack data
class MinStack2 {
    Stack<Long> stack = new Stack<>();
    Long min;

    public MinStack2() {
        min = Long.MAX_VALUE;
    }

    public void push(int value) {
        Long val = Long.valueOf(value);
        if (stack.isEmpty()) {
            min = val;
            stack.push(val);
        } else {
            if (val < min) {
                stack.push(2 * val - min);
                min = val;
            } else
                stack.push(val);
        }
    }

    public void pop() {
        if (stack.empty()) return;
        Long val = stack.pop();
        if (val < min)
            min = 2 * min - val;
    }

    public int top() {
        Long val = stack.peek();
        return (val < min ? min : val).intValue();
    }

    public int getMin() {
        return min.intValue();
    }
}

public class MinStack_easy_155 {
    public static void main(String[] args) {
        MinStack2 st = new MinStack2();
        st.push(-2);
        st.push(0);
        st.push(-3);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.top());
        System.out.println(st.getMin());
    }
}
