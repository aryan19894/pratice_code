// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CovariantReturnTypes.java

package com.hackerrank.pratice.java.advance;


// Referenced classes of package com.hackerrank.pratice.java.advance:
//            Region, Lotus, Flower

class Karnataka extends Region
{

    Karnataka()
    {
    }

    Lotus yourNationalFlower()
    {
        return new Lotus();
    }

    volatile Flower yourNationalFlower()
    {
        return yourNationalFlower();
    }
}
