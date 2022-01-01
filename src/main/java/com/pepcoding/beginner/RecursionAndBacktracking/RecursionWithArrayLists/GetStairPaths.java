// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetStairPaths.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

public class GetStairPaths
{

    public GetStairPaths()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList getStairPaths(int n)
    {
        if(n == 0)
        {
            ArrayList bref = new ArrayList();
            bref.add("");
            return bref;
        }
        if(n < 0)
            return new ArrayList();
        ArrayList p1 = getStairPaths(n - 1);
        ArrayList p2 = getStairPaths(n - 2);
        ArrayList p3 = getStairPaths(n - 3);
        ArrayList mres = new ArrayList();
        String r;
        for(Iterator iterator = p1.iterator(); iterator.hasNext(); mres.add((new StringBuilder()).append(1).append(r).toString()))
            r = (String)iterator.next();

        String r;
        for(Iterator iterator1 = p2.iterator(); iterator1.hasNext(); mres.add((new StringBuilder()).append(2).append(r).toString()))
            r = (String)iterator1.next();

        String r;
        for(Iterator iterator2 = p3.iterator(); iterator2.hasNext(); mres.add((new StringBuilder()).append(3).append(r).toString()))
            r = (String)iterator2.next();

        return mres;
    }
}
