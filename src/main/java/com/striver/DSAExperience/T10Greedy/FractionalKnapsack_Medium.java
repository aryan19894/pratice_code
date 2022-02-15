package com.striver.DSAExperience.T10Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack_Medium {
    // [Optimal] O(nlogn)+O(n), O(1) - sort basis on per unit cost and check each n every item
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new ItemC());
        double total = 0.0;
        for (Item a : arr) {
            if (W <= 0)
                break;
            total += a.weight <= W ? a.value : calcValues(a, W);
            W -= a.weight;
        }
        return total;
    }

    private static double calcValues(Item a, int w) {
        return (double) w * ((double) a.value / (double) a.weight);
    }

    public static void main(String[] args) {
        int values[] = {60, 100, 120, 200};
        int weight[] = {10, 20, 30, 10};
        System.out.println(fractionalKnapsack(50, Item.toItem(values, weight), values.length));
    }
}

class Item {
    int value, weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public static Item[] toItem(int[] val, int[] weight) {
        Item[] items = new Item[val.length];
        for (int i = 0; i < val.length; i++) {
            items[i] = new Item(val[i], weight[i]);
        }
        return items;
    }
}

class ItemC implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        double r1 = (double) o1.value / (double) o1.weight;
        double r2 = (double) o2.value / (double) o2.weight;
        if (r1 < r2) return 1;
        else if (r1 > r2) return -1;
        return 0;
    }
}