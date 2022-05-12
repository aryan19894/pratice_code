// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FindHackerRank.java

package pratice.hackerrank.pratice.regex.application.easy;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindHackerRank
{

    public FindHackerRank()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for(int tc = 0; tc < N; tc++)
        {
            String line = sc.nextLine();
            if(START_END_PATTERN.matcher(line).find())
                System.out.println(0);
            else
            if(START_PATTERN.matcher(line).find())
                System.out.println(1);
            else
            if(END_PATTERN.matcher(line).find())
                System.out.println(2);
            else
                System.out.println(-1);
        }

        sc.close();
    }

    static final Pattern START_PATTERN = Pattern.compile("^pratice");
    static final Pattern END_PATTERN = Pattern.compile("pratice$");
    static final Pattern START_END_PATTERN = Pattern.compile("^pratice$");

}
