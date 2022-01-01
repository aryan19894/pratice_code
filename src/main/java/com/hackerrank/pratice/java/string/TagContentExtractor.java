// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TagContentExtractor.java

package com.hackerrank.pratice.java.string;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor
{

    public TagContentExtractor()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        for(int testCases = Integer.parseInt(in.nextLine()); testCases > 0; testCases--)
        {
            String line = in.nextLine();
            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            for(Matcher m = r.matcher(line); m.find();)
            {
                System.out.println(m.group(2));
                matchFound = true;
            }

            if(!matchFound)
                System.out.println("None");
        }

    }
}
