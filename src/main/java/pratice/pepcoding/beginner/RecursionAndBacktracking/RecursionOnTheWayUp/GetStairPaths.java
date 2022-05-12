// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetStairPaths.java

package pratice.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

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
        getStairPaths(n, "");
    }

    public static void getStairPaths(int n, String path)
    {
        if(n == 0)
        {
            System.out.println(path);
            return;
        }
        if(n < 0)
        {
            return;
        } else
        {
            getStairPaths(n - 1, (new StringBuilder()).append(path).append(1).toString());
            getStairPaths(n - 2, (new StringBuilder()).append(path).append(2).toString());
            getStairPaths(n - 3, (new StringBuilder()).append(path).append(3).toString());
            return;
        }
    }
}
