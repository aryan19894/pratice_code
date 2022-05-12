// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaRegex.java

package pratice.hackerrank.pratice.java.string;

import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.java.string:
//            MyRegex

public class JavaRegex
{

    public JavaRegex()
    {
    }

    public static void main(String args[])
    {
        String IP;
        for(Scanner in = new Scanner(System.in); in.hasNext(); System.out.println(IP.matches((new MyRegex()).pattern)))
            IP = in.next();

    }
}
