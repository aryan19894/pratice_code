package com.striver.DSAExperience.T7RecursionBacktracking.theory;

public class FibonacciSeries {
    //recursive - functional
    // [Recursive] O(2n) - each n element has 2 option - pick or not pick
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        System.out.print(n + " ");

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
