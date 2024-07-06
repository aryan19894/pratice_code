// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetKpc.java

package revise._2022.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

public class GetKpc
{

    public GetKpc()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(getKPC(str));
    }

    public static ArrayList getKPC(String str)
    {
        if(str.isEmpty())
        {
            ArrayList bres = new ArrayList();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String substr = str.substring(1);
        String codeforeach = codes[ch - 48];
        ArrayList res = getKPC(substr);
        ArrayList rres = new ArrayList();
        for(int i = 0; i < codeforeach.length(); i++)
        {
            String r;
            for(Iterator iterator = res.iterator(); iterator.hasNext(); rres.add((new StringBuilder()).append(codeforeach.charAt(i)).append(r).toString()))
                r = (String)iterator.next();

        }

        return rres;
    }

    static String codes[] = {
        ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"
    };

}
