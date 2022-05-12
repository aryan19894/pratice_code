package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.*;

public class LevelOrderTraversal_medium_102 {
    static class Solution {
        // [Optimal Iterative] TC: O(n) - using queue to keep track from its children w.r.t levels
        // SC: O(n) - result list and queue
        public List<List<Integer>> levelOrder1(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root == null) return res;

            //storing first element root
            q.offer(root);
            while (!q.isEmpty()) {
                int levelNum = q.size();
                List<Integer> subList = new ArrayList<>();
                for (int i = 0; i < levelNum; i++) {
                    TreeNode ref = q.poll();
                    if (ref.left != null) q.offer(ref.left);
                    if (ref.right != null) q.offer(ref.right);
                    subList.add(ref.val);
                }
                res.add(subList);
            }
            return res;
        }

        // [Optimal Recursive] TC: O(n) - using map to keep track with level number and its nodes
        // SC: O(n) -map and auxiliary stack space for recursive call
        public List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Map<Integer, List<Integer>> map = new TreeMap();

            if (root == null) return res;

            dfs(root, 0, map);
            for (List<Integer> list : map.values())
                res.add(list);

            return res;
        }

        private void dfs(TreeNode node, int level,
                         Map<Integer, List<Integer>> map) {
            if (node == null) return;
            map.putIfAbsent(level, new ArrayList<>());
            map.get(level).add(node.val);

            dfs(node.left, level + 1, map);
            dfs(node.right, level + 1, map);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = sol.levelOrder1(root);
        Out.print(res);

        res = sol.levelOrder2(root);
        Out.print(res);
    }
}
