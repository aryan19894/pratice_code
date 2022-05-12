// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Java1DArray.java

package pratice.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.Scanner;

public class Java1DArray
{

    public Java1DArray()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scan.nextInt();

        scan.close();
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i]);

    }
}
