// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day18_QueuesStacks.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.*;

public class Day18_QueuesStacks
{

    public Day18_QueuesStacks()
    {
        stack = new LinkedList();
        queue = new LinkedList();
    }

    void pushCharacter(char ch)
    {
        stack.add(0, Character.valueOf(ch));
    }

    void enqueueCharacter(char ch)
    {
        if(queue.size() == 0)
            queue.add(0, Character.valueOf(ch));
        else
            queue.add(queue.size(), Character.valueOf(ch));
    }

    char popCharacter()
    {
        return ((Character)stack.remove(0)).charValue();
    }

    char dequeueCharacter()
    {
        return ((Character)queue.remove(0)).charValue();
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        char s[] = input.toCharArray();
        Day18_QueuesStacks p = new Day18_QueuesStacks();
        char ac[] = s;
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            char c = ac[j];
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        boolean isPalindrome = true;
        i = 0;
        do
        {
            if(i >= s.length / 2)
                break;
            if(p.popCharacter() != p.dequeueCharacter())
            {
                isPalindrome = false;
                break;
            }
            i++;
        } while(true);
        System.out.println((new StringBuilder()).append("The word, ").append(input).append(", is ").append(isPalindrome ? "a palindrome." : "not a palindrome.").toString());
    }

    private List stack;
    private List queue;
}
