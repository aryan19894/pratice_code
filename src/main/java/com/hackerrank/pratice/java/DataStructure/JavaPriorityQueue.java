// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaPriorityQueue.java

package com.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package com.hackerrank.pratice.java.DataStructure:
//            Student, Priorities

public class JavaPriorityQueue
{

    public JavaPriorityQueue()
    {
    }

    public static void main(String args[])
    {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List events = new ArrayList();
        while(totalEvents-- != 0) 
        {
            String event = scan.nextLine();
            events.add(event);
        }
        List Students = priorities.getStudents(events);
        if(Students.isEmpty())
        {
            System.out.println("EMPTY");
        } else
        {
            Student st;
            for(Iterator iterator = Students.iterator(); iterator.hasNext(); System.out.println(st.getName()))
                st = (Student)iterator.next();

        }
    }

    private static final Scanner scan;
    private static final Priorities priorities = new Priorities();

    static 
    {
        scan = new Scanner(System.in);
    }
}
