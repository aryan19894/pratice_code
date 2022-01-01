// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintAllPrimesTillN.java

package revise.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintAllPrimesTillN
{

    public PrintAllPrimesTillN()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        for(int i = a; i <= b; i++)
        {
            int flag = 1;
            int j = 2;
            do
            {
                if(j * j > i)
                    break;
                if(i % j == 0)
                {
                    flag = 0;
                    break;
                }
                j++;
            } while(true);
            if(flag == 1)
                System.out.println(i);
        }

    }
}
