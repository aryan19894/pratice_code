// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LinearizeAGenericTreeMoreEfficient.java

package pratice.pepcoding.beginner.BasicDS.GenericTree;

import java.io.*;
import java.util.*;

public class LinearizeAGenericTreeMoreEfficient
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


    public LinearizeAGenericTreeMoreEfficient()
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

    public static int size(Node node)
    {
        int s = 0;
        for(Iterator iterator = node.children.iterator(); iterator.hasNext();)
        {
            Node child = (Node)iterator.next();
            s += size(child);
        }

        return ++s;
    }

    public static int max(Node node)
    {
        int m = 0x80000000;
        for(Iterator iterator = node.children.iterator(); iterator.hasNext();)
        {
            Node child = (Node)iterator.next();
            int cm = max(child);
            m = Math.max(m, cm);
        }

        m = Math.max(m, node.data);
        return m;
    }

    public static int height(Node node)
    {
        int h = -1;
        for(Iterator iterator = node.children.iterator(); iterator.hasNext();)
        {
            Node child = (Node)iterator.next();
            int ch = height(child);
            h = Math.max(h, ch);
        }

        return ++h;
    }

    public static void traversals(Node node)
    {
        System.out.println((new StringBuilder()).append("Node Pre ").append(node.data).toString());
        Node child;
        for(Iterator iterator = node.children.iterator(); iterator.hasNext(); System.out.println((new StringBuilder()).append("Edge Post ").append(node.data).append("--").append(child.data).toString()))
        {
            child = (Node)iterator.next();
            System.out.println((new StringBuilder()).append("Edge Pre ").append(node.data).append("--").append(child.data).toString());
            traversals(child);
        }

        System.out.println((new StringBuilder()).append("Node Post ").append(node.data).toString());
    }

    public static void levelOrderLinewiseZZ(Node node)
    {
        Stack stack = new Stack();
        stack.add(node);
        Stack cstack = new Stack();
        int level = 0;
        do
        {
            if(stack.size() <= 0)
                break;
            node = (Node)stack.pop();
            System.out.print((new StringBuilder()).append(node.data).append(" ").toString());
            if(level % 2 == 0)
            {
                for(int i = 0; i < node.children.size(); i++)
                {
                    Node child = (Node)node.children.get(i);
                    cstack.push(child);
                }

            } else
            {
                for(int i = node.children.size() - 1; i >= 0; i--)
                {
                    Node child = (Node)node.children.get(i);
                    cstack.push(child);
                }

            }
            if(stack.size() == 0)
            {
                stack = cstack;
                cstack = new Stack();
                level++;
                System.out.println();
            }
        } while(true);
    }

    public static void mirror(Node node)
    {
        Node child;
        for(Iterator iterator = node.children.iterator(); iterator.hasNext(); mirror(child))
            child = (Node)iterator.next();

        Collections.reverse(node.children);
    }

    public static void removeLeaves(Node node)
    {
        for(int i = node.children.size() - 1; i >= 0; i--)
        {
            Node child = (Node)node.children.get(i);
            if(child.children.size() == 0)
                node.children.remove(i);
        }

        Node child;
        for(Iterator iterator = node.children.iterator(); iterator.hasNext(); removeLeaves(child))
            child = (Node)iterator.next();

    }

    public static Node linearize(Node node)
    {
        if(node.children.isEmpty())
            return node;
        Node lastKeyTail = linearize((Node)node.children.get(node.children.size() - 1));
        Node last;
        Node secLastTail;
        for(; node.children.size() > 1; secLastTail.children.add(last))
        {
            last = (Node)node.children.remove(node.children.size() - 1);
            Node secLast = (Node)node.children.get(node.children.size() - 1);
            secLastTail = linearize(secLast);
        }

        return lastKeyTail;
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
        linearize(root);
        display(root);
    }
}
