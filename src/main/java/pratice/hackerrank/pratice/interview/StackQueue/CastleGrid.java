// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CastleGrid.java

package pratice.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package pratice.hackerrank.pratice.interview.StackQueue:
//            Point

public class CastleGrid
{

    public CastleGrid()
    {
    }

    static int minimumMoves(String grid[], int startX, int startY, int goalX, int goalY)
    {
        n = grid.length;
        game = new int[n][n];
        helper = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                if(grid[i].charAt(j) == '.')
                    game[i][j] = 100;
                else
                    game[i][j] = -1;

        }

        Point start = new Point(startX, startY);
        move.add(start);
        game[startX][startY] = 0;
        do
        {
            if(move.isEmpty())
                break;
            Point current = (Point)move.remove();
            if(helper[current.x][current.y] == 0)
            {
                helper[current.x][current.y] = 1;
                moveGenerator(current);
            }
        } while(true);
        return game[goalX][goalY];
    }

    public static void moveGenerator(Point p)
    {
        int x = p.x;
        int y = p.y;
        int value = game[x][y];
        for(int i = x; i < n && game[i][y] != -1; i++)
        {
            addStep(i, y, value);
            move.add(new Point(i, y));
        }

        for(int i = x; i >= 0 && game[i][y] != -1; i--)
        {
            addStep(i, y, value);
            move.add(new Point(i, y));
        }

        for(int i = y; i < n && game[x][i] != -1; i++)
        {
            addStep(x, i, value);
            move.add(new Point(x, i));
        }

        for(int i = y; i >= 0 && game[x][i] != -1; i--)
        {
            addStep(x, i, value);
            move.add(new Point(x, i));
        }

    }

    public static void addStep(int x, int y, int value)
    {
        if(game[x][y] > value + 1)
            game[x][y] = value + 1;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String grid[] = new String[n];
        scan.skip("(\r\n|[\n\r\u2028\u2029\205])?");
        for(int i = 0; i < n; i++)
        {
            String gridItem = scan.nextLine();
            grid[i] = gridItem;
        }

        String index = scan.nextLine();
        String startXStartY[] = index.split(" ");
        int startX = Integer.parseInt(startXStartY[0]);
        int startY = Integer.parseInt(startXStartY[1]);
        int goalX = Integer.parseInt(startXStartY[2]);
        int goalY = Integer.parseInt(startXStartY[3]);
        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result);
        scan.close();
    }

    static int game[][];
    static int helper[][];
    static Queue move = new LinkedList();
    static int n;

}
