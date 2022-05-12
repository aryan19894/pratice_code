// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaBitSet.java

package pratice.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet
{

    public JavaBitSet()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        BitSet bitset[] = new BitSet[3];
        bitset[1] = b1;
        bitset[2] = b2;
        for(int i = 0; i < m; i++)
        {
            String op = in.next();
            int x = in.nextInt();
            int y = in.nextInt();
            String s = op;
            byte byte0 = -1;
            switch(s.hashCode())
            {
            case 64951: 
                if(s.equals("AND"))
                    byte0 = 0;
                break;

            case 2531: 
                if(s.equals("OR"))
                    byte0 = 1;
                break;

            case 87099: 
                if(s.equals("XOR"))
                    byte0 = 2;
                break;

            case 2160749: 
                if(s.equals("FLIP"))
                    byte0 = 3;
                break;

            case 81986: 
                if(s.equals("SET"))
                    byte0 = 4;
                break;
            }
            switch(byte0)
            {
            case 0: // '\0'
                bitset[x].and(bitset[y]);
                break;

            case 1: // '\001'
                bitset[x].or(bitset[y]);
                break;

            case 2: // '\002'
                bitset[x].xor(bitset[y]);
                break;

            case 3: // '\003'
                bitset[x].flip(y);
                break;

            case 4: // '\004'
                bitset[x].set(y);
                break;
            }
            System.out.println((new StringBuilder()).append(b1.cardinality()).append(" ").append(b2.cardinality()).toString());
        }

    }
}
