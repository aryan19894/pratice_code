// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CanYouAccess.java

package com.hackerrank.pratice.java.advance;

import java.io.*;

// Referenced classes of package com.hackerrank.pratice.java.advance:
//            DoNotTerminate

public class CanYouAccess
{
    static class Inner
    {

        Inner()
        {
        }
    }


    public CanYouAccess()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        DoNotTerminate.forbidExit();
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o = new Inner.Private(new Inner());
            System.out.println((new StringBuilder()).append(num).append(" is ").append(Inner.Private.access._mth100((Inner.Private)o, num)).toString());
            System.out.println((new StringBuilder()).append("An instance of class: ").append(o.getClass().getCanonicalName()).append(" has been created").toString());
        }
        catch(DoNotTerminate.ExitTrappedException e)
        {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}
