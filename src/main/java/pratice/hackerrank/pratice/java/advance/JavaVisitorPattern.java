// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaVisitorPattern.java

package pratice.hackerrank.pratice.java.advance;

import java.util.*;

// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            Color, TreeLeaf, TreeNode, SumInLeavesVisitor, 
//            ProductOfRedNodesVisitor, FancyVisitor, Tree

public class JavaVisitorPattern
{

    public JavaVisitorPattern()
    {
    }

    public static Tree solve()
    {
        Scanner scan = new Scanner(System.in);
        int numNodes = scan.nextInt();
        values = new int[numNodes];
        colors = new Color[numNodes];
        map = new HashMap(numNodes);
        for(int i = 0; i < numNodes; i++)
            values[i] = scan.nextInt();

        for(int i = 0; i < numNodes; i++)
            colors[i] = scan.nextInt() != 0 ? Color.GREEN : Color.RED;

        for(int i = 0; i < numNodes - 1; i++)
        {
            int u = scan.nextInt();
            int v = scan.nextInt();
            HashSet uNeighbors = (HashSet)map.get(Integer.valueOf(u));
            if(uNeighbors == null)
            {
                uNeighbors = new HashSet();
                map.put(Integer.valueOf(u), uNeighbors);
            }
            uNeighbors.add(Integer.valueOf(v));
            HashSet vNeighbors = (HashSet)map.get(Integer.valueOf(v));
            if(vNeighbors == null)
            {
                vNeighbors = new HashSet();
                map.put(Integer.valueOf(v), vNeighbors);
            }
            vNeighbors.add(Integer.valueOf(u));
        }

        scan.close();
        if(numNodes == 1)
        {
            return new TreeLeaf(values[0], colors[0], 0);
        } else
        {
            TreeNode root = new TreeNode(values[0], colors[0], 0);
            addChildren(root, Integer.valueOf(1));
            return root;
        }
    }

    private static void addChildren(TreeNode parent, Integer parentNum)
    {
        Iterator iterator = ((HashSet)map.get(parentNum)).iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Integer treeNum = (Integer)iterator.next();
            ((HashSet)map.get(treeNum)).remove(parentNum);
            HashSet grandChildren = (HashSet)map.get(treeNum);
            boolean childHasChild = grandChildren != null && !grandChildren.isEmpty();
            Tree tree;
            if(childHasChild)
                tree = new TreeNode(values[treeNum.intValue() - 1], colors[treeNum.intValue() - 1], parent.getDepth() + 1);
            else
                tree = new TreeLeaf(values[treeNum.intValue() - 1], colors[treeNum.intValue() - 1], parent.getDepth() + 1);
            parent.addChild(tree);
            if(tree instanceof TreeNode)
                addChildren((TreeNode)tree, treeNum);
        } while(true);
    }

    public static void main(String args[])
    {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();
        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);
        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    private static int values[];
    private static Color colors[];
    private static HashMap map;
}
