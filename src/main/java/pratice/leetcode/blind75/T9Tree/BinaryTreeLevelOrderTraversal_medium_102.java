package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;
import pratice.leetcode.blind75.T9Tree.common.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_medium_102 {
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Map<Integer, List<Integer>> map = new LinkedHashMap<>();

            if (root == null) return result;
            dfs(root, 0, map);

            return new ArrayList<>(map.values());
        }

        private void dfs(TreeNode root, int level, Map<Integer, List<Integer>> map) {
            if (root == null) return;

            map.putIfAbsent(level, new ArrayList<>());
            map.get(level).add(root.val);

            dfs(root.left, level + 1, map);
            dfs(root.right, level + 1, map);
        }

        public List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> q = new LinkedList<>();
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
                result.add(subList);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree("3,9,20,null,null,15,7");
        Out.print(sol.levelOrder(root));
        Out.print(sol.levelOrder2(root));
    }
}
