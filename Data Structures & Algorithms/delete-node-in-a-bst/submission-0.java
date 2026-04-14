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
    public TreeNode deleteNode(TreeNode root, int key) {
        if ( root != null) {
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }
            else if ( root.val < key) {
                root.right = deleteNode(root.right, key);
            }
            else {
                if (root.left != null && root.right != null) {
                    TreeNode temp = findMax(root.left);
                    root.val = temp.val;
                    root.left = deleteNode(root.left, root.val);
                }
                else {
                    if (root.left == null) {
                        root = root.right;
                    }
                    else if (root.right == null) {
                        root = root.left;
                    }
                    else {
                        root = null;
                    }
                }
            }
        }
        return root;
        }

        public TreeNode findMax(TreeNode root) {
        if (root == null || root.right == null) {
            return root;
        }
        return findMax(root.right);
        }
    }