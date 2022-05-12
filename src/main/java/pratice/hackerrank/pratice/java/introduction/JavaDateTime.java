// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaDateTime.java

package pratice.hackerrank.pratice.java.introduction;

import java.text.ParseException;
import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.java.introduction:
//            Result

public class JavaDateTime
{

    public JavaDateTime()
    {
    }

    public static void main(String args[])
        throws ParseException
    {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int day = in.nextInt();
        int year = in.nextInt();
        String res = Result.findDay(month, day, year);
        System.out.println(res);
    }
}
