// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVisitorPattern.java

package com.hackerrank.pratice.java.advance;


// Referenced classes of package com.hackerrank.pratice.java.advance:
//            TreeVis, TreeNode, TreeLeaf, Color

class FancyVisitor extends TreeVis
{

    FancyVisitor()
    {
        nonLeafEvenDepthSum = 0;
        greenLeavesSum = 0;
    }

    public int getResult()
    {
        return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node)
    {
        if(node.getDepth() % 2 == 0)
            nonLeafEvenDepthSum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf)
    {
        if(leaf.getColor() == Color.GREEN)
            greenLeavesSum += leaf.getValue();
    }

    private int nonLeafEvenDepthSum;
    private int greenLeavesSum;
}
