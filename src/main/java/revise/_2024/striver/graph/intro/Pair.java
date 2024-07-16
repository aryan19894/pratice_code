package revise._2024.striver.graph.intro;

public class Pair {
    public int node;
    public int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "node=" + node +
                ", weight=" + weight +
                '}';
    }
}
