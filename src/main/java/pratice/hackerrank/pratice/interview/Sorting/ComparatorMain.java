// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ComparatorMain.java

package pratice.hackerrank.pratice.interview.Sorting;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.interview.Sorting:
//            Player, Checker

public class ComparatorMain
{

    public ComparatorMain()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Player player[] = new Player[n];
        Checker checker = new Checker();
        for(int i = 0; i < n; i++)
            player[i] = new Player(scan.next(), scan.nextInt());

        scan.close();
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++)
            System.out.printf("%s %s\n", new Object[] {
                player[i].name, Integer.valueOf(player[i].score)
            });

    }
}
