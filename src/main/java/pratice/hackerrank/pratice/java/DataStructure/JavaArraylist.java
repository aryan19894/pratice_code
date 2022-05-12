// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaArraylist.java

package pratice.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaArraylist
{

    public JavaArraylist()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList list = new ArrayList();
        ArrayList ref = null;
        for(int i = 0; i < n; i++)
        {
            ref = new ArrayList();
            int e = sc.nextInt();
            for(int j = 0; j < e; j++)
                ref.add(Integer.valueOf(sc.nextInt()));

            list.add(ref);
        }

        int q = sc.nextInt();
        for(int i = 0; i < q; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ref = (ArrayList)list.get(x - 1);
            if(y <= ref.size())
                System.out.println(ref.get(y - 1));
            else
                System.out.println("ERROR!");
        }

    }
}
