// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LevelOrderTraversalsMoreApproaches.java

package pratice.pepcoding.beginner.BasicDS.GenericTree;

import java.io.*;
import java.util.*;

public class LevelOrderTraversalsMoreApproaches
{
    private static class Pair
    {

        public String toString()
        {
            return (new StringBuilder()).append("").append(node).append("-").append(level).toString();
        }

        Node node;
        int level;

        public Pair(Node node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }

    private static class Node
    {

        public String toString()
        {
            return (new StringBuilder()).append("").append(data).toString();
        }

        int data;
        ArrayList children;

        public Node()
        {
            children = new ArrayList();
        }

        public Node(int data)
        {
            children = new ArrayList();
            this.data = data;
        }
    }


    public LevelOrderTraversalsMoreApproaches()
    {
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

    public static void levelOrderTranservalMoreApproach1(Node node)
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

    private static void levelOrderTranservalMoreApproach2(Node node)
    {
        Node mark = new Node(-1);
        Queue q = new ArrayDeque();
        q.add(node);
        q.add(mark);
        while(!q.isEmpty()) 
        {
            Node t = (Node)q.poll();
            if(t.data == -1)
            {
                if(!q.isEmpty())
                    q.add(mark);
                System.out.println();
            } else
            {
                System.out.print((new StringBuilder()).append(t.data).append(" ").toString());
                q.addAll(t.children);
            }
        }
    }

    private static void levelOrderTranservalMoreApproach3(Node node)
    {
        Queue q = new ArrayDeque();
        q.add(node);
        for(; !q.isEmpty(); System.out.println())
        {
            int qs = q.size();
            for(int i = 0; i < qs; i++)
            {
                Node t = (Node)q.poll();
                System.out.print((new StringBuilder()).append(t.data).append(" ").toString());
                q.addAll(t.children);
            }

        }

    }

    private static void levelOrderTranservalMoreApproach4(Node node)
    {
        Queue q = new ArrayDeque();
        q.add(new Pair(node, 1));
        int cl = 1;
        while(!q.isEmpty()) 
        {
            Pair t = (Pair)q.poll();
            if(t.level > cl)
            {
                cl = t.level;
                System.out.println();
            }
            System.out.print((new StringBuilder()).append(t.node.data).append(" ").toString());
            Iterator iterator = t.node.children.iterator();
            while(iterator.hasNext()) 
            {
                Node n = (Node)iterator.next();
                q.add(new Pair(n, cl + 1));
            }
        }
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
        levelOrderTranservalMoreApproach4(root);
    }
}
