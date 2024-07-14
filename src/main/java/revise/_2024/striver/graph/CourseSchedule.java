package revise._2024.striver.graph;

import common.Out;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        int[] inDegree = new int[n];
        for (ArrayList<Integer> pre : prerequisites) {
            int ele = pre.get(0);
            adj.get(pre.get(1)).add(ele);
            inDegree[ele]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        int[] res = new int[n];
        int i = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            res[i++] = curr;
            for (int neigh : adj.get(curr)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0)
                    q.offer(neigh);
            }
        }

        if (i == n) return res;
        return new int[]{};
    }

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] arr = {{1, 0},
                {2, 0},
                {3, 1},
                {3, 2}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
            for (int ele : arr[i])
                adj.get(i).add(ele);
        }

        Out.print(findOrder(n, m, adj));
    }
}
