// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaStringReverse.java

package pratice.hackerrank.pratice.java.string;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaStringReverse
{

    public JavaStringReverse()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        boolean flag = true;
        int i = 0;
        do
        {
            if(i >= A.length() / 2)
                break;
            if(Character.valueOf(A.charAt(i)).compareTo(Character.valueOf(A.charAt(A.length() - i - 1))) != 0)
            {
                flag = false;
                break;
            }
            i++;
        } while(true);
        System.out.print(!flag ? "No" : "Yes");
    }
}
