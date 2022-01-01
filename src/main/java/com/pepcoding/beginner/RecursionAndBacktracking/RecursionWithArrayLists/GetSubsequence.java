// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetSubsequence.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

public class GetSubsequence
{

    public GetSubsequence()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(gss(str));
    }

    public static ArrayList gss(String str)
    {
        if(str.length() == 0)
        {
            ArrayList bres = new ArrayList();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList rres = gss(ros);
        ArrayList mres = new ArrayList();
        String s;
        for(Iterator iterator = rres.iterator(); iterator.hasNext(); mres.add((new StringBuilder()).append("").append(s).toString()))
            s = (String)iterator.next();

        String s;
        for(Iterator iterator1 = rres.iterator(); iterator1.hasNext(); mres.add((new StringBuilder()).append(ch).append(s).toString()))
            s = (String)iterator1.next();

        return mres;
    }
}
