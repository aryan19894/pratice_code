// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountTriplets.java

package pratice.hackerrank.pratice.interview.dictionaries_hashmaps;

import java.io.PrintStream;
import java.util.*;

public class CountTriplets
{

    public CountTriplets()
    {
    }

    static long countTriplets(List arr, long r)
    {
        long count = 0L;
        Map mp2 = new HashMap();
        Map mp3 = new HashMap();
        int n = arr.size();
        int i = 0;
        for(; n > 0; n--)
        {
            long val = ((Long)arr.get(i++)).longValue();
            if(mp3.containsKey(Long.valueOf(val)))
                count += ((Long)mp3.get(Long.valueOf(val))).longValue();
            if(mp2.containsKey(Long.valueOf(val)))
                updateMap(mp3, Long.valueOf(val * r), (Long)mp2.get(Long.valueOf(val)));
            updateMap(mp2, Long.valueOf(val * r), Long.valueOf(1L));
        }

        return count;
    }

    private static void updateMap(Map number, Long key, Long in)
    {
        number.putIfAbsent(key, Long.valueOf(0L));
        number.put(key, Long.valueOf(((Long)number.get(key)).longValue() + in.longValue()));
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long r = in.nextLong();
        List ar = new ArrayList();
        for(int i = 0; i < n; i++)
            ar.add(Long.valueOf(in.nextLong()));

        long ans = countTriplets(ar, r);
        System.out.println(ans);
    }
}
