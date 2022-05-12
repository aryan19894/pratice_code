// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day13_AbstractClasses.java

package pratice.hackerrank.pratice.Day30OfCode;


abstract class Book
{

    Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }

    abstract void display();

    String title;
    String author;
}
