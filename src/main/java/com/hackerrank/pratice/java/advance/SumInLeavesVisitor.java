// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVisitorPattern.java

package com.hackerrank.pratice.java.advance;


// Referenced classes of package com.hackerrank.pratice.java.advance:
//            TreeVis, TreeLeaf, TreeNode

class SumInLeavesVisitor extends TreeVis
{

    SumInLeavesVisitor()
    {
        result = 0;
    }

    public int getResult()
    {
        return result;
    }

    public void visitNode(TreeNode treenode)
    {
    }

    public void visitLeaf(TreeLeaf leaf)
    {
        result += leaf.getValue();
    }

    private int result;
}
