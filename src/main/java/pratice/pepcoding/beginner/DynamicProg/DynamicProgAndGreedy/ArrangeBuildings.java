// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ArrangeBuildings.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class ArrangeBuildings
{

    public ArrangeBuildings()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int building = 1;
        int spaces = 1;
        for(int i = 2; i <= n; i++)
        {
            int temp = building + spaces;
            building = spaces;
            spaces = temp;
        }

        int t = building + spaces;
        System.out.println(t * t);
    }
}
