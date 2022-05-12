// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetMazePathWithJumps.java

package pratice.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class GetMazePathWithJumps
{

    public GetMazePathWithJumps()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        getMazePaths(1, 1, n, m, "");
    }

    public static void getMazePaths(int sr, int sc, int dr, int dc, String psf)
    {
        if(sr == dr && sc == dc)
            System.out.println(psf);
        for(int i = 1; i <= dc - sc; i++)
            getMazePaths(sr, sc + i, dr, dc, (new StringBuilder()).append(psf).append("h").append(i).toString());

        for(int i = 1; i <= dr - sr; i++)
            getMazePaths(sr + i, sc, dr, dc, (new StringBuilder()).append(psf).append("v").append(i).toString());

        for(int i = 1; i <= dr - sr && i <= dc - sc; i++)
            getMazePaths(sr + i, sc + i, dr, dc, (new StringBuilder()).append(psf).append("d").append(i).toString());

    }
}
