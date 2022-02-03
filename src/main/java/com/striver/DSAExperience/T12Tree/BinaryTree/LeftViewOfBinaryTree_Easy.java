package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.Node;

import java.util.ArrayList;

public class LeftViewOfBinaryTree_Easy {
    static class Solution {
        // [Optimal: Recursive] TC: O(n) - we use PreOrder traversal
        // We call the recursive function for the Left than the right node
        // SC: O(H)  H -> Height of the Tree
        // we prefer recursive it has SC: O(H) but in iterative it has SC: O(N)
        public ArrayList<Integer> leftView(Node root) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            levelOrder(root, result, 0);
            return result;
        }

        private void levelOrder(Node node, ArrayList<Integer> result, int level) {
            if (node == null) return;
            if (level == result.size())
                result.add(node.data);

            levelOrder(node.left, result, level + 1);
            levelOrder(node.right, result, level + 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = Node.toTree("1 2 3 4 5 6 7 N 8");
        Out.print(sol.leftView(root));
    }
}
