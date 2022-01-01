// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MergeSortALinkedList.java

package com.pepcoding.beginner.BasicDS.LinkedList;

import java.io.*;

public class MergeSortALinkedList
{
    public static class LinkedList
    {

        void addLast(int val)
        {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0)
            {
                head = tail = temp;
            } else
            {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public int size()
        {
            return size;
        }

        public void display()
        {
            for(Node temp = head; temp != null; temp = temp.next)
                System.out.print((new StringBuilder()).append(temp.data).append(" ").toString());

            System.out.println();
        }

        public void removeFirst()
        {
            if(size == 0)
                System.out.println("List is empty");
            else
            if(size == 1)
            {
                head = tail = null;
                size = 0;
            } else
            {
                head = head.next;
                size--;
            }
        }

        public int getFirst()
        {
            if(size == 0)
            {
                System.out.println("List is empty");
                return -1;
            } else
            {
                return head.data;
            }
        }

        public int getLast()
        {
            if(size == 0)
            {
                System.out.println("List is empty");
                return -1;
            } else
            {
                return tail.data;
            }
        }

        public int getAt(int idx)
        {
            if(size == 0)
            {
                System.out.println("List is empty");
                return -1;
            }
            if(idx < 0 || idx >= size)
            {
                System.out.println("Invalid arguments");
                return -1;
            }
            Node temp = head;
            for(int i = 0; i < idx; i++)
                temp = temp.next;

            return temp.data;
        }

        public void addFirst(int val)
        {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
            if(size == 0)
                tail = temp;
            size++;
        }

        public void addAt(int idx, int val)
        {
            if(idx < 0 || idx > size)
                System.out.println("Invalid arguments");
            else
            if(idx == 0)
                addFirst(val);
            else
            if(idx == size)
            {
                addLast(val);
            } else
            {
                Node node = new Node();
                node.data = val;
                Node temp = head;
                for(int i = 0; i < idx - 1; i++)
                    temp = temp.next;

                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }

        public void removeLast()
        {
            if(size == 0)
                System.out.println("List is empty");
            else
            if(size == 1)
            {
                head = tail = null;
                size = 0;
            } else
            {
                Node temp = head;
                for(int i = 0; i < size - 2; i++)
                    temp = temp.next;

                tail = temp;
                tail.next = null;
                size--;
            }
        }

        public void removeAt(int idx)
        {
            if(idx < 0 || idx >= size)
                System.out.println("Invalid arguments");
            else
            if(idx == 0)
                removeFirst();
            else
            if(idx == size - 1)
            {
                removeLast();
            } else
            {
                Node temp = head;
                for(int i = 0; i < idx - 1; i++)
                    temp = temp.next;

                temp.next = temp.next.next;
                size--;
            }
        }

        private Node getNodeAt(int idx)
        {
            Node temp = head;
            for(int i = 0; i < idx; i++)
                temp = temp.next;

            return temp;
        }

        public void reverseDI()
        {
            int li = 0;
            for(int ri = size - 1; li < ri; ri--)
            {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
                li++;
            }

        }

        public void reversePI()
        {
            if(size <= 1)
                return;
            Node prev = null;
            Node next;
            for(Node curr = head; curr != null; curr = next)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
            }

            Node temp = head;
            head = tail;
            tail = temp;
        }

        public int kthFromLast(int k)
        {
            Node slow = head;
            Node fast = head;
            for(int i = 0; i < k; i++)
                fast = fast.next;

            for(; fast != tail; fast = fast.next)
                slow = slow.next;

            return slow.data;
        }

        public int mid()
        {
            Node f = head;
            Node s;
            for(s = head; f.next != null && f.next.next != null; s = s.next)
                f = f.next.next;

            return s.data;
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2)
        {
            LinkedList ml = new LinkedList();
            Node one = l1.head;
            Node two;
            for(two = l2.head; one != null && two != null;)
                if(one.data < two.data)
                {
                    ml.addLast(one.data);
                    one = one.next;
                } else
                {
                    ml.addLast(two.data);
                    two = two.next;
                }

            for(; one != null; one = one.next)
                ml.addLast(one.data);

            for(; two != null; two = two.next)
                ml.addLast(two.data);

            return ml;
        }

        public static LinkedList mergeSort(Node head, Node tail)
        {
            if(head == tail)
            {
                LinkedList br = new LinkedList();
                br.addLast(head.data);
                return br;
            }
            Node f = head;
            Node s;
            for(s = head; f != tail && f.next != tail; s = s.next)
                f = f.next.next;

            Node mid = s;
            LinkedList left = mergeSort(head, mid);
            LinkedList right = mergeSort(mid.next, tail);
            return mergeTwoSortedLists(left, right);
        }

        Node head;
        Node tail;
        int size;

        public LinkedList()
        {
        }
    }

    public static class Node
    {

        int data;
        Node next;

        public Node()
        {
        }
    }


    public MergeSortALinkedList()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String values1[] = br.readLine().split(" ");
        for(int i = 0; i < n1; i++)
        {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
        sorted.display();
        l1.display();
    }
}
