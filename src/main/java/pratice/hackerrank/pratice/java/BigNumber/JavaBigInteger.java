// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaBigInteger.java

package pratice.hackerrank.pratice.java.BigNumber;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger
{

    public JavaBigInteger()
    {
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        BigInteger ai = new BigInteger(a);
        BigInteger bi = new BigInteger(b);
        System.out.println(ai.add(bi));
        System.out.println(ai.multiply(bi));
    }
}
