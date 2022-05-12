// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LowestCommonAncestorGenericTree.java

package pratice.pepcoding.beginner.BasicDS.GenericTree;

import java.io.*;
import java.util.*;

public class LowestCommonAncestorGenericTree
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


    public LowestCommonAncestorGenericTree()
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

    public static ArrayList nodeToRootPath(Node node, int data)
    {
        if(node.data == data)
        {
            ArrayList path = new ArrayList();
            path.add(Integer.valueOf(node.data));
            return path;
        }
        for(Iterator iterator = node.children.iterator(); iterator.hasNext();)
        {
            Node child = (Node)iterator.next();
            ArrayList ptc = nodeToRootPath(child, data);
            if(ptc.size() > 0)
            {
                ptc.add(Integer.valueOf(node.data));
                return ptc;
            }
        }

        return new ArrayList();
    }

    public static int lca(Node node, int d1, int d2)
    {
        ArrayList p1 = nodeToRootPath(node, d1);
        ArrayList p2 = nodeToRootPath(node, d2);
        int i = p1.size() - 1;
        for(int j = p2.size() - 1; i >= 0 && j >= 0 && p1.get(i) == p2.get(j); j--)
            i--;

        return ((Integer)p1.get(++i)).intValue();
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

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());
        Node root = construct(arr);
        int lca = lca(root, d1, d2);
        System.out.println(lca);
    }
}
