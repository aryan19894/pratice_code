// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaSort.java

package com.hackerrank.pratice.java.DataStructure;


class Student11
    implements Comparable
{

    public Student11(int id, String fname, double cgpa)
    {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId()
    {
        return id;
    }

    public String getFname()
    {
        return fname;
    }

    public double getCgpa()
    {
        return cgpa;
    }

    public int compareTo(Object o)
    {
        Student11 s = (Student11)o;
        if(cgpa == s.cgpa)
            if(fname.equals(s.fname))
                return id - s.id;
            else
                return fname.compareTo(s.fname);
        return s.cgpa - cgpa <= 0.0D ? -1 : 1;
    }

    private int id;
    private String fname;
    private double cgpa;
}
