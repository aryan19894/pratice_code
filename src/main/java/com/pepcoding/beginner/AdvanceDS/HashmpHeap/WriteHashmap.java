// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WriteHashmap.java

package com.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.*;
import java.util.*;

public class WriteHashmap
{
    public static class HashMap
    {
        private class HMNode
        {

            Object key;
            Object value;
            final HashMap this$0;

            HMNode(Object key, Object value)
            {
                this$0 = HashMap.this;
                super();
                this.key = key;
                this.value = value;
            }
        }


        private void initbuckets(int N)
        {
            buckets = new LinkedList[N];
            for(int bi = 0; bi < buckets.length; bi++)
                buckets[bi] = new LinkedList();

        }

        public void put(Object key, Object value)
            throws Exception
        {
            int bucketIdx = hash(key);
            int dataIdx = getIndexWithinBucket(key, bucketIdx);
            if(dataIdx != -1)
            {
                ((HMNode)buckets[bucketIdx].get(dataIdx)).value = value;
            } else
            {
                buckets[bucketIdx].add(new HMNode(key, value));
                size++;
            }
            double lambda = ((double)size * 1.0D) / (double)buckets.length;
            if(lambda > 2D)
                rehash();
        }

        private int getIndexWithinBucket(Object key, int bi)
        {
            int di = 0;
            for(Iterator iterator = buckets[bi].iterator(); iterator.hasNext();)
            {
                HMNode node = (HMNode)iterator.next();
                if(node.key.equals(key))
                    return di;
                di++;
            }

            return -1;
        }

        private void rehash()
            throws Exception
        {
            LinkedList oba[] = buckets;
            initbuckets(oba.length * 2);
            size = 0;
            LinkedList alinkedlist[] = oba;
            int i = alinkedlist.length;
            for(int j = 0; j < i; j++)
            {
                LinkedList bucket = alinkedlist[j];
                HMNode node;
                for(Iterator iterator = bucket.iterator(); iterator.hasNext(); put(node.key, node.value))
                    node = (HMNode)iterator.next();

            }

        }

        private int hash(Object key)
        {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        public Object get(Object key)
            throws Exception
        {
            int bucketIdx = hash(key);
            int dataIdx = getIndexWithinBucket(key, bucketIdx);
            if(dataIdx != -1)
                return ((HMNode)buckets[bucketIdx].get(dataIdx)).value;
            else
                return null;
        }

        public boolean containsKey(Object key)
        {
            int bucketIdx = hash(key);
            int dataIdx = getIndexWithinBucket(key, bucketIdx);
            return dataIdx != -1;
        }

        public Object remove(Object key)
            throws Exception
        {
            int bucketIdx = hash(key);
            int dataIdx = getIndexWithinBucket(key, bucketIdx);
            if(dataIdx != -1)
            {
                size--;
                return ((HMNode)buckets[bucketIdx].remove(dataIdx)).value;
            } else
            {
                return null;
            }
        }

        public ArrayList keyset()
            throws Exception
        {
            ArrayList keys = new ArrayList();
            LinkedList alinkedlist[] = buckets;
            int i = alinkedlist.length;
            for(int j = 0; j < i; j++)
            {
                LinkedList bucket = alinkedlist[j];
                HMNode node;
                for(Iterator iterator = bucket.iterator(); iterator.hasNext(); keys.add(node.key))
                    node = (HMNode)iterator.next();

            }

            return keys;
        }

        public int size()
        {
            return size;
        }

        public void display()
        {
            System.out.println("Display Begins");
            for(int bi = 0; bi < buckets.length; bi++)
            {
                System.out.print((new StringBuilder()).append("Bucket").append(bi).append(" ").toString());
                HMNode node;
                for(Iterator iterator = buckets[bi].iterator(); iterator.hasNext(); System.out.print((new StringBuilder()).append(node.key).append("@").append(node.value).append(" ").toString()))
                    node = (HMNode)iterator.next();

                System.out.println(".");
            }

            System.out.println("Display Ends");
        }

        private int size;
        private LinkedList buckets[];

        public HashMap()
        {
            initbuckets(4);
            size = 0;
        }
    }


    public WriteHashmap()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap map = new HashMap();
        for(String str = br.readLine(); !str.equals("quit"); str = br.readLine())
        {
            if(str.startsWith("put"))
            {
                String parts[] = str.split(" ");
                String key = parts[1];
                Integer val = Integer.valueOf(Integer.parseInt(parts[2]));
                map.put(key, val);
                continue;
            }
            if(str.startsWith("get"))
            {
                String parts[] = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
                continue;
            }
            if(str.startsWith("containsKey"))
            {
                String parts[] = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
                continue;
            }
            if(str.startsWith("remove"))
            {
                String parts[] = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
                continue;
            }
            if(str.startsWith("size"))
            {
                System.out.println(map.size());
                continue;
            }
            if(str.startsWith("keyset"))
            {
                System.out.println(map.keyset());
                continue;
            }
            if(str.startsWith("display"))
                map.display();
        }

    }
}
