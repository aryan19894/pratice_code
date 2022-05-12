// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MinMaxRiddle2.java

package pratice.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.*;

public class MinMaxRiddle2
{

    public MinMaxRiddle2()
    {
    }

    static long[] riddle(long arr[])
    {
        long result[] = new long[arr.length];
        HashMap longestSteak = new HashMap();
        Stack stack = new Stack();
label0:
        for(int i = 0; i <= arr.length; i++)
        {
            long lastHeight = 0L;
            if(!stack.isEmpty())
                lastHeight = arr[((Integer)stack.peek()).intValue()];
            long currentHeight = i >= arr.length ? 0L : arr[i];
            if(lastHeight < currentHeight)
            {
                stack.push(Integer.valueOf(i));
                continue;
            }
            do
            {
                Integer poppedValue;
                do
                {
                    if(stack.isEmpty() || arr[((Integer)stack.peek()).intValue()] <= currentHeight)
                        continue label0;
                    poppedValue = (Integer)stack.pop();
                    Integer itemLongestSteak = Integer.valueOf(i - poppedValue.intValue());
                    if(longestSteak.get(Long.valueOf(arr[poppedValue.intValue()])) == null || ((Integer)longestSteak.get(Long.valueOf(arr[poppedValue.intValue()]))).intValue() < itemLongestSteak.intValue())
                        longestSteak.put(Long.valueOf(arr[poppedValue.intValue()]), itemLongestSteak);
                } while(!stack.isEmpty() && arr[((Integer)stack.peek()).intValue()] >= currentHeight);
                arr[poppedValue.intValue()] = currentHeight;
                stack.push(poppedValue);
            } while(true);
        }

        HashMap reversedLongestSteak = new HashMap();
        Iterator iterator = longestSteak.entrySet().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(reversedLongestSteak.get(entry.getValue()) == null || ((Long)reversedLongestSteak.get(entry.getValue())).longValue() < ((Long)entry.getKey()).longValue())
                reversedLongestSteak.put(entry.getValue(), entry.getKey());
        } while(true);
        long lastValue = 0L;
        for(int i = arr.length; i > 0; i--)
        {
            if(reversedLongestSteak.get(Integer.valueOf(i)) != null)
                lastValue = Math.max(((Long)reversedLongestSteak.get(Integer.valueOf(i))).longValue(), lastValue);
            result[i - 1] = lastValue;
        }

        return result;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long h[] = new long[n];
        for(int i = 0; i < n; i++)
        {
            long e = scan.nextLong();
            h[i] = e;
        }

        long result[] = riddle(h);
        System.out.println(Arrays.toString(result));
        scan.close();
    }
}
