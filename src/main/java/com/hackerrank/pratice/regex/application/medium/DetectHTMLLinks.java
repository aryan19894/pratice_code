// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DetectHTMLLinks.java

package com.hackerrank.pratice.regex.application.medium;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHTMLLinks
{

    public DetectHTMLLinks()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String html = readHtml(sc, N);
        String link;
        String textName;
        for(Matcher matcher = PATTERN.matcher(html); matcher.find(); System.out.println((new StringBuilder(String.valueOf(link))).append(",").append(textName).toString()))
        {
            link = matcher.group(1).trim();
            textName = matcher.group(4).trim();
        }

        sc.close();
    }

    static String readHtml(Scanner sc, int N)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
            sb.append(sc.nextLine());

        return sb.toString();
    }

    static final Pattern PATTERN = Pattern.compile("<a [^<>]*href=\"(.*?)\"[^<>]*>((<[^<>]+>)*?([^<>]*)(</[^<>]+>)*?)</a>", 8);

}
