// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FloodFill.java

package revise.pepcoding.beginner.RecursionAndBacktracking.RecursionBacktracking;

import java.io.PrintStream;
import java.util.Scanner;

public class FloodFill
{

    public FloodFill()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                arr[i][j] = scn.nextInt();

        }

        boolean visited[][] = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }

    public static void floodfill(int maze[][], int r, int c, String psf, boolean visited[][])
    {
        if(r < 0 || c < 0 || r == maze.length || c == maze[0].length || maze[r][c] == 1 || visited[r][c])
            return;
        if(r == maze.length - 1 && c == maze[0].length - 1)
        {
            System.out.println(psf);
            return;
        } else
        {
            visited[r][c] = true;
            floodfill(maze, r - 1, c, (new StringBuilder()).append(psf).append("t").toString(), visited);
            floodfill(maze, r, c - 1, (new StringBuilder()).append(psf).append("l").toString(), visited);
            floodfill(maze, r + 1, c, (new StringBuilder()).append(psf).append("d").toString(), visited);
            floodfill(maze, r, c + 1, (new StringBuilder()).append(psf).append("r").toString(), visited);
            visited[r][c] = false;
            return;
        }
    }
}
