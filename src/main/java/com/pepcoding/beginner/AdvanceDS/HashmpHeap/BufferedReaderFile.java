// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BufferedReaderFile.java

package com.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderFile
{

    public BufferedReaderFile()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(br.readLine());
        int a2 = Integer.parseInt(br.readLine());
    }
}
