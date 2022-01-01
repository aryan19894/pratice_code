// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day14_Scope.java

package com.hackerrank.pratice.Day30OfCode;

import java.util.Arrays;

class Difference
{

    Difference(int elements[])
    {
        this.elements = elements;
    }

    public void computeDifference()
    {
        Arrays.sort(elements);
        maximumDifference = elements[elements.length - 1] - elements[0];
    }

    private int elements[];
    public int maximumDifference;
}
