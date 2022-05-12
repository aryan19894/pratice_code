// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day19_Interfaces.java

package pratice.hackerrank.pratice.Day30OfCode;


// Referenced classes of package pratice.hackerrank.pratice.Day30OfCode:
//            AdvancedArithmetic

class Calculator1
    implements AdvancedArithmetic
{

    Calculator1()
    {
    }

    public int divisorSum(int n)
    {
        int sum = n;
        for(int i = 1; i < n; i++)
            if(n % i == 0)
                sum += i;

        return sum;
    }
}
