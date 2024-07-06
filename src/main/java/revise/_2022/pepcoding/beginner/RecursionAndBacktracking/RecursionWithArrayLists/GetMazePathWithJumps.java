// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetMazePathWithJumps.java

package revise._2022.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

public class GetMazePathWithJumps
{

    public GetMazePathWithJumps()
    {
    }

    public static void main(String args[])
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
        ArrayList path = new ArrayList();
        for(int i = 1; i <= dc - sc; i++)
        {
            ArrayList hpath = getMazePaths(sr, sc + i, dr, dc);
            String s;
            for(Iterator iterator = hpath.iterator(); iterator.hasNext(); path.add((new StringBuilder()).append("h").append(i).append(s).toString()))
                s = (String)iterator.next();

        }

        for(int i = 1; i <= dr - sr; i++)
        {
            ArrayList vpath = getMazePaths(sr + i, sc, dr, dc);
            String s;
            for(Iterator iterator1 = vpath.iterator(); iterator1.hasNext(); path.add((new StringBuilder()).append("v").append(i).append(s).toString()))
                s = (String)iterator1.next();

        }

        for(int i = 1; i <= dc - sc && i <= dr - sr; i++)
        {
            ArrayList dpath = getMazePaths(sr + i, sc + i, dr, dc);
            String s;
            for(Iterator iterator2 = dpath.iterator(); iterator2.hasNext(); path.add((new StringBuilder()).append("d").append(i).append(s).toString()))
                s = (String)iterator2.next();

        }

        return path;
    }
}
