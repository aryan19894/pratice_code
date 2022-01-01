// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TowerOfHanoi.java

package com.pepcoding.beginner.RecursionAndBacktracking.IntroductiontToRecursion;

import java.io.PrintStream;
import java.util.Scanner;

public class TowerOfHanoi
{

    public TowerOfHanoi()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = scn.nextInt();
        int y = scn.nextInt();
        int z = scn.nextInt();
        toh(n, x, y, z);
    }

    public static void toh(int n, int t1id, int t2id, int t3id)
    {
        if(n == 0)
        {
            return;
        } else
        {
            toh(n - 1, t1id, t3id, t2id);
            System.out.println((new StringBuilder()).append(n).append("[").append(t1id).append(" -> ").append(t1id).append("]").toString());
            toh(n - 1, t3id, t2id, t1id);
            return;
        }
    }
}
