// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaMethodOverriding.java

package com.hackerrank.pratice.java.oop;

import java.io.PrintStream;

// Referenced classes of package com.hackerrank.pratice.java.oop:
//            Sports, Soccer

public class JavaMethodOverriding
{

    public JavaMethodOverriding()
    {
    }

    public static void main(String args[])
    {
        Sports c1 = new Sports();
        Soccer c2 = new Soccer();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();
    }
}
