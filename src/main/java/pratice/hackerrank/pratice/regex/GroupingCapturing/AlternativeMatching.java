// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AlternativeMatching.java

package pratice.hackerrank.pratice.regex.GroupingCapturing;

import pratice.hackerrank.pratice.regex.common.Regex_Test;

public class AlternativeMatching
{

    public AlternativeMatching()
    {
    }

    public static void main(String args[])
    {
        Regex_Test tester = new Regex_Test();
        tester.checker("^(Mr|Mrs|Ms|Dr|Er)[.]\\p{Alpha}+$");
    }
}
