package companyOA.hackerrank.servicenow.Q1DSA;

import pratice.common.Out;

import java.util.*;

public class MinimumStressLevel {

    private static int leastStressfulPath(int n, int m, List<Integer> graphFrom, List<Integer> graphTo, List<Integer> graphWeight, int src, int target) {
        List<Pair>[] graph = new List[n + 1];
        for (int i = 1; i < n + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = graphFrom.get(i);
            int v = graphTo.get(i);
            int w = graphWeight.get(i);

            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }

        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];
        Arrays.fill(dist, Integer.MIN_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            for (Pair p : graph[curr.node]) {
                int maxStress = Math.max(curr.stress, p.stress);
                if (dist[p.node] == Integer.MIN_VALUE && dist[p.node] < maxStress) {
                    dist[p.node] = maxStress;
                    pq.add(new Pair(p.node, maxStress));
                    path[p.node] = curr.node;
                }
            }
        }

        printPathPath(path, target);
        return dist[target] == Integer.MIN_VALUE ? -1 : dist[target];
    }

    private static void printPathPath(int[] path, int n) {
        List<Integer> result = new ArrayList<>();

        do {
            result.add(n);
            n = path[n];
        } while (n != path[n]);

        Collections.reverse(result);
        Out.print(result);
    }

    /* TestCase 1: */
    /*
     * @[INPUT]
        n = 12 (noOfNodes)
        m = 22 (noOfEdges)
        1 2 2
        1 6 3
        1 10 1
        2 3 4
        3 4 5
        3 7 2
        3 12 4
        4 5 1
        4 8 2
        5 12 9
        5 9 13
        6 10 2
        6 7 3
        6 8 5
        7 8 2
        7 12 4
        7 11 3
        8 9 9
        9 12 1
        10 7 3
        11 8 2
        11 9 2
        source = 1
        target = 12
    *
    * @[OUTPUT] : minStress: 4
    * Path: [1 10 7 12]
    * */

    /* TestCase 2: */
    /*
     * @[INPUT]
        n = 5 (noOfNodes)
        m = 9 (noOfEdges)
        1 2 43
        2 3 92
        2 4 62
        2 5 100
        1 3 88
        4 5 80
        1 5 3
        3 4 100
        1 4 100
        source = 1
        target = 2
    *
    * @[OUTPUT] : minStress: 43
    * Path: [1 12]
    * */

    /* TestCase 3: */
    /*
     * @[INPUT]
        n = 5 (noOfNodes)
        m = 6 (noOfEdges)
        1 2 10
        2 3 5
        1 4 3
        4 3 2
        1 5 4
        5 3 6
        source = 1
        target = 3
    *
    * @[OUTPUT] : minStress: 3
    * Path: [1 4 3]
    * */

    /* TestCase 4: */
    /*
     * @[INPUT]
        n = 4 (noOfNodes)
        m = 4 (noOfEdges)
        1 2 100
        1 4 10
        4 3 20
        2 3 200
        source = 1
        target = 3
    *
    * @[OUTPUT] : minStress: 20
    * Path: [1 4 3]
    * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer> graphFrom = new ArrayList<>();
        List<Integer> graphTo = new ArrayList<>();
        List<Integer> graphWeight = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            graphFrom.add(in.nextInt());
            graphTo.add(in.nextInt());
            graphWeight.add(in.nextInt());
        }
        int source = in.nextInt();
        int destination = in.nextInt();

        System.out.println(leastStressfulPath(n, m, graphFrom, graphTo, graphWeight, source, destination));
    }

}
