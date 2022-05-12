// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVarargsSimpleAddition.java

package pratice.hackerrank.pratice.java.advance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            Add

public class JavaVarargsSimpleAddition
{

    public JavaVarargsSimpleAddition()
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
            int n6 = Integer.parseInt(br.readLine());
            Add ob = new Add();
            ob.add(new int[] {
                n1, n2
            });
            ob.add(new int[] {
                n1, n2, n3
            });
            ob.add(new int[] {
                n1, n2, n3, n4, n5
            });
            ob.add(new int[] {
                n1, n2, n3, n4, n5, n6
            });
            Method methods[] = Add.class.getDeclaredMethods();
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
            e.printStackTrace();
        }
    }
}
