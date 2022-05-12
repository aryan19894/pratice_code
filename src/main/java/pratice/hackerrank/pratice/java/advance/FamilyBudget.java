// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaAnnotations.java

package pratice.hackerrank.pratice.java.advance;

import java.lang.annotation.Annotation;

interface FamilyBudget
    extends Annotation
{

    public abstract String userRole();

    public abstract int budgetLimit();
}
