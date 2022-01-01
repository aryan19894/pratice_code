// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaInheritanceII.java

package com.hackerrank.pratice.java.oop;

import java.io.PrintStream;

// Referenced classes of package com.hackerrank.pratice.java.oop:
//            Adder

public class JavaInheritanceII
{

    public JavaInheritanceII()
    {
    }

    public static void main(String args[])
    {
        Adder a = new Adder();
        System.out.println((new StringBuilder()).append("My superclass is: ").append(a.getClass().getSuperclass().getName()).toString());
        System.out.print((new StringBuilder()).append(a.add(10, 32)).append(" ").append(a.add(10, 3)).append(" ").append(a.add(10, 10)).append("\n").toString());
    }
}
