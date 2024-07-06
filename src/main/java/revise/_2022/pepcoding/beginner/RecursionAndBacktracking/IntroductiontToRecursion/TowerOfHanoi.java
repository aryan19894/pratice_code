// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TowerOfHanoi.java

package revise._2022.pepcoding.beginner.RecursionAndBacktracking.IntroductiontToRecursion;

import java.io.PrintStream;
import java.util.Scanner;

public class TowerOfHanoi
{

    public TowerOfHanoi()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1id = scn.nextInt();
        int t2id = scn.nextInt();
        int t3id = scn.nextInt();
        toh(n, t1id, t2id, t3id);
    }

    public static void toh(int n, int t1id, int t2id, int t3id)
    {
        if(n == 0)
        {
            return;
        } else
        {
            toh(n - 1, t1id, t3id, t2id);
            System.out.println((new StringBuilder()).append(n).append("[").append(t1id).append(" -> ").append(t2id).append("]").toString());
            toh(n - 1, t3id, t2id, t1id);
            return;
        }
    }
}
