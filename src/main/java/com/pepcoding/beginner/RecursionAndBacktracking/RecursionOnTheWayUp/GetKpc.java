// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetKpc.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class GetKpc
{

    public GetKpc()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        getKPC(str, "");
    }

    public static void getKPC(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        String codeforeach = codes[ch - 48];
        for(int i = 0; i < codeforeach.length(); i++)
            getKPC(ros, (new StringBuilder()).append(ans).append(codeforeach.charAt(i)).toString());

    }

    static String codes[] = {
        ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"
    };

}
