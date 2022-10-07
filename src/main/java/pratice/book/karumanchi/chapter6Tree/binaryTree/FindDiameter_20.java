package pratice.book.karumanchi.chapter6Tree.binaryTree;

public class FindDiameter_20 {
    private static int diameter = 0;

    private static int findLongestDiameter(TreeNode root) {
        if (root == null) return 0;
        int left = findLongestDiameter(root.left);
        int right = findLongestDiameter(root.right);

        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(17);
        root.left.left.left = new TreeNode(13);
        root.left.left.left.left = new TreeNode(1);

        root.right = new TreeNode(11);
        root.right.left = new TreeNode(51);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);
        root.right.left.left.left = new TreeNode(11);

        findLongestDiameter(root);
        System.out.println(diameter);
    }

}
