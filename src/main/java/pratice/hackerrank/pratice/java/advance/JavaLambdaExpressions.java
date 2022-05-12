// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaLambdaExpressions.java

package pratice.hackerrank.pratice.java.advance;

import java.io.*;
import java.util.StringTokenizer;

// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            MyMath, PerformOperation

public class JavaLambdaExpressions
{

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean ret = false;

        for(String ans = null; T-- > 0; System.out.println(ans)) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            PerformOperation op;
            if (ch == 1) {
                op = MyMath.isOdd();
                ret = MyMath.checker(op, num);
                ans = ret ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = MyMath.isPrime();
                ret = MyMath.checker(op, num);
                ans = ret ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = MyMath.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = ret ? "PALINDROME" : "NOT PALINDROME";
            }
        }

    }
}
