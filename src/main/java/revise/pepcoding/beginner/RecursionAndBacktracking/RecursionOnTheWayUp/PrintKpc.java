// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintKpc.java

package revise.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintKpc
{

    public PrintKpc()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printKPC(str, "");
    }

    public static void printKPC(String str, String ans)
    {
        if(str.isEmpty())
        {
            System.out.println(ans);
            return;
        }
        char fchar = str.charAt(0);
        String substr = str.substring(1);
        String codeforeach = codes[fchar - 48];
        char ac[] = codeforeach.toCharArray();
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            char ch = ac[j];
            printKPC(substr, (new StringBuilder()).append(ans).append(ch).toString());
        }

    }

    static String codes[] = {
        ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"
    };

}
