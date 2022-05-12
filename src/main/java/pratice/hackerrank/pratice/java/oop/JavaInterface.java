// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaInterface.java

package pratice.hackerrank.pratice.java.oop;

import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.java.oop:
//            MyCalculator

class JavaInterface
{

    JavaInterface()
    {
    }

    public static void main(String args[])
    {
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print((new StringBuilder()).append(my_calculator.divisor_sum(n)).append("\n").toString());
        sc.close();
    }

    static void ImplementedInterfaceNames(Object o)
    {
        Class theInterfaces[] = o.getClass().getInterfaces();
        for(int i = 0; i < theInterfaces.length; i++)
        {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }

    }
}
