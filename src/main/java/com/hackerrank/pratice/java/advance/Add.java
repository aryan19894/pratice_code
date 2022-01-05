// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVarargsSimpleAddition.java

package com.hackerrank.pratice.java.advance;

import java.io.PrintStream;

class Add
{

    Add()
    {
    }

    void add(int numbers[])
    {
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        int ai[] = numbers;
        int i = ai.length;
        for(int j = 0; j < i; j++)
        {
            int num = ai[j];
            sb.append((new StringBuilder()).append(num).append("+").toString());
            sum += num;
        }

        sb.setCharAt(sb.length() - 1, '=');
        sb.append(sum);
        System.out.println(sb);
    }
}
