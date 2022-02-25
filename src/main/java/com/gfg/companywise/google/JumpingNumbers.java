package com.gfg.companywise.google;

import com.common.Out;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {
    static long jumpingNums(long X) {
        if (X <= 9) return X;

        long max = Long.MIN_VALUE;
        for (int i = 1; i <= 9 && max <= X; i++)
            max = Math.max(max, bfs(X, i));
        return max;
    }

    static long bfs(long x, int i) {
        long max = Long.MIN_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node <= x) {
                max = Math.max(max, node);
                int last = node % 10;
                if (last == 0)
                    q.offer((node * 10) + (last + 1));
                else if (last == 9)
                    q.offer((node * 10) + (last - 1));
                else {
                    q.offer((node * 10) + (last + 1));
                    q.offer((node * 10) + (last - 1));
                }
            }
        }
        return max;
    }

    static long jumpingNums2(long X) {
        if (X <= 9) return X;

        long[] res = new long[1];
        res[0] = Long.MIN_VALUE;

        for (int i = 1; i <= 9 && res[0] <= X; i++)
            dfs(X, i, res);
        return res[0];
    }

    static void dfs(long x, int num, long[] res) {
        if (num <= x)
            res[0] = Math.max(res[0], num);
        else
            return;

        int lastDig = num % 10;
        if (lastDig == 0)
            dfs(x, (10 * num) + 1, res);
        else if (lastDig == 9)
            dfs(x, (10 * num) + 8, res);
        else {
            dfs(x, (10 * num) + (lastDig + 1), res);
            dfs(x, (10 * num) + (lastDig - 1), res);
        }
    }

    public static void main(String[] args) {
        long X = 50;
        Out.print(jumpingNums(X));
        Out.print(jumpingNums2(X));
    }
}
