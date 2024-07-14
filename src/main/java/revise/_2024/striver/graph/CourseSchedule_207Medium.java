package revise._2024.striver.graph;

import common.Out;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207Medium {
    static boolean canFinish(int N, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        int[] inDegree = new int[N];
        for (List<Integer> pre : adj) {
            for (int ele : pre)
                inDegree[ele]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int neigh : adj.get(curr)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0)
                    q.offer(neigh);
            }
        }

        return count == N;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {0, 1}};
        Out.print(canFinish(2, arr));
    }
}
