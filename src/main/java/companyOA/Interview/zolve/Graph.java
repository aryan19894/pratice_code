package companyOA.Interview.zolve;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//A->B,C,D
//C->E,F,G,D
//E->A

class Graph {
    private final int v;
    private final List<List<String>> adj;

    public Graph(int v) {
        this.v = v;
        adj = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("A", "D");
        g.addEdge("C", "E");
        g.addEdge("C", "F");
        g.addEdge("C", "G");
        g.addEdge("C", "D");
        //g.addEdge("E", "A");

        boolean res = g.isCyclic();
        System.out.println(res);
    }

    private void addEdge(String source, String desc) {
        int idx = source.toCharArray()[0] - 'A';
        adj.get(idx).add(desc);
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (isCyclicUtil(i, visited, recStack))
                return true;
        }

        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if (recStack[i])
            return true;
        if (visited[i])
            return true;

        visited[i] = true;
        recStack[i] = true;

        List<String> child = adj.get(i); // [B C D] -> [E F G D]
        for (String c : child) {
            int idx = c.toCharArray()[0] - 'A';
            if (isCyclicUtil(idx, visited, recStack)) {
                return true;
            }
        }

        recStack[i] = false;

        return false;
    }
}