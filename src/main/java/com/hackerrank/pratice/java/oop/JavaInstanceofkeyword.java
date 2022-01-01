// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaInstanceofkeyword.java

package com.hackerrank.pratice.java.oop;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

// Referenced classes of package com.hackerrank.pratice.java.oop:
//            Student, Rockstar, Hacker

public class JavaInstanceofkeyword
{

    public JavaInstanceofkeyword()
    {
    }

    static String count(ArrayList mylist)
    {
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0; i < mylist.size(); i++)
        {
            Object element = mylist.get(i);
            if(element instanceof Student)
                a++;
            if(element instanceof Rockstar)
                b++;
            if(element instanceof Hacker)
                c++;
        }

        String ret = (new StringBuilder()).append(Integer.toString(a)).append(" ").append(Integer.toString(b)).append(" ").append(Integer.toString(c)).toString();
        return ret;
    }

    public static void main(String args[])
    {
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            String s = sc.next();
            if(s.equals("Student"))
                mylist.add(new Student());
            if(s.equals("Rockstar"))
                mylist.add(new Rockstar());
            if(s.equals("Hacker"))
                mylist.add(new Hacker());
        }

        System.out.println(count(mylist));
    }
}
