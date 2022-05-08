package com.leetcode.blind75.T4Graph;

import com.common.Out;

import java.util.*;

public class CourseSchedule_medium_207 {
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<Integer>> hash = new HashMap<>();
            boolean[] visited = new boolean[numCourses];

            for (int[] pre : prerequisites) {
                hash.putIfAbsent(pre[0], new ArrayList<>());
                hash.get(pre[0]).add(pre[1]);
            }

            for (int i = 0; i < numCourses; i++)
                hash.putIfAbsent(i, new ArrayList<>());

            for (int i = 0; i < numCourses; i++)
                if (!dfs(hash, visited, i)) return false;
            return true;
        }

        private boolean dfs(HashMap<Integer, List<Integer>> hash, boolean[] visited, int i) {
            if (visited[i]) return false;
            if (hash.get(i).isEmpty()) return true;

            visited[i] = true;
            for (int child : hash.getOrDefault(i, new ArrayList<>()))
                if (!dfs(hash, visited, child)) return false;
            visited[i] = false;
            hash.put(i, new ArrayList<>());
            return true;
        }

        public boolean canFinish2(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<Integer>> hash = new HashMap<>();
            int[] inDegree = new int[numCourses];

            for (int[] pre : prerequisites) {
                hash.putIfAbsent(pre[1], new ArrayList<>());
                hash.get(pre[1]).add(pre[0]);

                inDegree[pre[0]]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0)
                    q.offer(i);
            }

            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int child : hash.getOrDefault(curr, new ArrayList<>())) {
                    inDegree[child]--;
                    if (inDegree[child] == 0)
                        q.offer(child);
                }
            }

            for (int i = 0; i < numCourses; i++)
                if (inDegree[i] != 0) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        Out.print(sol.canFinish(numCourses, prerequisites));
        Out.print(sol.canFinish2(numCourses, prerequisites));
    }
}
