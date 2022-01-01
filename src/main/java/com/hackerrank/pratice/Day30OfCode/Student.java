// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day12_Inheritance.java

package com.hackerrank.pratice.Day30OfCode;


// Referenced classes of package com.hackerrank.pratice.Day30OfCode:
//            Person12

class Student extends Person12
{

    Student(String firstName, String lastName, int identification, int scores[])
    {
        super(firstName, lastName, identification);
        testScores = scores;
    }

    public char calculate()
    {
        int total = 0;
        int ai[] = testScores;
        char ch = ai.length;
        for(int i = 0; i < ch; i++)
        {
            Integer t = Integer.valueOf(ai[i]);
            total += t.intValue();
        }

        int avg = total / testScores.length;
        ch = ' ';
        if(avg < 40)
            ch = 'T';
        else
        if(avg < 55)
            ch = 'D';
        else
        if(avg < 70)
            ch = 'P';
        else
        if(avg < 80)
            ch = 'A';
        else
        if(avg < 90)
            ch = 'E';
        else
        if(avg <= 100)
            ch = 'O';
        return ch;
    }

    private int testScores[];
}
