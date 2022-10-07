package pratice.book.karumanchi.chapter6Tree.binaryTree;

public class TreeNode {
    public int data;
    public TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void print() {
        print(this);
    }

    private void print(TreeNode root) {
        if(root == null) return;
        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }
}
