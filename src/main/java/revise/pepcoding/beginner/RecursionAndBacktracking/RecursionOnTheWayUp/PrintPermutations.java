// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintPermutations.java

package revise.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintPermutations
{

    public PrintPermutations()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printPermutations(str, "");
    }

    public static void printPermutations(String str, String ans)
    {
        if(str.isEmpty())
        {
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            String ros = (new StringBuilder()).append(str.substring(0, i)).append(str.substring(i + 1)).toString();
            printPermutations(ros, (new StringBuilder()).append(ans).append(ch).toString());
        }

    }
}
