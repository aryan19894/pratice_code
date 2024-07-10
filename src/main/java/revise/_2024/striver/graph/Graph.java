package revise._2024.striver.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    boolean isDirected = false;
    boolean isWeighted = true;
    boolean isZeroIdx = true;

    int size;
    List<Pair>[] adjList;

    public Graph(int size, boolean isZeroIdx, boolean isDirected, boolean isWeighted) {
        this.size = isZeroIdx ? size : size + 1;
        this.isZeroIdx = isZeroIdx;
        adjList = new List[this.size];
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;

        initialize();
    }

    private void initialize() {
        int i = isZeroIdx ? 0 : 1;
        for (; i < size; i++)
            adjList[i] = new ArrayList<>();
    }

    public void addEdges(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList[u].add(new Pair(v, w));
            if (isDirected)
                adjList[v].add(new Pair(u, w));
        }
    }

    public List<Pair> get(int node) {
        return this.adjList[node];
    }

    public void addEdge(int u, int v, int w) {
        adjList[u].add(new Pair(v, w));
        if (isDirected)
            adjList[v].add(new Pair(u, w));
    }

    public void addEdge(int u, int v) {
        adjList[u].add(new Pair(v, -1));
        if (isDirected)
            adjList[v].add(new Pair(u, -1));
    }
}
