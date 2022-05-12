package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.Node;
import pratice.striver.DSAExperience.T12Tree.common.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopView_Medium {
    static class Solution {
        // [Optimal: Recursive] - NOT ALLOWED - we will get the last node instead of first node of each vertical level.
        // recursive call follow top to bottom approach, so last node is traversed first, and it will map first.
        // [Optimal: Iterative] TC: O(n) - using vertical level order traversal rule
        // SC: O(n) for queue
        static ArrayList<Integer> topView(Node root) {
            ArrayList<Integer> result = new ArrayList<>();
            if (root == null) return result;

            TreeMap<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<Pair>();

            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Pair pair = q.poll();
                    Node ref = pair.node;
                    int hDist = pair.hd;

                    map.putIfAbsent(hDist, ref.data);
                    if (ref.left != null)
                        q.offer(new Pair(ref.left, hDist - 1));
                    if (ref.right != null)
                        q.offer(new Pair(ref.right, hDist + 1));
                }
            }

            for (Integer v : map.values())
                result.add(v);

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = Node.toTree("1 2 3 4 10 9 10 N 5 N N N N N N N 6");
        Out.print(sol.topView(root));
    }
}
