package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.Stack;

// [Optimal] TC: O(1), SC: O(H) - storing all left node, while popping store the right node all left node
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        if (root != null)
            pushMostLeft(root);
    }

    public int next() {
        TreeNode ref = st.pop();
        if (ref.right != null)
            pushMostLeft(ref.right);
        return ref.val;
    }

    private void pushMostLeft(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

public class BSTIterator_medium_173 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.toTree(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator it = new BSTIterator(root);
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}
