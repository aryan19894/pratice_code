// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FindWord.java

package pratice.hackerrank.pratice.regex.application.medium;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWord
{

    public FindWord()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String sentences = readLines(sc, N);
        int T = sc.nextInt();
        for(int tc = 0; tc < T; tc++)
        {
            String substring = sc.next();
            System.out.println(findOccurrenceNum(sentences, substring));
        }

        sc.close();
    }

    static String readLines(Scanner sc, int N)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
        {
            sb.append(sc.nextLine());
            sb.append("\n");
        }

        return sb.toString();
    }

    private static int findOccurrenceNum(String sentense, String substr)
    {
        String regex = (new StringBuilder("(?<![\\w_])")).append(substr).append("(?![\\w_])").toString();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sentense);
        int c;
        for(c = 0; m.find(); c++);
        return c;
    }
}
