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
    int  i = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int val = kthSmallest(root.left, k);
        if (val != 0) {
            return val;
        }
        i = i + 1;
        if (k == i) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }
}
