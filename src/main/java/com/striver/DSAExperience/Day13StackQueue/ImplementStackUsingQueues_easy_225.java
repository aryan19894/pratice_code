package com.striver.DSAExperience.Day13StackQueue;/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

// [Better] TC: O(n), SC: O(2n) - we use extra queue. i.e. 2 queues
class Stack1 {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public Stack1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty())
            q2.add(q1.remove());
        while (!q2.isEmpty())
            q1.add(q2.remove());
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

// [Optimal] TC: O(n), SC: O(n) - we use only queue and perform reassignment of its own element
class Stack2 {
    private Queue<Integer> queue;

    public Stack2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

public class ImplementStackUsingQueues_easy_225 {
    public static void main(String[] args) {
        Stack1 myStack = new Stack1();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.top());
        System.out.println(myStack.empty());

    }
}
/**
 * Your Stack1 object will be instantiated and called as such:
 * Stack1 obj = new Stack1();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

