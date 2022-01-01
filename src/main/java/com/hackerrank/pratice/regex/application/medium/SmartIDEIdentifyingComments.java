// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SmartIDEIdentifyingComments.java

package com.hackerrank.pratice.regex.application.medium;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartIDEIdentifyingComments
{

    public SmartIDEIdentifyingComments()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String code = readCode(sc);
        String comment;
        for(Matcher matcher = PATTERN.matcher(code); matcher.find(); display(comment))
            comment = matcher.group();

        sc.close();
    }

    static String readCode(Scanner sc)
    {
        StringBuilder sb = new StringBuilder();
        for(; sc.hasNextLine(); sb.append("\n"))
            sb.append(sc.nextLine());

        return sb.toString();
    }

    static void display(String comment)
    {
        Scanner sc;
        for(sc = new Scanner(comment); sc.hasNextLine(); System.out.println(sc.nextLine().trim()));
        sc.close();
    }

    static final Pattern PATTERN = Pattern.compile("(//[^\\n]*)|(/\\*.*?\\*/)");

}
