// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day11_Arrays2D.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day11_Arrays2D
{

    public Day11_Arrays2D()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a[][] = new int[6][6];
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
                a[i][j] = in.nextInt();

        }

        int res = 0x80000000;
        int sum = 0;
        int rId = 0;
        for(int r1 = 0; r1 < a.length - 2; r1++)
        {
            for(int c1 = 0; c1 < a[r1].length - 2; c1++)
            {
                rId = 0;
                for(int r2 = r1; r2 < r1 + 3; r2++)
                {
                    int c2 = c1;
                    do
                    {
                        if(c2 >= c1 + 3)
                            break;
                        if(rId == 1)
                        {
                            sum += a[r2][c2 + 1];
                            break;
                        }
                        sum += a[r2][c2];
                        c2++;
                    } while(true);
                    rId++;
                }

                if(res < sum)
                    res = sum;
                sum = 0;
            }

        }

        System.out.println(res);
    }
}
