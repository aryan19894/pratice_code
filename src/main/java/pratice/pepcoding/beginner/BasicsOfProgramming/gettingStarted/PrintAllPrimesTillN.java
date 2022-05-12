// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintAllPrimesTillN.java

package pratice.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

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
        if(a == 1)
        {
            System.out.println(a);
            a++;
            if(b >= 2)
            {
                System.out.println(a);
                a++;
            }
        }
        if(a == 2)
            System.out.println(a);
        if(a % 2 == 0)
            a++;
        for(int i = a; i <= b; i += 2)
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
