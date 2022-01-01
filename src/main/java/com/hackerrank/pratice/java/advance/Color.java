// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVisitorPattern.java

package com.hackerrank.pratice.java.advance;


final class Color extends Enum
{

    public static Color[] values()
    {
        return (Color[])$VALUES.clone();
    }

    public static Color valueOf(String name)
    {
        return (Color)Enum.valueOf(com/hackerrank/pratice/java/advance/Color, name);
    }

    private Color(String s, int i)
    {
        super(s, i);
    }

    public static final Color RED;
    public static final Color GREEN;
    private static final Color $VALUES[];

    static 
    {
        RED = new Color("RED", 0);
        GREEN = new Color("GREEN", 1);
        $VALUES = (new Color[] {
            RED, GREEN
        });
    }
}
