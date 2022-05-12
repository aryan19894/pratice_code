// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrimeChecker.java

package pratice.hackerrank.pratice.java.advance;

import java.io.*;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            Prime

public class PrimeChecker
{

    public PrimeChecker()
    {
    }

    public static void main(String args[])
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(new int[] {
                n1
            });
            ob.checkPrime(new int[] {
                n1, n2
            });
            ob.checkPrime(new int[] {
                n1, n2, n3
            });
            ob.checkPrime(new int[] {
                n1, n2, n3, n4, n5
            });
            Method methods[] = Prime.class.getDeclaredMethods();
            Set set = new HashSet();
            boolean overload = false;
            int i = 0;
            do
            {
                if(i >= methods.length)
                    break;
                if(set.contains(methods[i].getName()))
                {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());
                i++;
            } while(true);
            if(overload)
                throw new Exception("Overloading not allowed");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
