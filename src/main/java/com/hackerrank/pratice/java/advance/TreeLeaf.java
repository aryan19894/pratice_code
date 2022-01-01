// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVisitorPattern.java

package com.hackerrank.pratice.java.advance;


// Referenced classes of package com.hackerrank.pratice.java.advance:
//            Tree, TreeVis, Color

class TreeLeaf extends Tree
{

    public TreeLeaf(int value, Color color, int depth)
    {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor)
    {
        visitor.visitLeaf(this);
    }
}
