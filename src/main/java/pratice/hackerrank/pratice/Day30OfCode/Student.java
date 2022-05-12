// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day12_Inheritance.java

package pratice.hackerrank.pratice.Day30OfCode;


// Referenced classes of package pratice.hackerrank.pratice.Day30OfCode:
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
        int[] var2 = this.testScores;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Integer t = var2[var4];
            total += t;
        }

        int avg = total / this.testScores.length;
        char ch = ' ';
        if (avg < 40) {
            ch = 'T';
        } else if (avg < 55) {
            ch = 'D';
        } else if (avg < 70) {
            ch = 'P';
        } else if (avg < 80) {
            ch = 'A';
        } else if (avg < 90) {
            ch = 'E';
        } else if (avg <= 100) {
            ch = 'O';
        }

        return ch;
    }

    private int testScores[];
}
