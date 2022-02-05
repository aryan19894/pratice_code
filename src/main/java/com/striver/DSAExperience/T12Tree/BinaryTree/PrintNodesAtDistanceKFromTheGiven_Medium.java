package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;

import java.util.*;

public class PrintNodesAtDistanceKFromTheGiven_Medium {
    static class Solution {
        static class TreeNode<T> {
            public T data;
            public TreeNode<T> left;
            public TreeNode<T> right;

            TreeNode(T data) {
                this.data = data;
                left = null;
                right = null;
            }
        }

        // [Optimal] TC: O(n), O(n)
        // 1. find all node's parent pointer and mapped it.
        // 2. keep moving in each direction up(parent), left, right. and keep track of distance
        // 3. possible traversal in all direction will be stored into queue
        public static ArrayList<Integer> kDistance(TreeNode<Integer> root, int target, int k) {
            ArrayList<Integer> result = new ArrayList<Integer>();

            Map<TreeNode, TreeNode> parent = new HashMap<>();
            TreeNode<Integer> targetNode = findParents(root, target, parent);

            Queue<TreeNode> q = new LinkedList<>();
            HashSet<TreeNode> visited = new HashSet<>();

            q.offer(targetNode);
            visited.add(targetNode);
            int currentLev = 0;
            while (!q.isEmpty()) {
                if (currentLev++ == k) break;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode<Integer> current = q.poll();
                    //upward
                    TreeNode<Integer> parentNode = parent.get(current);
                    if (parent.containsKey(current) && !visited.contains(parentNode)) {
                        q.offer(parentNode);
                        visited.add(parentNode);
                    }
                    //left
                    if (current.left != null && !visited.contains(current.left)) {
                        q.offer(current.left);
                        visited.add(current.left);
                    }
                    //right
                    if (current.right != null && !visited.contains(current.right)) {
                        q.offer(current.right);
                        visited.add(current.right);
                    }
                }
            }

            while (!q.isEmpty())
                result.add((Integer) q.poll().data);

            return result;
        }

        private static TreeNode<Integer> findParents(TreeNode<Integer> root, int target,
                                                     Map<TreeNode, TreeNode> parent) {
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode<Integer> res = new TreeNode<>(-1);

            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode<Integer> node = q.poll();
                if (node.data == target) res = node;

                if (node.left != null) {
                    q.offer(node.left);
                    parent.put(node.left, node);
                }
                if (node.right != null) {
                    q.offer(node.right);
                    parent.put(node.right, node);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Solution.TreeNode<Integer> root = new Solution.TreeNode<>(3);
        root.left = new Solution.TreeNode(5);
        root.left.left = new Solution.TreeNode(6);
        root.left.right = new Solution.TreeNode(2);
        root.left.right.left = new Solution.TreeNode(7);
        root.left.right.right = new Solution.TreeNode(4);
        root.right = new Solution.TreeNode(1);
        root.right.left = new Solution.TreeNode(0);
        root.right.right = new Solution.TreeNode(8);

        int target = 5;
        int k = 2;
        Out.print(sol.kDistance(root, target, k));
    }
}
