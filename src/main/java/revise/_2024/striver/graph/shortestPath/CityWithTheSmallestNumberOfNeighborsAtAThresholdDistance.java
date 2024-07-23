package revise._2024.striver.graph.shortestPath;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    private static final int MAX = Integer.MAX_VALUE;

    //1.03
    static int findCity(int n, int m, int[][] edges, int thresh) {
        int[][] dist = new int[n][n];
        for (int[] g : dist)
            Arrays.fill(g, MAX);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int i = 0; i < n; i++) dist[i][i] = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == MAX || dist[k][j] == MAX) continue;
                    dist[i][j] = Integer.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int city = -1;
        int cityCount = n;
        for (int c = 0; c < n; c++) {
            int count = 0;
            for (int ac = 0; ac < n; ac++) {
                if (dist[c][ac] <= thresh)
                    count++;
            }
            if (count <= cityCount) {
                cityCount = count;
                city = c;
            }
        }
        return city;
    }

    //1.15
    static int findCityByMap(int n, int m, int[][] edges, int thresh) {
        int[][] dist = new int[n][n];
        for (int[] g : dist)
            Arrays.fill(g, MAX);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int i = 0; i < n; i++) dist[i][i] = 0;

        Set<Integer>[] city = new Set[n];
        for (int i = 0; i < n; i++)
            city[i] = new HashSet();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || dist[i][k] == MAX || dist[k][j] == MAX) continue;
                    dist[i][j] = Integer.min(dist[i][j], dist[i][k] + dist[k][j]);
                    if (dist[i][j] <= thresh) city[i].add(j);
                }
            }
        }

        int minCity = MAX;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (city[i].size() <= minCity) {
                minCity = city[i].size();
                result = Math.max(result, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] edges = {{0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}};
        int distanceThreshold = 4;

        System.out.println(findCityByMap(n, m, edges, distanceThreshold));
    }
}
