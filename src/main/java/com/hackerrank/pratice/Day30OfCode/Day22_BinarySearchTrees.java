// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day22_BinarySearchTrees.java

package com.hackerrank.pratice.Day30OfCode;

import com.common.DoubleListNode;
import java.io.PrintStream;
import java.util.Scanner;

class Day22_BinarySearchTrees
{

    Day22_BinarySearchTrees()
    {
    }

    public static int getHeight(DoubleListNode root)
    {
        int left = -1;
        int right = -1;
        DoubleListNode node = root;
        if(node.left != null)
            left = getHeight(node.left);
        if(node.right != null)
            right = getHeight(node.right);
        return 1 + Math.max(left, right);
    }

    public static DoubleListNode insert(DoubleListNode root, int data)
    {
        if(root == null)
            return new DoubleListNode(data);
        if(data <= root.data)
        {
            DoubleListNode cur = insert(root.left, data);
            root.left = cur;
        } else
        {
            DoubleListNode cur = insert(root.right, data);
            root.right = cur;
        }
        return root;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        DoubleListNode root;
        int data;
        for(root = null; T-- > 0; root = insert(root, data))
            data = sc.nextInt();

        int height = getHeight(root);
        System.out.println(height);
    }
}
