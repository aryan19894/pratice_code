// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtopianIdentificationNumber.java

package pratice.hackerrank.pratice.regex.application.easy;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtopianIdentificationNumber
{

    public UtopianIdentificationNumber()
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
            System.out.println(PATTERN.matcher(line).matches() ? "VALID" : "INVALID");
        }

        sc.close();
    }

    static final Pattern PATTERN = Pattern.compile("^\\p{Lower}{0,3}\\d{2,8}\\p{Upper}{3,}$");

}
