// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day13_AbstractClasses.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;

// Referenced classes of package com.hackerrank.pratice.Day30OfCode:
//            Book

class MyBook extends Book
{

    MyBook(String title, String author, int price)
    {
        super(title, author);
        this.price = price;
    }

    void display()
    {
        System.out.println((new StringBuilder()).append("Title: ").append(title).toString());
        System.out.println((new StringBuilder()).append("Author: ").append(author).toString());
        System.out.println((new StringBuilder()).append("Price: ").append(price).toString());
    }

    int price;
}
