// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PhoneNumber.java

package pratice.leetcode.prev.facebook.medium;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumber
{

    public PhoneNumber()
    {
    }

    public static void main(String arg[])
    {
        System.out.println(letterCombinations("32"));
    }

    public static List letterCombinations(String digits)
    {
        LinkedList ans = new LinkedList();
        if(digits.isEmpty())
            return ans;
        String mapping[] = {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        ans.add("");
        while(((String)ans.peek()).length() != digits.length()) 
        {
            String remove = (String)ans.remove();
            String map = mapping[digits.charAt(remove.length()) - 48];
            char ac[];
            int j = (ac = map.toCharArray()).length;
            for(int i = 0; i < j; i++)
            {
                char c = ac[i];
                ans.addLast((new StringBuilder(String.valueOf(remove))).append(c).toString());
            }

        }
        return ans;
    }
}
