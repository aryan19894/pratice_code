// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PatternSyntaxChecker.java

package pratice.hackerrank.pratice.java.string;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntaxChecker
{

    public PatternSyntaxChecker()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        for(int testCases = Integer.parseInt(in.nextLine()); testCases > 0; testCases--)
        {
            String pattern = in.nextLine();
            try
            {
                Pattern.compile(pattern);
                System.out.println("Valid");
            }
            catch(PatternSyntaxException e)
            {
                System.out.println("Invalid");
            }
        }

    }
}
