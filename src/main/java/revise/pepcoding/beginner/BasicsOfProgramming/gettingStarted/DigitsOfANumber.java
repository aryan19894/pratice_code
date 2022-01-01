// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DigitsOfANumber.java

package revise.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class DigitsOfANumber
{

    public DigitsOfANumber()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int div;
        for(int len = String.valueOf(n).length(); n > 0 || len > 0; n %= div)
        {
            div = (int)Math.pow(10D, --len);
            System.out.println(n / div);
        }

    }
}
