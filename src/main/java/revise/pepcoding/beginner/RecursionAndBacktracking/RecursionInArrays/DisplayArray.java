// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DisplayArray.java

package revise.pepcoding.beginner.RecursionAndBacktracking.RecursionInArrays;

import java.io.PrintStream;
import java.util.Scanner;

public class DisplayArray
{

    public DisplayArray()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        displayArr(a, 0);
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
