// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaRegex.java

package pratice.hackerrank.pratice.java.string;


class MyRegex
{

    MyRegex()
    {
        zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        pattern = (new StringBuilder()).append(zeroTo255).append("\\.").append(zeroTo255).append("\\.").append(zeroTo255).append("\\.").append(zeroTo255).toString();
    }

    String zeroTo255;
    public String pattern;
}
