// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetSubsequence.java

package revise.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

public class GetSubsequence
{

    public GetSubsequence()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(gss(str));
    }

    public static ArrayList gss(String str)
    {
        if(str.isEmpty())
        {
            ArrayList bres = new ArrayList();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String substr = str.substring(1);
        ArrayList res = gss(substr);
        ArrayList rres = new ArrayList();
        String r;
        for(Iterator iterator = res.iterator(); iterator.hasNext(); rres.add((new StringBuilder()).append("").append(r).toString()))
            r = (String)iterator.next();

        String r;
        for(Iterator iterator1 = res.iterator(); iterator1.hasNext(); rres.add((new StringBuilder()).append(ch).append(r).toString()))
            r = (String)iterator1.next();

        return rres;
    }
}
