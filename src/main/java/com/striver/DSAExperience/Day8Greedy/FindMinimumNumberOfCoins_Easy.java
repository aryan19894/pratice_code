package com.striver.DSAExperience.Day8Greedy;

public class FindMinimumNumberOfCoins_Easy {
    public static void main(String[] args) {
        findMinCoins(49);
    }

    // [Optimal] O(V), O(V) - V is for denomination of coins.
    // greddy is work for this because if we add any two numbers which is lesser than just next of them.

    // Note: The above approach may not work for all denominations. For example, it doesn’t work for
    // denominations {9, 6, 5, 1} and V = 11. The above approach would print 9, 1 and 1.
    // But we can use 2 denominations 5 and 6. Note: The above approach may not work for all denominations.
    // For example, it doesn’t work for denominations {9, 6, 5, 1} and V = 11.
    // The above approach would print 9, 1 and 1. But we can use 2 denominations 5 and 6.
    private static void findMinCoins(int amount) {
        int[] notes = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

        for (int i = notes.length - 1; i >= 0; i--) {
            if (amount == 0)
                return;

            if (amount > notes[i]) {
                amount -= notes[i];
                System.out.print(notes[i] + " ");
                i++;
            }
        }
    }
}
