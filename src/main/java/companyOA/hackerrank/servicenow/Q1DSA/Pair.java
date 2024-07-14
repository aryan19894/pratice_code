package companyOA.hackerrank.servicenow.Q1DSA;

import org.jetbrains.annotations.NotNull;

public class Pair implements Comparable<Pair>{
    int node;
    int stress;

    public Pair(int node, int stress) {
        this.node = node;
        this.stress = stress;
    }

    @Override
    public int compareTo(@NotNull Pair other) {
        return Integer.compare(this.stress, other.stress);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "node=" + node +
                ", stress=" + stress +
                '}';
    }
}
