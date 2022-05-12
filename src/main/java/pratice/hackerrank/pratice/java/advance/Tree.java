// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVisitorPattern.java

package pratice.hackerrank.pratice.java.advance;


// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            Color, TreeVis

abstract class Tree
{

    public Tree(int value, Color color, int depth)
    {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue()
    {
        return value;
    }

    public Color getColor()
    {
        return color;
    }

    public int getDepth()
    {
        return depth;
    }

    public abstract void accept(TreeVis treevis);

    private int value;
    private Color color;
    private int depth;
}
