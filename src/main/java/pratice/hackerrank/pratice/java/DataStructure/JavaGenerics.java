// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaGenerics.java

package pratice.hackerrank.pratice.java.DataStructure;

import java.lang.reflect.Method;

// Referenced classes of package pratice.hackerrank.pratice.java.DataStructure:
//            Printer

public class JavaGenerics
{

    public JavaGenerics()
    {
    }

    public static void main(String args[])
    {
        Printer myPrinter = new Printer();
        Integer intArray[] = {
            Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)
        };
        String stringArray[] = {
            "Hello", "World"
        };
        Printer _tmp = myPrinter;
        Printer.printArray(intArray);
        Printer _tmp1 = myPrinter;
        Printer.printArray(stringArray);
        int count = 0;
        Method amethod[] = Printer.class.getDeclaredMethods();
        int i = amethod.length;
        for(int j = 0; j < i; j++)
        {
            Method method = amethod[j];
            String name = method.getName();
            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)
            System.out.println("Method overloading is not allowed!");
    }
}
