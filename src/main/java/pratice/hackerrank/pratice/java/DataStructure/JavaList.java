// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaList.java

package pratice.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.*;

public class JavaList
{

    public JavaList()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List l = new ArrayList();
        while(n-- > 0) 
        {
            int ref = scan.nextInt();
            l.add(Integer.valueOf(ref));
        }
        int q = scan.nextInt();
        do
        {
            if(q-- > 0)
            {
                String action = scan.next();
                String s = action;
                byte byte0 = -1;
                switch(s.hashCode())
                {
                case -2099925287: 
                    if(s.equals("Insert"))
                        byte0 = 0;
                    break;

                case 2043376075: 
                    if(s.equals("Delete"))
                        byte0 = 1;
                    break;
                }
                switch(byte0)
                {
                case 0: // '\0'
                {
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    l.add(x, Integer.valueOf(y));
                    break;
                }

                case 1: // '\001'
                {
                    int x = scan.nextInt();
                    l.remove(x);
                    break;
                }
                }
                continue;
            }
            int a;
            for(Iterator iterator = l.iterator(); iterator.hasNext(); System.out.print((new StringBuilder()).append(a).append(" ").toString()))
                a = ((Integer)iterator.next()).intValue();

            break;
        } while(true);
    }
}
