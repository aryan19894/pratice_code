package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.gfg.companywise.amazon.VerticalTraversalOfBinaryTree;
import com.striver.DSAExperience.T12Tree.common.Node;
import com.striver.DSAExperience.T12Tree.common.TreeNode;
import com.striver.DSAExperience.T12Tree.common.TreeTuple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class VerticalOrderTraversal_hard_987 {
    static class Solution {
        // [Optimal] TC: O(NlogN) - logN fo priorityQueue - using level order traversal
        // SC: O(N) map
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
            Queue<TreeTuple> q = new LinkedList<TreeTuple>();

            if (root == null) return result;

            q.offer(new TreeTuple(root, 0, 0));
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeTuple ref = q.poll();
                    TreeNode node = ref.node;
                    int x = ref.row;
                    int y = ref.col;

                    map.putIfAbsent(x, new TreeMap<>());
                    map.get(x).putIfAbsent(y, new PriorityQueue<>());
                    map.get(x).get(y).offer(node.val);

                    if (node.left != null)
                        q.offer(new TreeTuple(node.left, x - 1, y + 1));
                    if (node.right != null)
                        q.offer(new TreeTuple(node.right, x + 1, y + 1));
                }
            }

            for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
                result.add(new ArrayList<>());
                for (PriorityQueue<Integer> node : ys.values())
                    while (!node.isEmpty())
                        result.get(result.size() - 1).add(node.poll());
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(10);
//        root.left.left.right = new TreeNode(5);
//        root.left.left.right.right = new TreeNode(6);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(9);
//        root.right.right = new TreeNode(10);

        TreeNode root = TreeNode.toTree(readFile());
        Out.print(sol.verticalTraversal(root));
    }

    private static String readFile() throws IOException {
        File file = new File(
                "E:\\code\\DSA\\Platform\\testcase\\fileInput.txt");

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        String res = "", line = "";
        while ((line = br.readLine()) != null)
            res += line;
        return res;
    }
}
