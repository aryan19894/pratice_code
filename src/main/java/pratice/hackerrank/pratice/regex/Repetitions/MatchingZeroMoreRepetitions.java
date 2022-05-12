// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatchingZeroMoreRepetitions.java

package pratice.hackerrank.pratice.regex.Repetitions;

import pratice.hackerrank.pratice.regex.common.Regex_Test;

public class MatchingZeroMoreRepetitions
{

    public MatchingZeroMoreRepetitions()
    {
    }

    public static void main(String args[])
    {
        Regex_Test tester = new Regex_Test();
        tester.checker("^.{1,2}[a-zA-Z]{3,}[.]{0,3}$");
    }
}
