// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day17_MoreExceptions.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.Day30OfCode:
//            Calculator

public class Day17_MoreExceptions
{

    public Day17_MoreExceptions()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        for(int t = in.nextInt(); t-- > 0;)
        {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try
            {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        in.close();
    }
}
