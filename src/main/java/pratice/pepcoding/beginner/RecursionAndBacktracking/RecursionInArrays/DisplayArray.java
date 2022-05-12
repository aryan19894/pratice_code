// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DisplayArray.java

package pratice.pepcoding.beginner.RecursionAndBacktracking.RecursionInArrays;

import java.io.PrintStream;
import java.util.Scanner;

public class DisplayArray
{

    public DisplayArray()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        displayArr(arr, 0);
    }

    public static void displayArr(int arr[], int idx)
    {
        if(idx == arr.length)
        {
            return;
        } else
        {
            System.out.println(arr[idx]);
            displayArr(arr, idx + 1);
            return;
        }
    }
}
