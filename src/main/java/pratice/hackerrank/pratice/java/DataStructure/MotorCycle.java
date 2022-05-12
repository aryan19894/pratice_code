// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaMethodOverriding2SuperKeyword.java

package pratice.hackerrank.pratice.java.DataStructure;

// Referenced classes of package pratice.hackerrank.pratice.java.DataStructure:
//            BiCycle

class MotorCycle extends BiCycle
{

    String define_me()
    {
        return "a cycle with an engine.";
    }

    MotorCycle()
    {
        System.out.println((new StringBuilder()).append("Hello I am a motorcycle, I am ").append(define_me()).toString());
        String temp = super.define_me();
        System.out.println((new StringBuilder()).append("My ancestor is a cycle who is ").append(temp).toString());
    }
}
