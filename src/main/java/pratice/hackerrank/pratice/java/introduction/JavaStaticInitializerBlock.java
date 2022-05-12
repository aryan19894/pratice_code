// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaStaticInitializerBlock.java

package pratice.hackerrank.pratice.java.introduction;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaStaticInitializerBlock
{

    public JavaStaticInitializerBlock()
    {
    }

    public static void main(String args[])
    {
        if(flag)
        {
            int area = B * H;
            System.out.print(area);
        }
    }

    static boolean flag = true;
    static int B;
    static int H;

    static 
    {
        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        boolean flag = true;
        if(B <= 0 || H <= 0)
        {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag = false;
            System.exit(0);
        }
    }
}
