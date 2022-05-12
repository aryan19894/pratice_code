// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CelebrityProblem.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class CelebrityProblem
{

    public CelebrityProblem()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        for(int j = 0; j < n; j++)
        {
            String line = br.readLine();
            for(int k = 0; k < n; k++)
                arr[j][k] = line.charAt(k) - 48;

        }

        findCelebrity(arr);
    }

    public static void findCelebrity(int a[][])
    {
        int n = a.length;
        Stack celeb = new Stack();
        for(int i = 0; i < n; i++)
            celeb.add(Integer.valueOf(i));

        int n1;
        int n2;
        for(; celeb.size() >= 2; celeb.push(Integer.valueOf(a[n1][n2] != 1 ? n1 : n2)))
        {
            n1 = ((Integer)celeb.pop()).intValue();
            n2 = ((Integer)celeb.pop()).intValue();
        }

        int possibleCeleb = ((Integer)celeb.pop()).intValue();
        for(int i = 0; i < n; i++)
            if(possibleCeleb != i && (a[possibleCeleb][i] == 1 || a[i][possibleCeleb] == 0))
            {
                System.out.println("none");
                return;
            }

        System.out.println(possibleCeleb);
    }
}
