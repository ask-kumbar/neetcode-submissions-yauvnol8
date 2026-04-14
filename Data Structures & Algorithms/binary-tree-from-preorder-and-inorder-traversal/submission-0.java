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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
           return buildBT(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildBT(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if ( preorderStart <= preorderEnd && inorderStart <= inorderEnd) {
            TreeNode node = new TreeNode(preorder[preorderStart]);
            int offset = 0;
            for (int i = inorderStart; i <= inorderEnd; i++) {
                if (inorder[i] == preorder[preorderStart]) {
                    offset = i;
                    break;
                }
            }
            node.left = buildBT(preorder, preorderStart + 1, preorderStart + offset - inorderStart, inorder, inorderStart, offset - 1);
            node.right = buildBT(preorder, preorderStart + offset - inorderStart + 1, preorderEnd, inorder, offset + 1, inorderEnd);
            return node;
        }
        return null;
    }
    
}
