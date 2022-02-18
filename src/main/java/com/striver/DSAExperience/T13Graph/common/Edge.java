package com.striver.DSAExperience.T13Graph.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Edge implements Comparator<Edge> {
    private int u;
    private int v;
    private int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public Edge(int _v, int _weight) {
        v = _v;
        weight = _weight;
    }

    public Edge() {
    }

    public int u() {
        return u;
    }

    public int v() {
        return v;
    }

    public int weight() {
        return weight;
    }

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        Edge e = (Edge) o;
        if (this.u == e.u && this.v == e.v && this.weight == e.weight)
            return true;
        if (this.u == e.v && this.v == e.u && this.weight == e.weight)
            return true;
        if (this == o)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "u=" + u +
                ", v=" + v +
                ", weight=" + weight +
                '}';
    }

    public static ArrayList<Edge> convert(ArrayList<ArrayList<ArrayList<Integer>>> graph) {
        Set<Edge> edges = new HashSet<>();
        int i = 0;
        for (ArrayList<ArrayList<Integer>> g : graph) {
            for (ArrayList<Integer> gs : g) {
                edges.add(new Edge(i, gs.get(0), gs.get(1)));
            }
            i++;
        }
        return new ArrayList<Edge>(edges);
    }

    public static int[] toArray(int V, ArrayList<Edge> edges) {
        int[] graph = new int[V];
        for (Edge e : edges) {
            graph[e.v] = e.u;
        }
        return graph;
    }
}
