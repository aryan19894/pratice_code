// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RansomNote.java

package pratice.hackerrank.pratice.interview.dictionaries_hashmaps;

import java.io.PrintStream;
import java.util.Scanner;

public class RansomNote
{

    public RansomNote()
    {
    }

    static void checkMagazine(String magazine[], String note[])
    {
        boolean st = false;
        String as[] = note;
        int i = as.length;
        int j = 0;
        do
        {
            if(j >= i)
                break;
            String n = as[j];
            if(!isExist(magazine, n))
            {
                System.out.println("No");
                st = true;
                break;
            }
            j++;
        } while(true);
        if(!st)
            System.out.println("Yes");
    }

    private static boolean isExist(String m[], String n)
    {
        for(int i = 0; i < m.length; i++)
            if(m[i].equals(n))
            {
                m[i] = "";
                return true;
            }

        return false;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String mag[] = new String[m];
        String not[] = new String[n];
        for(int i = 0; i < m; i++)
            mag[i] = in.next();

        for(int i = 0; i < n; i++)
            not[i] = in.next();

        checkMagazine(mag, not);
    }
}
