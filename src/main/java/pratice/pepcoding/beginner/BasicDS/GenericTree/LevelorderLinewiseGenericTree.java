// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LevelorderLinewiseGenericTree.java

package pratice.pepcoding.beginner.BasicDS.GenericTree;

import java.io.*;
import java.util.*;

public class LevelorderLinewiseGenericTree
{
    private static class Node
    {

        public String toString()
        {
            return (new StringBuilder()).append("Node [data=").append(data).append("]").toString();
        }

        int data;
        ArrayList children;

        public Node(int data)
        {
            children = new ArrayList();
            this.data = data;
        }

        public Node()
        {
            children = new ArrayList();
        }
    }


    public LevelorderLinewiseGenericTree()
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

    public static void levelOrderLinewise(Node node)
    {
        Queue q = new ArrayDeque();
        Queue cq = new ArrayDeque();
        q.add(node);
        do
        {
            if(q.isEmpty())
                break;
            cq.addAll(((Node)q.peek()).children);
            System.out.print((new StringBuilder()).append(((Node)q.poll()).data).append(" ").toString());
            if(q.isEmpty())
            {
                System.out.println();
                q = cq;
                cq = new ArrayDeque();
            }
        } while(true);
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
        levelOrderLinewise(root);
    }
}
