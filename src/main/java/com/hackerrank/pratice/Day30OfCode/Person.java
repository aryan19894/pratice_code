// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day4_ClassInstance.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;

class Person
{

    public Person(int initialAge)
    {
        if(initialAge < 0)
        {
            System.out.println("Age is not valid, setting age to 0.");
            age = 0;
        } else
        {
            age = initialAge;
        }
    }

    public void amIOld()
    {
        if(age < 13)
            System.out.println("You are young.");
        else
        if(age >= 13 && age < 18)
            System.out.println("You are a teenager.");
        else
            System.out.println("You are old.");
    }

    public void yearPasses()
    {
        age++;
    }

    private int age;
}
