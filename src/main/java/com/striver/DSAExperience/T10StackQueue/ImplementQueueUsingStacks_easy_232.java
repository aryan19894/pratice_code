package com.striver.DSAExperience.T10StackQueue;/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

import java.util.Stack;

// @lc code=start
// [Better] TC: O(n), SC: O(2n) - push() is O(n)
class MyQueue1 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s1.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

// [Optimal] TC: O(n) or O(1) Amortized, SC: O(2n) - push() -O(1)
class MyQueue2 {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue2() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty())
            while (!input.isEmpty())
                output.push(input.pop());

        return output.pop();
    }

    public int peek() {
        if (output.isEmpty())
            while (!input.isEmpty())
                output.push(input.pop());

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty();
    }
}

public class ImplementQueueUsingStacks_easy_232 {
    public static void main(String[] args) {
        MyQueue2 q2 = new MyQueue2();
        q2.push(1);
        q2.pop();
        q2.empty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

