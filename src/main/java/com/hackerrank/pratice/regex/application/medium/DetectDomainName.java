// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DetectDomainName.java

package com.hackerrank.pratice.regex.application.medium;

import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectDomainName
{

    public DetectDomainName()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String html = readData(sc, N);
        SortedSet tags = new TreeSet();
        for(Matcher matcher = PATTERN.matcher(html); matcher.find();)
        {
            String link = matcher.group(1).trim();
            if(!tags.contains(link))
                tags.add(link);
        }

        System.out.println(String.join(";", (CharSequence[])tags.toArray(new String[0])));
        sc.close();
    }

    static String readData(Scanner sc, int N)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
            sb.append(sc.nextLine());

        return sb.toString();
    }

    static final Pattern PATTERN = Pattern.compile("https?://(www.|ww2.)?([a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+)");

}
