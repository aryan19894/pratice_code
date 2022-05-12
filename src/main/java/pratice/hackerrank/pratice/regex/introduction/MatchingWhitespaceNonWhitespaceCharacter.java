// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatchingWhitespaceNonWhitespaceCharacter.java

package pratice.hackerrank.pratice.regex.introduction;

import pratice.hackerrank.pratice.regex.common.Regex_Test;

public class MatchingWhitespaceNonWhitespaceCharacter
{

    public MatchingWhitespaceNonWhitespaceCharacter()
    {
    }

    public static void main(String args[])
    {
        Regex_Test tester = new Regex_Test();
        tester.checker("(\\S{2}\\s){2}\\S{2}");
    }
}
