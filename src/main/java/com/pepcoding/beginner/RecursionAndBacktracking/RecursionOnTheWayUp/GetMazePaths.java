// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetMazePaths.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class GetMazePaths
{

    public GetMazePaths()
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
        {
            System.out.println(psf);
            return;
        }
        if(sc < dc)
            getMazePaths(sr, sc + 1, dr, dc, (new StringBuilder()).append(psf).append("h").toString());
        if(sr < dr)
            getMazePaths(sr + 1, sc, dr, dc, (new StringBuilder()).append(psf).append("v").toString());
    }
}
