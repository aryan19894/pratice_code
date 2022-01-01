// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaAnnotations.java

package com.hackerrank.pratice.java.advance;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Scanner;

// Referenced classes of package com.hackerrank.pratice.java.advance:
//            FamilyMember, FamilyBudget

public class JavaAnnotations
{

    public JavaAnnotations()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
label0:
        for(int testCases = Integer.parseInt(in.nextLine()); testCases > 0; testCases--)
        {
            String role = in.next();
            int spend = in.nextInt();
            try
            {
                Class annotatedClass = com/hackerrank/pratice/java/advance/FamilyMember;
                Method methods[] = annotatedClass.getMethods();
                Method amethod[] = methods;
                int i = amethod.length;
                int j = 0;
                do
                {
                    if(j >= i)
                        continue label0;
                    Method method = amethod[j];
                    if(method.isAnnotationPresent(com/hackerrank/pratice/java/advance/FamilyBudget))
                    {
                        FamilyBudget family = (FamilyBudget)method.getAnnotation(com/hackerrank/pratice/java/advance/FamilyBudget);
                        String userRole = family.userRole();
                        int budgetLimit = family.budgetLimit();
                        if(userRole.equals(role))
                            if(spend <= budgetLimit)
                                method.invoke(com/hackerrank/pratice/java/advance/FamilyMember.newInstance(), new Object[] {
                                    Integer.valueOf(budgetLimit), Integer.valueOf(spend)
                                });
                            else
                                System.out.println("Budget Limit Over");
                    }
                    j++;
                } while(true);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
