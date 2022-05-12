// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BrokenEconomyCeilFloor.java

package pratice.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class BrokenEconomyCeilFloor
{

    public BrokenEconomyCeilFloor()
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

        int d = scn.nextInt();
        getCeilFloor(n, arr, d);
    }

    private static void getCeilFloor(int n, int arr[], int d)
    {
        int ceil;
        int floor;
label0:
        {
            int l = 0;
            int r = n - 1;
            ceil = 0x80000000;
            floor = 0x7fffffff;
            int m;
            do
            {
                if(l > r)
                    break label0;
                m = (l + r) / 2;
                if(d < arr[m])
                {
                    r = m - 1;
                    ceil = arr[m];
                    continue;
                }
                if(d <= arr[m])
                    break;
                l = m + 1;
                floor = arr[m];
            } while(true);
            ceil = floor = arr[m];
        }
        System.out.println(ceil);
        System.out.println(floor);
    }
}
