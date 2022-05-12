package pratice.striver.DSAExperience.T13Graph;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule_DFS_medium_207 {
    static class Solution {
        // 0-based indexing
        // [Optimal] TC: O(N+E) - Where N is the time taken for visiting N nodes and
        // E is for travelling through adjacent nodes.
        // SC: O(N+E) + O(N) + O(N) - Space for adjacency list, visited array, queue data structure
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<Integer>> hash = new HashMap<>();
            boolean[] visited = new boolean[numCourses];

            for (int[] pre : prerequisites) {
                hash.putIfAbsent(pre[0], new ArrayList<>());
                hash.get(pre[0]).add(pre[1]);
            }

            for (int i = 0; i < numCourses; i++) {
                if (!dfs(hash, visited, i)) return false;
            }
            return true;
        }

        private boolean dfs(HashMap<Integer, List<Integer>> hash, boolean[] visited, int idx) {
            if (visited[idx]) return false;
            if (hash.get(idx).isEmpty()) return true;

            visited[idx] = true;
            for (int child : hash.getOrDefault(idx, new ArrayList<>())) {
                if (!dfs(hash, visited, child)) return false;
            }
            visited[idx] = false;
            hash.put(idx, new ArrayList<>());
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        Out.print(sol.canFinish(numCourses, prerequisites));
    }
}
