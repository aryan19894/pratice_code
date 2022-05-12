// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InfixEvaluation2.java

package pratice.pepcoding.beginner.BasicDS.StacksQueues;

import java.io.*;
import java.util.Stack;

public class InfixEvaluation2
{

    public InfixEvaluation2()
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
        Stack operator = new Stack();
        Stack operand = new Stack();
        for(int i = 0; i < exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if(ch == '(')
            {
                operator.push(Character.valueOf(ch));
                continue;
            }
            if(Character.isDigit(ch))
            {
                operand.push(Integer.valueOf(ch - 48));
                continue;
            }
            if(ch == ')')
            {
                int num2;
                int num1;
                for(; !operator.isEmpty() && ((Character)operator.peek()).charValue() != '('; operand.push(Integer.valueOf(operation(num1, num2, ((Character)operator.pop()).charValue()))))
                {
                    num2 = ((Integer)operand.pop()).intValue();
                    num1 = ((Integer)operand.pop()).intValue();
                }

                operator.pop();
                continue;
            }
            if(!isOperator(ch))
                continue;
            int num2;
            int num1;
            for(; !operator.isEmpty() && ((Character)operator.peek()).charValue() != '(' && precedence(ch) <= precedence(((Character)operator.peek()).charValue()); operand.push(Integer.valueOf(operation(num1, num2, ((Character)operator.pop()).charValue()))))
            {
                num2 = ((Integer)operand.pop()).intValue();
                num1 = ((Integer)operand.pop()).intValue();
            }

            operator.push(Character.valueOf(ch));
        }

        int num2;
        int num1;
        for(; !operator.isEmpty(); operand.push(Integer.valueOf(operation(num1, num2, ((Character)operator.pop()).charValue()))))
        {
            num2 = ((Integer)operand.pop()).intValue();
            num1 = ((Integer)operand.pop()).intValue();
        }

        return ((Integer)operand.pop()).intValue();
    }

    private static boolean isOperator(char opr)
    {
        switch(opr)
        {
        case 42: // '*'
        case 43: // '+'
        case 45: // '-'
        case 47: // '/'
            return true;

        case 44: // ','
        case 46: // '.'
        default:
            return false;
        }
    }

    private static int precedence(char opr)
    {
        switch(opr)
        {
        case 43: // '+'
        case 45: // '-'
            return 1;

        case 42: // '*'
        case 47: // '/'
            return 2;

        case 44: // ','
        case 46: // '.'
        default:
            return -1;
        }
    }

    private static int operation(int num1, int num2, char opr)
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
