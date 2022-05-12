// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day12_Inheritance.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.Day30OfCode:
//            Student

public class Day12_Inheritance
{

    public Day12_Inheritance()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int testScores[] = new int[numScores];
        for(int i = 0; i < numScores; i++)
            testScores[i] = scan.nextInt();

        scan.close();
        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println((new StringBuilder()).append("Grade: ").append(s.calculate()).toString());
    }
}
