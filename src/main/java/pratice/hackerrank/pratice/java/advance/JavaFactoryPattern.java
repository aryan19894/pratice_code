// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaFactoryPattern.java

package pratice.hackerrank.pratice.java.advance;

import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            FoodFactory, Do_Not_Terminate, Food

public class JavaFactoryPattern
{

    public JavaFactoryPattern()
    {
    }

    public static void main(String args[])
    {
        Do_Not_Terminate.forbidExit();
        try
        {
            Scanner sc = new Scanner(System.in);
            FoodFactory foodFactory = new FoodFactory();
            Food food = foodFactory.getFood(sc.nextLine());
            System.out.println((new StringBuilder()).append("The factory returned ").append(food.getClass()).toString());
            System.out.println(food.getType());
        }
        catch(Do_Not_Terminate.ExitTrappedException e)
        {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}
