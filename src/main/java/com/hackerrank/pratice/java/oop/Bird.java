// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaInheritanceI.java

package com.hackerrank.pratice.java.oop;

import java.io.PrintStream;

// Referenced classes of package com.hackerrank.pratice.java.oop:
//            Animal

class Bird extends Animal
{

    Bird()
    {
    }

    void fly()
    {
        System.out.println("I am flying");
    }

    void sing()
    {
        System.out.println("I am singing");
    }
}
