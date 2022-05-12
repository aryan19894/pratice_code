// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaPriorityQueue.java

package pratice.hackerrank.pratice.java.DataStructure;


class Student
{

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getCgpa()
    {
        return cgpa;
    }

    public void setCgpa(double cgpa)
    {
        this.cgpa = cgpa;
    }

    public Student(int id, String name, double cgpa)
    {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public Student()
    {
    }

    private int id;
    private String name;
    private double cgpa;
}
