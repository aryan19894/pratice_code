// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InfixEvaluation.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class InfixEvaluation
{

    public InfixEvaluation()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();
        int n = ip.length();
        String exp = "";
        for(int i = 0; i < n; i++)
        {
            char ch = ip.charAt(i);
            if(ch != ' ')
                exp = (new StringBuilder()).append(exp).append(ch).toString();
        }

        System.out.println(infixEval(exp));
    }

    private static int infixEval(String exp)
    {
        Stack oprSt = new Stack();
        Stack intSt = new Stack();
        for(int i = 0; i < exp.length(); i++)
        {
            char ch = exp.charAt(i);
            int num = ch - 48;
            if(num >= 0 && num <= 9)
            {
                intSt.push(Integer.valueOf(num));
                continue;
            }
            oprSt.push(Character.valueOf(ch));
            if(ch == ')')
            {
                oprSt.pop();
                int num2;
                int num1;
                for(; !oprSt.isEmpty() && ((Character)oprSt.peek()).charValue() != '('; intSt.push(Integer.valueOf(performOp(num1, num2, ((Character)oprSt.pop()).charValue()))))
                {
                    num2 = ((Integer)intSt.pop()).intValue();
                    num1 = ((Integer)intSt.pop()).intValue();
                }

                oprSt.pop();
            }
            if(ch == '*' || ch == '/')
            {
                int num1 = ((Integer)intSt.pop()).intValue();
                int num2 = exp.charAt(i + 1) - 48;
                intSt.push(Integer.valueOf(performOp(num1, num2, ((Character)oprSt.pop()).charValue())));
                i++;
            }
        }

        int num2;
        int num1;
        for(; !oprSt.isEmpty() && ((Character)oprSt.peek()).charValue() != '('; intSt.push(Integer.valueOf(performOp(num1, num2, ((Character)oprSt.pop()).charValue()))))
        {
            num2 = ((Integer)intSt.pop()).intValue();
            num1 = ((Integer)intSt.pop()).intValue();
        }

        return ((Integer)intSt.pop()).intValue();
    }

    private static int performOp(int num1, int num2, char opr)
    {
        int ans = 0;
        switch(opr)
        {
        case 43: // '+'
            ans = num1 + num2;
            break;

        case 45: // '-'
            ans = num1 - num2;
            break;

        case 42: // '*'
            ans = num1 * num2;
            break;

        case 47: // '/'
            ans = num1 / num2;
            break;
        }
        return ans;
    }
}
