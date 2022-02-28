package com.striver.DSAExperience.T7RecursionBacktracking.theory;

public class Factorial {
    //recursive - functional
    // [Recursive] O(N), O(N) - n iteration
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
