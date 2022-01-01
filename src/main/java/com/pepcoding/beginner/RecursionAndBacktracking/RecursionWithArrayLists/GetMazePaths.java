// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetMazePaths.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

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
        System.out.println(getMazePaths(1, 1, n, m));
    }

    public static ArrayList getMazePaths(int sr, int sc, int dr, int dc)
    {
        if(sr == dr && sc == dc)
        {
            ArrayList bref = new ArrayList();
            bref.add("");
            return bref;
        }
        ArrayList p1 = new ArrayList();
        ArrayList p2 = new ArrayList();
        if(sc < dc)
            p1 = getMazePaths(sr, sc + 1, dr, dc);
        if(sr < dr)
            p2 = getMazePaths(sr + 1, sc, dr, dc);
        ArrayList mres = new ArrayList();
        String r;
        for(Iterator iterator = p1.iterator(); iterator.hasNext(); mres.add((new StringBuilder()).append("h").append(r).toString()))
            r = (String)iterator.next();

        String r;
        for(Iterator iterator1 = p2.iterator(); iterator1.hasNext(); mres.add((new StringBuilder()).append("v").append(r).toString()))
            r = (String)iterator1.next();

        return mres;
    }
}
