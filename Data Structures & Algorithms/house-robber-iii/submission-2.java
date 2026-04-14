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
    public int rob(TreeNode root) {
        int[] val = robHouses(root);
        return Math.max(val[1], val[0]);
    }

    public int[] robHouses(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left;
        //left = rob(root.left.left) + rob(root.left.right);
        left = robHouses(root.left);
             
        
        int[] right;
            //right = rob(root.right.left) + rob(root.right.right);
        right = robHouses(root.right);
        

        return new int[]{left[1] + right[1] + root.val, Math.max(left[0], left[1]) + Math.max(right[0], right[1])};

    }
    }