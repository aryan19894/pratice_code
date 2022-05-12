// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaStringsIntroduction.java

package pratice.hackerrank.pratice.java.string;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaStringsIntroduction
{

    public JavaStringsIntroduction()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) <= 0 ? "No" : "Yes");
        System.out.println((new StringBuilder()).append(A.substring(0, 1).toUpperCase()).append(A.substring(1, A.length())).append(" ").append(B.substring(0, 1).toUpperCase()).append(B.substring(1, B.length())).toString());
    }
}
