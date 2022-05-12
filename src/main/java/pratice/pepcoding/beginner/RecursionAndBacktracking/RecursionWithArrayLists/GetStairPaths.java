// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetStairPaths.java

package pratice.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

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

    public static ArrayList<String> getStairPaths(int n) {
        ArrayList p1;
        if (n == 0) {
            p1 = new ArrayList();
            p1.add("");
            return p1;
        } else if (n < 0) {
            return new ArrayList();
        } else {
            p1 = getStairPaths(n - 1);
            ArrayList<String> p2 = getStairPaths(n - 2);
            ArrayList<String> p3 = getStairPaths(n - 3);
            ArrayList<String> mres = new ArrayList();
            Iterator var5 = p1.iterator();

            String r;
            while(var5.hasNext()) {
                r = (String)var5.next();
                mres.add(1 + r);
            }

            var5 = p2.iterator();

            while(var5.hasNext()) {
                r = (String)var5.next();
                mres.add(2 + r);
            }

            var5 = p3.iterator();

            while(var5.hasNext()) {
                r = (String)var5.next();
                mres.add(3 + r);
            }

            return mres;
        }
    }
}
