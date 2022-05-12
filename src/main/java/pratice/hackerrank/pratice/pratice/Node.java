// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BinarySearchTree.java

package pratice.hackerrank.pratice.pratice;


class Node
{

    Node(int t)
    {
        data = t;
        prev = null;
        next = null;
    }

    Node prev;
    int data;
    Node next;
}
