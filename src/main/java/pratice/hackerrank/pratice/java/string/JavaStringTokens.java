// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaStringTokens.java

package pratice.hackerrank.pratice.java.string;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaStringTokens
{

    public JavaStringTokens()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.trim();
        if(s.equals(""))
        {
            System.out.println("0");
        } else
        {
            if(s.length() > 0x61a80)
                return;
            String items[] = s.trim().split("[ !,?.\\_'@]+");
            System.out.println(items.length);
            String args1[] = items;
            int i = args1.length;
            for(int j = 0; j < i; j++)
            {
                String item = args1[j];
                System.out.println(item);
            }

        }
        scan.close();
    }
}
