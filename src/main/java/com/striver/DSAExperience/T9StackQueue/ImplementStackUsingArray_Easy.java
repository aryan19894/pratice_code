package com.striver.DSAExperience.T9StackQueue;

class Stack {
    int top;
    int arr[] = new int[1000];

    Stack() {
        top = -1;
    }

    //Function to push an integer into the stack.
    void push(int a) {
        arr[++top] = a;
    }

    //Function to remove an item from top of the stack.
    int pop() {
        if (top == -1) return -1;
        return arr[top--];
    }

    int top() {
        return top;
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class ImplementStackUsingArray_Easy {
}
