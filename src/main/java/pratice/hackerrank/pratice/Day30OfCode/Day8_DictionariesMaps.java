// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day8_DictionariesMaps.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.*;

public class Day8_DictionariesMaps
{

    public Day8_DictionariesMaps()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map phonebook = new HashMap();
        for(int i = 0; i < n; i++)
        {
            String name = in.next();
            int phone = in.nextInt();
            phonebook.put(name, Integer.valueOf(phone));
        }

        while(in.hasNext()) 
        {
            String s = in.next();
            Integer contact = (Integer)phonebook.get(s);
            if(contact != null)
                System.out.println((new StringBuilder()).append(s).append("=").append(contact).toString());
            else
                System.out.println("Not found");
        }
        in.close();
    }
}
