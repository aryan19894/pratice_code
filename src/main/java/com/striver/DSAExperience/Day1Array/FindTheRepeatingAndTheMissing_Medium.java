// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FindTheRepeatingAndTheMissing.java

package com.striver.DSAExperience.Day1Array;

import java.io.PrintStream;

public class FindTheRepeatingAndTheMissing_Medium
{

    static void printTwoElements(int arr[], int size)
    {
        int visited[] = new int[size + 1];
        for(int i = 0; i < size; i++)
            visited[arr[i]]++;

        for(int i = 1; i < size; i++)
            if(visited[i] == 0)
                System.out.println((new StringBuilder("missing: ")).append(i).toString());
            else
            if(visited[i] == 2)
                System.out.println((new StringBuilder("repeating: ")).append(i).toString());

    }

    public static void main(String args[])
    {
        int arr[] = {
            7, 3, 4, 5, 5, 6, 2
        };
        int n = arr.length;
        printTwoElements(arr, n);
    }
}
