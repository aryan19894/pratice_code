// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HighestFrequencyCharacter.java

package pratice.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyCharacter
{

    public HighestFrequencyCharacter()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        HashMap mp = new HashMap();
        int max = 0x80000000;
        char res = ' ';
        char ac[] = s.toCharArray();
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            char ch = ac[j];
            int freq = mp.containsKey(Character.valueOf(ch)) ? ((Integer)mp.get(Character.valueOf(ch))).intValue() + 1 : 1;
            mp.put(Character.valueOf(ch), Integer.valueOf(freq));
            if(max < freq)
            {
                max = freq;
                res = ch;
            }
        }

        System.out.println(res);
    }
}
