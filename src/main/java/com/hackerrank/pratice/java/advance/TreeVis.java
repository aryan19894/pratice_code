// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVisitorPattern.java

package com.hackerrank.pratice.java.advance;


// Referenced classes of package com.hackerrank.pratice.java.advance:
//            TreeNode, TreeLeaf

abstract class TreeVis
{

    TreeVis()
    {
    }

    public abstract int getResult();

    public abstract void visitNode(TreeNode treenode);

    public abstract void visitLeaf(TreeLeaf treeleaf);
}
