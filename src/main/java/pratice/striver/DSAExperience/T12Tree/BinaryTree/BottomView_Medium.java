package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.Node;
import pratice.striver.DSAExperience.T12Tree.common.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView_Medium {
    static class Solution {
        // [Optimal: Recursive] - NOT ALLOWED - we will get the first node instead of last node of each vertical level.
        // recursive call follow top to bottom approach, so last node is traversed first then its previous node,
        // and it will replace the mapped first element.
        // [Optimal1: Iterative] TC: O(n) - using vertical level order traversal rule
        // SC: O(n) for queue
        //we created new class Pair with node and its horizontal distance
        public ArrayList<Integer> bottomView1(Node root) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            if (root == null) return result;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<Pair>();

            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {
                Pair pair = q.poll();
                Node ref = pair.node;
                int hd = pair.hd;

                map.put(hd, ref.data);
                if (ref.left != null)
                    q.offer(new Pair(ref.left, hd - 1));
                if (ref.right != null)
                    q.offer(new Pair(ref.right, hd + 1));
            }
            for (Integer v : map.values())
                result.add(v);
            return result;
        }

        // [Optimal2: Iterative] TC: O(n) - using vertical level order traversal rule
        // SC: O(n) for queue
        // we update node attribute with horizontal distance
        public ArrayList<Integer> bottomView2(Node root) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            if (root == null) return result;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Queue<Node> q = new LinkedList<>();

            root.hd = 0;
            q.offer(root);
            while (!q.isEmpty()) {
                Node ref = q.poll();
                int hd = ref.hd;

                map.put(ref.hd, ref.data);
                if (ref.left != null) {
                    ref.left.hd = hd - 1;
                    q.offer(ref.left);
                }
                if (ref.right != null) {
                    ref.right.hd = hd + 1;
                    q.offer(ref.right);
                }
            }
            for (Integer v : map.values())
                result.add(v);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //Node root = Arrays.toTree("1 2 3 4 10 9 10 N 5 N N N N N N N 6");
        Node root = Node.toTree("1 2 3 4 5 6 7 N N 8 9");
        Out.print(sol.bottomView1(root));
        Out.print(sol.bottomView2(root));
    }
}
