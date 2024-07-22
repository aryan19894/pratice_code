package revise._2024.striver.graph.shortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    private static final int MOD = 100000;
    private static final int MAX = Integer.MAX_VALUE;

    static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        int[] dist = new int[MOD];
        Arrays.fill(dist, MAX);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int num = curr[0], steps = curr[1];
            for (int ele : arr) {
                int newVal = (num * ele) % MOD;
                if (steps + 1 < dist[newVal]) {
                    dist[newVal] = steps + 1;
                    if (newVal == end) return steps + 1;
                    q.offer(new int[]{newVal, steps + 1});
                }
            }
        }
        return dist[end] == MAX ? -1 : dist[end];
    }

    public static void main(String[] args) {
        int arr[] = {9, 12, 18, 19};
        int start = 5, end = 5;

        System.out.println(minimumMultiplications(arr, start, end));
    }
}
