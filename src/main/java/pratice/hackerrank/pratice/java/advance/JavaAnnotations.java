// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaAnnotations.java

package pratice.hackerrank.pratice.java.advance;

import java.lang.reflect.Method;
import java.util.Scanner;

// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            FamilyMember, FamilyBudget

public class JavaAnnotations
{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(int testCases = Integer.parseInt(in.nextLine()); testCases > 0; --testCases) {
            String role = in.next();
            int spend = in.nextInt();

            try {
                Class annotatedClass = FamilyMember.class;
                Method[] methods = annotatedClass.getMethods();
                Method[] var7 = methods;
                int var8 = methods.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    Method method = var7[var9];
                    if (method.isAnnotationPresent(FamilyBudget.class)) {
                        FamilyBudget family = (FamilyBudget)method.getAnnotation(FamilyBudget.class);
                        String userRole = family.userRole();
                        int budgetLimit = family.budgetLimit();
                        if (userRole.equals(role)) {
                            if (spend <= budgetLimit) {
                                method.invoke(FamilyMember.class.newInstance(), budgetLimit, spend);
                            } else {
                                System.out.println("Budget Limit Over");
                            }
                        }
                    }
                }
            } catch (Exception var14) {
                var14.printStackTrace();
            }
        }
    }
}
