// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SayingHi.java

package pratice.hackerrank.pratice.regex.application.easy;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SayingHi
{

    public SayingHi()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int tc = 0; tc < n; tc++)
        {
            String line = sc.nextLine();
            Matcher matcher = PATTERN.matcher(line);
            if(matcher.find())
                System.out.println(matcher.group());
        }

        sc.close();
    }

    static final Pattern PATTERN = Pattern.compile("^[Hh][Ii]\\s[^Dd].*$");

}
