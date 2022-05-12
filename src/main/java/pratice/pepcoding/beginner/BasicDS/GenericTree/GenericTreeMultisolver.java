// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GenericTreeMultisolver.java

package pratice.pepcoding.beginner.BasicDS.GenericTree;

import java.io.*;
import java.util.*;

public class GenericTreeMultisolver
{
    private static class Node
    {

        int data;
        ArrayList children;

        private Node()
        {
            children = new ArrayList();
        }

    }


    public GenericTreeMultisolver()
    {
    }

    public static void display(Node node)
    {
        String str = (new StringBuilder()).append(node.data).append(" -> ").toString();
        for(Iterator iterator = node.children.iterator(); iterator.hasNext();)
        {
            Node child = (Node)iterator.next();
            str = (new StringBuilder()).append(str).append(child.data).append(", ").toString();
        }

        str = (new StringBuilder()).append(str).append(".").toString();
        System.out.println(str);
        Node child;
        for(Iterator iterator1 = node.children.iterator(); iterator1.hasNext(); display(child))
            child = (Node)iterator1.next();

    }

    public static Node construct(int arr[])
    {
        Node root = null;
        Stack st = new Stack();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == -1)
            {
                st.pop();
                continue;
            }
            Node t = new Node();
            t.data = arr[i];
            if(st.size() > 0)
                ((Node)st.peek()).children.add(t);
            else
                root = t;
            st.push(t);
        }

        return root;
    }

    private static void multisolver(Node node, int depth)
    {
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);
        Node child;
        for(Iterator iterator = node.children.iterator(); iterator.hasNext(); multisolver(child, depth + 1))
            child = (Node)iterator.next();

    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        String values[] = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(values[i]);

        Node root = construct(arr);
        size = 0;
        min = 0x7fffffff;
        max = 0x80000000;
        height = 0;
        multisolver(root, 0);
        System.out.println(size);
        System.out.println(min);
        System.out.println(max);
        System.out.println(height);
    }

    private static int size;
    private static int min;
    private static int max;
    private static int height;
}
