// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaAbstractClass.java

package com.hackerrank.pratice.java.oop;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package com.hackerrank.pratice.java.oop:
//            MyBook

public class JavaAbstractClass
{

    public JavaAbstractClass()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        MyBook new_novel = new MyBook();
        new_novel.setTitle(title);
        System.out.println((new StringBuilder()).append("The title is: ").append(new_novel.getTitle()).toString());
        sc.close();
    }
}
