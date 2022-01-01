// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaSort.java

package com.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package com.hackerrank.pratice.java.DataStructure:
//            Student11

public class JavaSort
{

    public JavaSort()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List Student11List = new ArrayList();
        for(; testCases > 0; testCases--)
        {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            Student11 st = new Student11(id, fname, cgpa);
            Student11List.add(st);
        }

        Collections.sort(Student11List);
        Student11 st;
        for(Iterator iterator = Student11List.iterator(); iterator.hasNext(); System.out.println(st.getFname()))
            st = (Student11)iterator.next();

    }
}
