package revise._2024.striver.graph.MST_DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (parent.get(node) == node) return node;

        parent.set(node, findParent(parent.get(node)));
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int up = findParent(u);
        int vp = findParent(v);
        if (up == vp) return;

        if (rank.get(up) < rank.get(vp)) parent.set(up, vp);
        else if (rank.get(up) > rank.get(vp)) parent.set(vp, up);
        else {
            parent.set(vp, up);
            rank.set(up, rank.get(up) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int up = findParent(u);
        int vp = findParent(v);
        if (up == vp) return;

        if (size.get(up) < size.get(vp)) {
            parent.set(up, vp);
            size.set(vp, size.get(vp) + size.get(up));
        } else {
            parent.set(vp, up);
            size.set(up, size.get(up) + size.get(vp));
        }
    }

    public boolean isSameComponents(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(7);
        set.unionByRank(1, 2);
        set.unionByRank(2, 3);
        set.unionByRank(4, 5);
        set.unionByRank(6, 7);
        set.unionByRank(5, 6);
        System.out.println(set.isSameComponents(3, 7));
        set.unionByRank(3, 7);
        System.out.println(set.isSameComponents(3, 7));

        DisjointSet setBySize = new DisjointSet(7);
        setBySize.unionBySize(1, 2);
        setBySize.unionBySize(2, 3);
        setBySize.unionBySize(4, 5);
        setBySize.unionBySize(6, 7);
        setBySize.unionBySize(5, 6);
        System.out.println(setBySize.isSameComponents(3, 7));
        setBySize.unionBySize(3, 7);
        System.out.println(setBySize.isSameComponents(3, 7));
    }
}
