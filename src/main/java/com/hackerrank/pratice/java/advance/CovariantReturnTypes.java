// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CovariantReturnTypes.java

package com.hackerrank.pratice.java.advance;

import java.io.*;

// Referenced classes of package com.hackerrank.pratice.java.advance:
//            WestBengal, AndhraPradesh, Region, Flower

public class CovariantReturnTypes
{

    public CovariantReturnTypes()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        Flower flower = s;
        byte byte0 = -1;
        switch(flower.hashCode())
        {
        case -1663963882: 
            if(flower.equals("WestBengal"))
                byte0 = 0;
            break;

        case -141439467: 
            if(flower.equals("AndhraPradesh"))
                byte0 = 1;
            break;
        }
        switch(byte0)
        {
        case 0: // '\0'
            region = new WestBengal();
            break;

        case 1: // '\001'
            region = new AndhraPradesh();
            break;
        }
        flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}
