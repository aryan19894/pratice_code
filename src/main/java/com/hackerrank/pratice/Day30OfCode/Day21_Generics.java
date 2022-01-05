// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day21_Generics.java

package com.hackerrank.pratice.Day30OfCode;

import java.util.Scanner;

// Referenced classes of package com.hackerrank.pratice.Day30OfCode:
//            Printer

public class Day21_Generics {

    public Day21_Generics() {
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer intArray[] = new Integer[n];
        for (int i = 0; i < n; i++)
            intArray[i] = Integer.valueOf(scanner.nextInt());

        n = scanner.nextInt();
        String stringArray[] = new String[n];
        for (int i = 0; i < n; i++)
            stringArray[i] = scanner.next();

        Printer intPrinter = new Printer();
        Printer stringPrinter = new Printer();
        intPrinter.printArray(intArray);
        stringPrinter.printArray(stringArray);
        if (Printer.class.getDeclaredMethods().length > 1)
            System.out.println("The Printer class should only have 1 method named printArray.");
    }
}
