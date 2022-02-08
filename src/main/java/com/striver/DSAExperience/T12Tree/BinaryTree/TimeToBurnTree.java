package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.BinaryTreeNode;

import java.util.*;


public class TimeToBurnTree {
    static class Solution {
        // [Optimal] TC: O(n), O(n)
        // 1. find all node's parent pointer and mapped it.
        // 2. keep moving in each direction up(parent), left, right. and counting the time to burn
        // 3. possible traversal in all direction will be stored into queue
        public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
            int time = 0;

            Map<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();
            BinaryTreeNode<Integer> target = findParents(root, start, parent);

            Queue<BinaryTreeNode> q = new LinkedList<>();
            HashSet<BinaryTreeNode> visited = new HashSet<>();

            q.offer(target);
            visited.add(target);
            while (!q.isEmpty()) {
                int size = q.size();
                boolean burn = false;
                for (int i = 0; i < size; i++) {
                    BinaryTreeNode<Integer> curr = q.poll();
                    BinaryTreeNode<Integer> parentNode = parent.get(curr);
                    if (parent.containsKey(curr) && !visited.contains(parentNode)) {
                        q.offer(parentNode);
                        visited.add(parentNode);
                        burn = true;
                    }

                    if (curr.left != null && !visited.contains(curr.left)) {
                        q.offer(curr.left);
                        visited.add(curr.left);
                        burn = true;
                    }

                    if (curr.right != null && !visited.contains(curr.right)) {
                        q.offer(curr.right);
                        visited.add(curr.right);
                        burn = true;
                    }
                }
                if (burn)
                    time++;
            }
            return time;
        }

        private static BinaryTreeNode<Integer> findParents(BinaryTreeNode<Integer> root, int start,
                                                           Map<BinaryTreeNode, BinaryTreeNode> parent) {
            Queue<BinaryTreeNode> q = new LinkedList<>();
            BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);

            q.offer(root);
            while (!q.isEmpty()) {
                BinaryTreeNode<Integer> curr = q.poll();
                if (curr.data == start) res = curr;

                if (curr.left != null) {
                    q.offer(curr.left);
                    parent.put(curr.left, curr);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                    parent.put(curr.right, curr);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        BinaryTreeNode<Integer> root = BinaryTreeNode.toTree(new Integer[]{1, 2, 3, 4, null, 5, 6, null, 7});
        Out.print(sol.timeToBurnTree(root, 2));
    }
}
