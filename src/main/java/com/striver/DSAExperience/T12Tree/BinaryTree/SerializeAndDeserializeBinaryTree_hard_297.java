package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;

class Codec {

    public String serialize(TreeNode root) {
        return null;
    }

    public TreeNode deserialize(String data) {
        return null;
    }
}

public class SerializeAndDeserializeBinaryTree_hard_297 {
    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode root = TreeNode.toTree(new Integer[]{1, 2, 3, null, null, 4, 5});

        String out = c.serialize(root);
        System.out.println(out);

        Out.print(c.deserialize(out));
    }
}
