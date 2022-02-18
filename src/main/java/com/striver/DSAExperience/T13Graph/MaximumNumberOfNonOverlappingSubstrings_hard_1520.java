package com.striver.DSAExperience.T13Graph;

import com.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//SSC: StronglyConnectedComponents
public class MaximumNumberOfNonOverlappingSubstrings_hard_1520 {
    static class Solution {
        public List<String> maxNumOfSubstrings(String s) {
            int n = s.length();
            int[] mins = new int[26];
            int[] maxs = new int[26];
            Arrays.fill(mins, Integer.MAX_VALUE);
            Arrays.fill(maxs, -1);
            boolean[] exists = new boolean[26];
            int[][] prefixSum = new int[n + 1][26];

            for (int i = 0; i < n; i++) {
                System.arraycopy(prefixSum[i], 0, prefixSum[i + 1], 0, 26);
                int ch = s.charAt(i) - 'a';

                prefixSum[i + 1][ch]++;
                mins[ch] = Math.min(mins[ch], i);
                maxs[ch] = Math.max(maxs[ch], i);
                exists[ch] = true;
            }

            // build graph, using adjacency matrix
            boolean[][] graph = new boolean[26][26];
            for (int i = 0; i < 26; i++) {
                if (exists[i]) {
                    for (int j = 0; j < 26; j++) {
                        if (prefixSum[maxs[i] + 1][j] - prefixSum[mins[i]][j] > 0)
                            graph[i][j] = true;
                    }
                }
            }
            // kosaraju algorithm to find scc
            boolean[] visited = new boolean[26];
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < 26; i++) {
                if (exists[i] && !visited[i])
                    dfs(i, graph, st, visited);
            }

            int batch = 0;
            int[] batches = new int[26];
            int[] degree = new int[26];
            Arrays.fill(batches, -1);

            while (!st.isEmpty()) {
                int v = st.pop();
                if (batches[v] < 0) {
                    reverseDfs(v, graph, batches, batch, degree);
                    batch++;
                }
            }

            List<String> res = new ArrayList<>();
            for (int i = batch - 1; i >= 0; i--) {
                if (degree[i] == 0) {
                    int min = Integer.MAX_VALUE, max = -1;
                    for (int j = 0; j < 26; j++) {
                        if (batches[j] == i) {
                            min = Math.min(mins[j], min);
                            max = Math.max(maxs[j], max);
                        }
                    }
                    res.add(s.substring(min, max + 1));
                }
            }

            return res;
        }

        private void reverseDfs(int v, boolean[][] graph, int[] batches, int batch, int[] degree) {
            if (batches[v] < 0) {
                batches[v] = batch;
                for (int i = 0; i < 26; i++) {
                    if (graph[i][v]) {
                        reverseDfs(i, graph, batches, batch, degree);
                    }
                }
            } else {
                if (batches[v] != batch) {
                    degree[batches[v]] += 1;
                }
            }
        }

        private void dfs(int node, boolean[][] graph, Stack<Integer> st, boolean[] visited) {
            if (!visited[node]) {
                visited[node] = true;
                for (int i = 0; i < 26; i++) {
                    if (graph[node][i] && !visited[i]) {
                        dfs(i, graph, st, visited);
                    }
                }
                st.push(node);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "adefaddaccc";
        Out.print(sol.maxNumOfSubstrings(s));
    }
}
