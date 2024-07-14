package revise._2024.striver.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    static String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            String str1 = dict[i];
            String str2 = dict[i + 1];
            int minLength = Math.min(str1.length(), str2.length());
            for (int k = 0; k < minLength; k++) {
                if (str1.charAt(k) == str2.charAt(k)) continue;
                adj.get(str1.charAt(k) - 'a').add(str2.charAt(k) - 'a');
                break;
            }
        }

        List<Integer> topo = topoSort(K, adj);
        StringBuffer sb = new StringBuffer();
        for (int ele : topo)
            sb.append((char) (ele + 'a'));

        return sb.toString();
    }

    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        for (List<Integer> ele : adj) {
            for (int e : ele)
                inDegree[e]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        List<Integer> topo = new ArrayList<>();
        int i = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            topo.add(curr);
            for (int neigh : adj.get(curr)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0)
                    q.offer(neigh);
            }
        }
        return topo;
    }

    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(dict, N, K));
    }
}
