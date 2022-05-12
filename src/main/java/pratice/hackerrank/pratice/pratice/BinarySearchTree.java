// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BinarySearchTree.java

package pratice.hackerrank.pratice.pratice;

import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.pratice:
//            Node

public class BinarySearchTree
{

    public BinarySearchTree()
    {
    }

    public static Node insert(Node head, int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return head;
        }
        Node ref;
        for(ref = head; ref.next != null;)
            if(ref.data <= newNode.data)
                ref = ref.next;
            else
                ref = ref.prev;

        if(ref.data <= newNode.data)
            ref.next = newNode;
        else
            ref.prev = newNode;
        return head;
    }

    public static void display(Node head)
    {
        for(Node start = head; start != null; start = start.next)
            System.out.print((new StringBuilder()).append(start.prev).append("|").append(start.data).append("|").append(start.next).append(" ").toString());

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        for(int N = sc.nextInt(); N-- > 0;)
        {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }

        display(head);
        sc.close();
    }
}
