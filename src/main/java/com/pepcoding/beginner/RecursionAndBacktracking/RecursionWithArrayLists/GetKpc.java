// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetKpc.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

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
        System.out.println(getKPC(str));
    }

    public static ArrayList getKPC(String str)
    {
        if(str.length() == 0)
        {
            ArrayList bref = new ArrayList();
            bref.add("");
            return bref;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList rref = getKPC(ros);
        ArrayList mref = new ArrayList();
        String codeforeach = codes[ch - 48];
        for(int i = 0; i < codeforeach.length(); i++)
        {
            String r;
            for(Iterator iterator = rref.iterator(); iterator.hasNext(); mref.add((new StringBuilder()).append(codeforeach.charAt(i)).append(r).toString()))
                r = (String)iterator.next();

        }

        return mref;
    }

    static String codes[] = {
        ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"
    };

}
