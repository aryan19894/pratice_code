// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day12_Inheritance.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;

class Person12
{

    Person12(String firstName, String lastName, int identification)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        idNumber = identification;
    }

    public void printPerson()
    {
        System.out.println((new StringBuilder()).append("Name: ").append(lastName).append(", ").append(firstName).append("\nID: ").append(idNumber).toString());
    }

    protected String firstName;
    protected String lastName;
    protected int idNumber;
}
