// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaAbstractClass.java

package pratice.hackerrank.pratice.java.oop;


abstract class Book
{

    Book()
    {
    }

    abstract void setTitle(String s);

    String getTitle()
    {
        return title;
    }

    String title;
}
