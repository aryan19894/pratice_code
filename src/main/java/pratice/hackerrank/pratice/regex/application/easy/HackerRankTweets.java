// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HackerRankTweets.java

package pratice.hackerrank.pratice.regex.application.easy;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankTweets
{

    public HackerRankTweets()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int result = 0;
        for(int i = 0; i < N; i++)
        {
            String line = sc.nextLine();
            if(PATTERN.matcher(line).find())
                result++;
        }

        System.out.println(result);
        sc.close();
    }

    static final Pattern PATTERN = Pattern.compile("pratice", 2);

}
