// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaAnnotations.java

package pratice.hackerrank.pratice.java.advance;

import java.io.PrintStream;

class FamilyMember
{

    FamilyMember()
    {
    }

    public void seniorMember(int budget, int moneySpend)
    {
        System.out.println("Senior Member");
        System.out.println((new StringBuilder()).append("Spend: ").append(moneySpend).toString());
        System.out.println((new StringBuilder()).append("Budget Left: ").append(budget - moneySpend).toString());
    }

    public void juniorUser(int budget, int moneySpend)
    {
        System.out.println("Junior Member");
        System.out.println((new StringBuilder()).append("Spend: ").append(moneySpend).toString());
        System.out.println((new StringBuilder()).append("Budget Left: ").append(budget - moneySpend).toString());
    }
}
