// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetMazePaths.java

package revise._2022.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

public class GetMazePaths
{

    public GetMazePaths()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(getMazePaths(1, 1, n, m));
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        ArrayList p1;
        if (sr == dr && sc == dc) {
            p1 = new ArrayList();
            p1.add("");
            return p1;
        } else {
            p1 = new ArrayList();
            ArrayList<String> p2 = new ArrayList();
            if (sc < dc) {
                p1 = getMazePaths(sr, sc + 1, dr, dc);
            }

            if (sr < dr) {
                p2 = getMazePaths(sr + 1, sc, dr, dc);
            }

            ArrayList<String> mres = new ArrayList();
            Iterator var7 = p1.iterator();

            String r;
            while (var7.hasNext()) {
                r = (String) var7.next();
                mres.add("h" + r);
            }

            var7 = p2.iterator();

            while (var7.hasNext()) {
                r = (String) var7.next();
                mres.add("v" + r);
            }

            return mres;
        }
    }
}
