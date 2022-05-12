// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DetectingValidLatitudeLongitudePairs.java

package pratice.hackerrank.pratice.regex.application.easy;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectingValidLatitudeLongitudePairs
{

    public DetectingValidLatitudeLongitudePairs()
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
            System.out.println(PATTERN.matcher(line).matches() ? "Valid" : "Invalid");
        }

        sc.close();
    }

    static final Pattern PATTERN = Pattern.compile("\\([+-]?(90(\\.0+)?|([1-8][0-9]|[1-9])(\\.\\d+)?), [+-]?(180(\\.0+)?|(1[0-7][0-9]|[1-9][0-9]|[1-9])(\\.\\d+)?)\\)");

}
