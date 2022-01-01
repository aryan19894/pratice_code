// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MidOfLinkedList.java

package com.pepcoding.beginner.BasicDS.LinkedList;

import java.io.*;

public class MidOfLinkedList
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
            Node s = head;
            for(Node f = head; f.next != null && f.next.next != null; f = f.next.next)
                s = s.next;

            return s.data;
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


    public MidOfLinkedList()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
        for(String str = br.readLine(); !str.equals("quit"); str = br.readLine())
        {
            if(str.startsWith("addLast"))
            {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
                continue;
            }
            if(str.startsWith("size"))
            {
                System.out.println(list.size());
                continue;
            }
            if(str.startsWith("display"))
            {
                list.display();
                continue;
            }
            if(str.startsWith("removeFirst"))
            {
                list.removeFirst();
                continue;
            }
            if(str.startsWith("getFirst"))
            {
                int val = list.getFirst();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("getLast"))
            {
                int val = list.getLast();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("getAt"))
            {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = list.getAt(idx);
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("addFirst"))
            {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
                continue;
            }
            if(str.startsWith("addAt"))
            {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = Integer.parseInt(str.split(" ")[2]);
                list.addAt(idx, val);
                continue;
            }
            if(str.startsWith("removeLast"))
            {
                list.removeLast();
                continue;
            }
            if(str.startsWith("removeAt"))
            {
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
                continue;
            }
            if(str.startsWith("reverseDI"))
            {
                list.reverseDI();
                continue;
            }
            if(str.startsWith("reversePI"))
            {
                list.reversePI();
                continue;
            }
            if(str.startsWith("kthFromEnd"))
            {
                int idx = Integer.parseInt(str.split(" ")[1]);
                System.out.println(list.kthFromLast(idx));
                continue;
            }
            if(str.startsWith("mid"))
                System.out.println(list.mid());
        }

    }
}
