// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaRegexDuplicateWords.java

package com.hackerrank.pratice.java.string;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegexDuplicateWords
{

    public JavaRegexDuplicateWords()
    {
    }

    public static void main(String args[])
    {
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, 2);
        Scanner in = new Scanner(System.in);
        for(int numSentences = Integer.parseInt(in.nextLine()); numSentences-- > 0;)
        {
            String input = in.nextLine();
            for(Matcher m = p.matcher(input); m.find();)
                input = input.replaceAll(m.group(), m.group(1));

            System.out.println(input);
        }

        in.close();
    }
}
