// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day28_RegExPatternsDatabases.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day28_RegExPatternsDatabases
{

    public Day28_RegExPatternsDatabases()
    {
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String emailRegEx = ".+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegEx);
        List list = new ArrayList();
        for(int i = 0; i < num; i++)
        {
            String name = scanner.next();
            String email = scanner.next();
            Matcher matcher = pattern.matcher(email);
            if(matcher.find())
                list.add(name);
        }

        Collections.sort(list);
        String name;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); System.out.println(name))
            name = (String)iterator.next();

    }
}
