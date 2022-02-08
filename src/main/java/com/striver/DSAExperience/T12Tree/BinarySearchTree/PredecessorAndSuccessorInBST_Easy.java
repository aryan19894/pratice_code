package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.BinaryTreeNode;

import java.util.ArrayList;

public class PredecessorAndSuccessorInBST_Easy {
    static class Solution {

        public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
            ArrayList<Integer> res = new ArrayList<>();

            res.add(predecessor(root, key).data);
            res.add(successor(root, key).data);
            return res;
        }

        private static BinaryTreeNode<Integer> predecessor(BinaryTreeNode<Integer> root, int key) {
            BinaryTreeNode<Integer> predecessor = new BinaryTreeNode(-1);
            while (root != null) {
                if (key > root.data) {
                    predecessor = root;
                    root = root.right;
                } else
                    root = root.left;
            }
            return predecessor;
        }

        private static BinaryTreeNode<Integer> successor(BinaryTreeNode<Integer> root, int key) {
            BinaryTreeNode<Integer> successor = new BinaryTreeNode(-1);
            while (root != null) {
                if (key >= root.data)
                    root = root.right;
                else {
                    successor = root;
                    root = root.left;
                }
            }
            return successor;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        BinaryTreeNode<Integer> root = BinaryTreeNode.toTree(" ", "15 10 20 8 12 16 25");

        int key = 10;
        Out.print(sol.predecessorSuccessor(root, key));
    }
}
