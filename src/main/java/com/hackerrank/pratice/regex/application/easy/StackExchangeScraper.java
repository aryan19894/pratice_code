// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StackExchangeScraper.java

package com.hackerrank.pratice.regex.application.easy;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackExchangeScraper
{

    public StackExchangeScraper()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String html = readHtml(sc);
        String id;
        String question;
        String time;
        for(Matcher matcher = PATTERN.matcher(html); matcher.find(); System.out.println(String.join(";", new CharSequence[] {
    id, question, time
})))
        {
            id = matcher.group(1).trim();
            question = matcher.group(2).trim();
            time = matcher.group(3).trim();
        }

        sc.close();
    }

    static String readHtml(Scanner sc)
    {
        StringBuilder sb = new StringBuilder();
        for(; sc.hasNextLine(); sb.append(sc.nextLine()));
        return sb.toString();
    }

    static final Pattern PATTERN = Pattern.compile("id=\"question-summary-(\\d+)\".*?class=\"question-hyperlink\">(.+?)</a>.*?class=\"relativetime\">(.+?)</span>");

}
