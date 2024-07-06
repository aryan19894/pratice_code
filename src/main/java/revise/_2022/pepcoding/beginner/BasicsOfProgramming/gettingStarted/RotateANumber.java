// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RotateANumber.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class RotateANumber
{

    public RotateANumber()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int len = String.valueOf(n).length();
        k %= len;
        if(k < 0)
            k += len;
        int ro = (int)Math.pow(10D, k);
        int re = (int)Math.pow(10D, len - k);
        if(k == 0)
            System.out.println(n);
        else
        if(k > 0)
        {
            int rotate = n % ro;
            n /= ro;
            System.out.println(re * rotate + n);
        }
    }
}
