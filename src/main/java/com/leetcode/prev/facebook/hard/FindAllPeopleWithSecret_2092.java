package com.leetcode.prev.facebook.hard;

import com.common.Out;

import java.util.*;

public class FindAllPeopleWithSecret_2092 {
    static class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = i;
            }
        }

        public void union(int n1, int n2) {
            n1 = find(n1);
            n2 = find(n2);
            if (n1 == n2) return;
            if (size[n1] >= size[n2]) {
                parent[n2] = n1;
                size[n1] += size[n2];
            } else {
                parent[n1] = n2;
                size[n2] += size[n1];
            }
        }

        public boolean isConnect(int n1, int n2) {
            return find(n1) == find(n2);
        }

        public void disunion(int n1, int n2) {
            parent[n1] = n1;
            parent[n2] = n2;
        }

        public void reset(int i) {
            parent[i] = i;
            size[i] = 1;
        }

        public int find(int n) {
            if (parent[n] == n) return n;
            return parent[n] = find(parent[n]);
        }
    }

    static public class Solution {
        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            HashMap<Integer, HashMap<Integer, List<Integer>>> map = new HashMap<>();
            map.computeIfAbsent(0, it -> new HashMap<>())
                    .computeIfAbsent(0, it -> new ArrayList<>())
                    .add(0);

            map.computeIfAbsent(0, it -> new HashMap<>())
                    .computeIfAbsent(0, it -> new ArrayList<>())
                    .add(firstPerson);
            for (int[] m : meetings) {
                map.computeIfAbsent(m[0], it -> new HashMap<>())
                        .computeIfAbsent(m[2], it -> new ArrayList<>())
                        .add(m[1]);
                map.computeIfAbsent(m[1], it -> new HashMap<>())
                        .computeIfAbsent(m[2], it -> new ArrayList<>())
                        .add(m[0]);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.add(new int[]{0, 0});
            pq.add(new int[]{0, firstPerson});

            Set<Integer> people = new HashSet<>();

            while (!pq.isEmpty()) {
                int[] tuple = pq.poll();
                int time = tuple[0];
                int person = tuple[1];
                if (people.contains(person)) continue;
                people.add(person);
                if (!map.containsKey(person)) continue;

                for (Map.Entry<Integer, List<Integer>> e : map.get(person).entrySet()) {
                    int nxtTime = e.getKey();
                    List<Integer> meetPeople = e.getValue();
                    if (nxtTime < time) continue;
                    for (int p : meetPeople) {
                        if (people.contains(p)) continue;
                        pq.add(new int[]{nxtTime, p});
                    }
                }
            }
            return new ArrayList<>(people);
        }

        public List<Integer> findAllPeople2(int n, int[][] meetings, int firstPerson) {
            UnionFind uf = new UnionFind(n);
            uf.union(0, firstPerson);
            TreeMap<Integer, List<int[]>> map = new TreeMap<>();

            for (int[] meet : meetings) {
                int p1 = meet[0];
                int p2 = meet[1];
                int time = meet[2];

                map.putIfAbsent(time, new ArrayList<>());
                map.get(time).add(new int[]{p1, p2});
            }

            for (int i : map.keySet()) {
                Set<Integer> set = new HashSet<>();
                for (int[] ints : map.get(i)) {
                    int p1 = ints[0];
                    int p2 = ints[1];
                    uf.union(p1, p2);
                    set.add(p1);
                    set.add(p2);
                }

                for (int j : set) {
                    if (!uf.isConnect(0, j))
                        uf.reset(j);
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (uf.isConnect(0, i))
                    res.add(i);
            }
            return res;
        }

        public List<Integer> findAllPeople3(int n, int[][] meetings, int firstPerson) {
            Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
            UnionFind uf = new UnionFind(n);
            uf.union(0, firstPerson);

            int i = 0;
            int m = meetings.length;
            while (i < m) {
                int j = i;

                while (j < m && meetings[j][2] == meetings[i][2]) {
                    uf.union(meetings[j][0], meetings[j][1]);
                    j++;
                }

                while (i < j) {
                    if (!uf.isConnect(0, meetings[i][0]))
                        uf.disunion(meetings[i][0], meetings[i][1]);
                    i++;
                }
            }
            List<Integer> res = new ArrayList<>();

            for (i = 0; i < n; i++) {
                if (uf.isConnect(0, i))
                    res.add(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 6;
        //int[][] meetings = {{1, 2, 5}, {2, 3, 8}, {1, 5, 10}};
        int[][] meetings = {{0,2,1},{1,3,1},{4,5,1}};
        int firstPerson = 1;
        Out.print(sol.findAllPeople(n, meetings, firstPerson));
        Out.print(sol.findAllPeople2(n, meetings, firstPerson));
        Out.print(sol.findAllPeople3(n, meetings, firstPerson));
    }
}
