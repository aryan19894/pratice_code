// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GenericTreeConstructor.java

package pratice.pepcoding.beginner.BasicDS.GenericTree.Theory;

import java.io.PrintStream;
import java.util.*;

public class GenericTreeConstructor
{
    private static class Node
    {

        public String toString()
        {
            return (new StringBuilder()).append("Node [data=").append(data).append(", child=").append(child).append("]").toString();
        }

        int data;
        ArrayList child;

        public Node(int data)
        {
            child = new ArrayList();
            this.data = data;
        }
    }


    public GenericTreeConstructor()
    {
    }

    public static void main(String args[])
    {
        int arr[] = {
            10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 
            80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 
            100, -1, -1, -1
        };
        Node root = null;
        Stack st = new Stack();
        int ai[] = arr;
        int i = ai.length;
        for(int j = 0; j < i; j++)
        {
            int a = ai[j];
            if(a == -1)
            {
                st.pop();
                continue;
            }
            Node t = new Node(a);
            if(st.isEmpty())
                root = t;
            else
                ((Node)st.peek()).child.add(t);
            st.push(t);
        }

        display(root);
    }

    private static void display(Node node)
    {
        String str = (new StringBuilder()).append(node.data).append(" -> [").toString();
        for(Iterator iterator = node.child.iterator(); iterator.hasNext();)
        {
            Node n = (Node)iterator.next();
            str = (new StringBuilder()).append(str).append(n.data).append(", ").toString();
        }

        System.out.println((new StringBuilder()).append(str).append("]").toString());
        Node n;
        for(Iterator iterator1 = node.child.iterator(); iterator1.hasNext(); display(n))
            n = (Node)iterator1.next();

    }
}
