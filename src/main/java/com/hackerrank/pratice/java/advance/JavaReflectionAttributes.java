// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaReflectionAttributes.java

package com.hackerrank.pratice.java.advance;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.*;

// Referenced classes of package com.hackerrank.pratice.java.advance:
//            Student

public class JavaReflectionAttributes
{

    public JavaReflectionAttributes()
    {
    }

    public static void main(String args[])
    {
        Class student = Student.class;
        Method methods[] = student.getDeclaredMethods();
        ArrayList methodNames = new ArrayList();
        Method amethod[] = methods;
        int i = amethod.length;
        for(int j = 0; j < i; j++)
        {
            Method method = amethod[j];
            methodNames.add(method.getName());
        }

        Collections.sort(methodNames);
        String name;
        for(Iterator iterator = methodNames.iterator(); iterator.hasNext(); System.out.println(name))
            name = (String)iterator.next();

    }
}
