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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxSum(root.left);
        int right = maxSum(root.right);

        int val = Math.max(left, right);
        int returnVal = Math.max(root.val + val, root.val);
        if (val <= 0) {
            max = Math.max(max, root.val);
        }
        else {
            max = Math.max(max, Math.max(root.val + left + right, Math.max(root.val + val,val))) ;
        }
        return returnVal;

    }
}
