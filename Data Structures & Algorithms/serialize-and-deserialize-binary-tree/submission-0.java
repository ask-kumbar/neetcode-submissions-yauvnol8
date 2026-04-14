/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    String data = "";
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializeBT(root);
        return data;
    }

    public void serializeBT(TreeNode root) {
        if (root == null) {
            data = data + "N,";
            return;
        }

        data = data + root.val + ",";
        serializeBT(root.left);
        serializeBT(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return deserializeBT(data.split(","));
    }

    public TreeNode deserializeBT(String[] data) {
        if (index == data.length || data[index].equals("N")) {
            index = index + 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data[index]));
        index = index + 1;
        node.left = deserializeBT(data);
        node.right = deserializeBT(data);
        return node;
    }
}
