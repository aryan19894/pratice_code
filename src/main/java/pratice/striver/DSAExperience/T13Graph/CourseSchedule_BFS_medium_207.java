package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;

import java.util.*;

public class CourseSchedule_BFS_medium_207 {
    static class Solution {
        // 0-based indexing
        // [Optimal] TC: O(N+E) - Where N is the time taken for visiting N nodes and
        // E is for travelling through adjacent nodes.
        // SC: O(N+E) + O(N) + O(N) - Space for adjacency list, visited array, queue data structure
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<Integer>> hash = new HashMap<>();
            int[] visited = new int[numCourses];

            for (int i = 0; i < prerequisites.length; i++) {
                int val = prerequisites[i][0];
                int prev = prerequisites[i][1];

                hash.putIfAbsent(prev, new ArrayList<>());
                hash.get(prev).add(val);

                visited[val]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 0)
                    q.add(i);
            }

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int child : hash.getOrDefault(node, new ArrayList<>())) {
                    visited[child]--;
                    if (visited[child] == 0)
                        q.add(child);
                }
            }

            for (int i = 0; i < numCourses; i++) {
                if (visited[i] != 0) return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int numCourses = 2;
        //int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        int[][] prerequisites = {{1, 0}};
        Out.print(sol.canFinish(numCourses, prerequisites));
    }
}
