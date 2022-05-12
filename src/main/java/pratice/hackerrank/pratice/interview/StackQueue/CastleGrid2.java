// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CastleGrid2.java

package pratice.hackerrank.pratice.interview.StackQueue;

import java.io.PrintStream;
import java.util.*;

public class CastleGrid2
{
    static class Position
    {

        int row;
        int col;
        int number;

        public Position(int row, int col, int number)
        {
            this.row = row;
            this.col = col;
            this.number = number;
        }
    }


    public CastleGrid2()
    {
    }

    static int minimumMoves(String grid[], int startX, int startY, int goalX, int goalY)
    {
        ArrayDeque queue = new ArrayDeque();
        int matrix[][] = new int[grid.length][grid.length];
        for(int i = 0; i < grid.length; i++)
        {
            String curr = grid[i];
            for(int j = 0; j < curr.length(); j++)
                matrix[i][j] = curr.charAt(j) != '.' ? -1 : 1;

        }

        Position pos = new Position(startX, startY, 0);
        queue.offer(pos);
        Position current;
        for(; !queue.isEmpty(); addMoves(queue, current, matrix))
        {
            current = (Position)queue.poll();
            if(current.row == goalX && current.col == goalY)
                return current.number;
            matrix[current.row][current.col] = 0;
        }

        return -1;
    }

    static void addMoves(Queue queue, Position current, int matrix[][])
    {
        int row = current.row;
        int col = current.col;
        int number = current.number + 1;
        while(--row >= 0 && matrix[row][col] == 1) 
            queue.offer(new Position(row, col, number));
        row = current.row;
        for(col = current.col; ++row < matrix.length && matrix[row][col] == 1;)
            queue.offer(new Position(row, col, number));

        row = current.row;
        for(col = current.col; --col >= 0 && matrix[row][col] == 1;)
            queue.offer(new Position(row, col, number));

        row = current.row;
        for(col = current.col; ++col < matrix.length && matrix[row][col] == 1;)
            queue.offer(new Position(row, col, number));

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
}
