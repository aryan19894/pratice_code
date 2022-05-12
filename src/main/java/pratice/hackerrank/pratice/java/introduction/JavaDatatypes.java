// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaDatatypes.java

package pratice.hackerrank.pratice.java.introduction;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaDatatypes
{

    public JavaDatatypes()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
            try
            {
                long x = sc.nextLong();
                System.out.println((new StringBuilder()).append(x).append(" can be fitted in:").toString());
                if(x >= -128L && x <= 127L)
                    System.out.println("* byte");
                if((double)x >= -Math.pow(2D, 15D) && (double)x <= Math.pow(2D, 15D) - 1.0D)
                    System.out.println("* short");
                if((double)x >= -Math.pow(2D, 31D) && (double)x <= Math.pow(2D, 31D) - 1.0D)
                    System.out.println("* int");
                if((double)x >= -Math.pow(2D, 63D) && (double)x <= Math.pow(2D, 63D) - 1.0D)
                    System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println((new StringBuilder()).append(sc.next()).append(" can't be fitted anywhere.").toString());
            }

    }
}
