package com.striver.DSAExperience.Day13StackQueue;

class Queue {
    int front, rear;
    int arr[] = new int[100005];
    int count, n = 100005;

    Queue() {
        front = rear = count = 0;
    }

    //Function to push an element x in a queue.
    void push(int x) {
        if (count == n) return;
        arr[rear++ % n] = x;
        count++;
    }

    //Function to pop an element from queue and return that element.
    int pop() {

        if (count == 0) return -1;
        count--;
        return arr[front++ % n];
    }

    int top() {
        if (count == 0) return -1;
        return arr[front % n];
    }
}

public class ImplementQueueUsingArray_Easy {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2};
        Queue q = new Queue();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                q.push(nums[++i]);
            } else
                System.out.println(q.pop());
        }
    }
}
