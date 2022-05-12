// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVisitorPattern.java

package pratice.hackerrank.pratice.java.advance;


// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            TreeVis, TreeNode, Color, TreeLeaf

class ProductOfRedNodesVisitor extends TreeVis
{

    ProductOfRedNodesVisitor()
    {
        result = 1L;
    }

    public int getResult()
    {
        return (int)result;
    }

    public void visitNode(TreeNode node)
    {
        if(node.getColor() == Color.RED)
            result = (result * (long)node.getValue()) % 0x3b9aca07L;
    }

    public void visitLeaf(TreeLeaf leaf)
    {
        if(leaf.getColor() == Color.RED)
            result = (result * (long)leaf.getValue()) % 0x3b9aca07L;
    }

    private long result;
    private final int M = 0x3b9aca07;
}
