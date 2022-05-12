// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day23_BSTLevelOrderTraversal.java

package pratice.hackerrank.pratice.Day30OfCode;

import pratice.common.DoubleListNode;
import java.io.PrintStream;
import java.util.Scanner;

class Day23_BSTLevelOrderTraversal
{

    Day23_BSTLevelOrderTraversal()
    {
    }

    static void levelOrder(DoubleListNode root)
    {
        int h = height(root);
        for(int i = 1; i <= h; i++)
            printGivenLevel(root, i);

    }

    private static void printGivenLevel(DoubleListNode root, int level)
    {
        if(root == null)
            return;
        if(level == 1)
            System.out.print((new StringBuilder()).append(root.data).append(" ").toString());
        else
        if(level > 1)
        {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    static int height(DoubleListNode root)
    {
        if(root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        if(lheight > rheight)
            return lheight + 1;
        else
            return rheight + 1;
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

        levelOrder(root);
    }
}
