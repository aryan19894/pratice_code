// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetMazePathWithJumps.java

package pratice.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

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
            ArrayList hpaths = getMazePaths(sr, sc + i, dr, dc);
            String hpath;
            for(Iterator iterator = hpaths.iterator(); iterator.hasNext(); path.add((new StringBuilder()).append("h").append(i).append(hpath).toString()))
                hpath = (String)iterator.next();

        }

        for(int i = 1; i <= dr - sr; i++)
        {
            ArrayList vpaths = getMazePaths(sr + i, sc, dr, dc);
            String vpath;
            for(Iterator iterator1 = vpaths.iterator(); iterator1.hasNext(); path.add((new StringBuilder()).append("v").append(i).append(vpath).toString()))
                vpath = (String)iterator1.next();

        }

        for(int i = 1; i <= dr - sr && i <= dc - sc; i++)
        {
            ArrayList dpaths = getMazePaths(sr + i, sc + i, dr, dc);
            String dpath;
            for(Iterator iterator2 = dpaths.iterator(); iterator2.hasNext(); path.add((new StringBuilder()).append("d").append(i).append(dpath).toString()))
                dpath = (String)iterator2.next();

        }

        return path;
    }
}
