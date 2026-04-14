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

class Solution {
    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterBinaryTree(root);
        return this.max;
    }
    
    public int diameterBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterBinaryTree(root.left);
        int right = diameterBinaryTree(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

}
