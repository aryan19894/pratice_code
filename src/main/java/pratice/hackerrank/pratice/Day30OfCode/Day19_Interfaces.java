// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day19_Interfaces.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.Day30OfCode:
//            Calculator1, AdvancedArithmetic

public class Day19_Interfaces
{

    public Day19_Interfaces()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        AdvancedArithmetic myCalculator = new Calculator1();
        int sum = myCalculator.divisorSum(n);
        System.out.println((new StringBuilder()).append("I implemented: ").append(myCalculator.getClass().getInterfaces()[0].getName()).toString());
        System.out.println(sum);
    }
}
