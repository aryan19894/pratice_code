// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaLambdaExpressions.java

package com.hackerrank.pratice.java.advance;

import java.io.*;
import java.util.StringTokenizer;

// Referenced classes of package com.hackerrank.pratice.java.advance:
//            MyMath, PerformOperation

public class JavaLambdaExpressions
{

    public JavaLambdaExpressions()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean ret = false;
        String ans = null;
        for(; T-- > 0; System.out.println(ans))
        {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(ch == 1)
            {
                MyMath _tmp = ob;
                PerformOperation op = MyMath.isOdd();
                MyMath _tmp1 = ob;
                ret = MyMath.checker(op, num);
                ans = ret ? "ODD" : "EVEN";
                continue;
            }
            if(ch == 2)
            {
                MyMath _tmp2 = ob;
                PerformOperation op = MyMath.isPrime();
                MyMath _tmp3 = ob;
                ret = MyMath.checker(op, num);
                ans = ret ? "PRIME" : "COMPOSITE";
                continue;
            }
            if(ch == 3)
            {
                MyMath _tmp4 = ob;
                PerformOperation op = MyMath.isPalindrome();
                MyMath _tmp5 = ob;
                ret = MyMath.checker(op, num);
                ans = ret ? "PALINDROME" : "NOT PALINDROME";
            }
        }

    }
}
