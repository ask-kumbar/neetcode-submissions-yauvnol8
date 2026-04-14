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
    boolean isBalance;
    public boolean isBalanced(TreeNode root) {
       isBalance = true;
       checkBalance(root);
       return isBalance;
    }

    public int checkBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightl = checkBalance(root.left);
        int heightr = checkBalance(root.right);
        if (Math.abs(heightl - heightr) > 1) {
            isBalance = false;
        }
        return Math.max(heightl, heightr) + 1;
    }
}
