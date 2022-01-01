// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVisitorPattern.java

package com.hackerrank.pratice.java.advance;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.hackerrank.pratice.java.advance:
//            Tree, TreeVis, Color

class TreeNode extends Tree
{

    public TreeNode(int value, Color color, int depth)
    {
        super(value, color, depth);
        children = new ArrayList();
    }

    public void accept(TreeVis visitor)
    {
        visitor.visitNode(this);
        Tree child;
        for(Iterator iterator = children.iterator(); iterator.hasNext(); child.accept(visitor))
            child = (Tree)iterator.next();

    }

    public void addChild(Tree child)
    {
        children.add(child);
    }

    private ArrayList children;
}
