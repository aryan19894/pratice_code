// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AlienUsername.java

package pratice.hackerrank.pratice.regex.application.easy;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienUsername
{

    public AlienUsername()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int tc = 0; tc < N; tc++)
        {
            String str = sc.next();
            String res = getUsernameStatus(str);
            System.out.println(res);
        }

    }

    private static String getUsernameStatus(String str)
    {
        String regex = "^[_|.]\\d+[a-zA-Z]*_?$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        int c = 0;
        if(m.find())
            return "VALID";
        else
            return "INVALID";
    }
}
