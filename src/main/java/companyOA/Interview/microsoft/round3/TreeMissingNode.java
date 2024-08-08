package companyOA.Interview.microsoft.round3;

class Node {
    Node left;
    int data;
    Node right;
}

class TreeTraverse {

    public static int countNode(Node root) {
        if (root == null)
            return 0;
        return (1 + countNode(root.left) + countNode(root.right));
    }

    public static Node findMissing(Node root, int idx, int numberOfNode) {

        if (root == null || idx >= numberOfNode) {
            Node ref = root;
            ref.data = idx + 1;
            return ref;
        }

        findMissing(root.left, 2 * idx + 1, numberOfNode);
        findMissing(root.right, 2 * idx + 2, numberOfNode);

        return null;
    }
}

public class TreeMissingNode {
    public static void main(String[] args) {
        // Counting the number of nodes
        Node root = null;

        int count = TreeTraverse.countNode(root);
        TreeTraverse.findMissing(root, 0, count);
    }

}
