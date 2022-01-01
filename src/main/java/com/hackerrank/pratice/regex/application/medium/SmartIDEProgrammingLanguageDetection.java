// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SmartIDEProgrammingLanguageDetection.java

package com.hackerrank.pratice.regex.application.medium;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartIDEProgrammingLanguageDetection
{

    public SmartIDEProgrammingLanguageDetection()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String code = readCode(sc);
        if(Pattern.compile("^\\s*#include", 8).matcher(code).find())
            System.out.println("C");
        else
        if(Pattern.compile("^\\s*import java\\.", 8).matcher(code).find())
            System.out.println("Java");
        else
            System.out.println("Python");
        sc.close();
    }

    static String readCode(Scanner sc)
    {
        StringBuilder sb = new StringBuilder();
        for(; sc.hasNextLine(); sb.append("\n"))
            sb.append(sc.nextLine());

        return sb.toString();
    }
}
