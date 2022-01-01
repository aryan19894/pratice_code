// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DetectEmailAddresses.java

package com.hackerrank.pratice.regex.application.medium;

import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectEmailAddresses
{

    public DetectEmailAddresses()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String text = readText(sc, N);
        SortedSet emails = new TreeSet();
        String email;
        for(Matcher matcher = PATTERN.matcher(text); matcher.find(); emails.add(email))
            email = matcher.group();

        System.out.println(String.join(";", (CharSequence[])emails.toArray(new String[0])));
        sc.close();
    }

    static String readText(Scanner sc, int N)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
        {
            sb.append(sc.nextLine());
            sb.append("\n");
        }

        return sb.toString();
    }

    static final Pattern PATTERN = Pattern.compile("[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)+");

}
