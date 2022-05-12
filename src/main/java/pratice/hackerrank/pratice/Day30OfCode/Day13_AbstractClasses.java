// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day13_AbstractClasses.java

package pratice.hackerrank.pratice.Day30OfCode;

import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.Day30OfCode:
//            MyBook, Book

public class Day13_AbstractClasses
{

    public Day13_AbstractClasses()
    {
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();
        Book book = new MyBook(title, author, price);
        book.display();
    }
}
