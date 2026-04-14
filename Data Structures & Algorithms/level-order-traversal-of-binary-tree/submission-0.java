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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        if (root == null) {
            return result;
        }

        queue.offer(root);
        queue.offer(null);
        List<Integer> level = new ArrayList<>();
            
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                result.add(level);
                level = new ArrayList<>();
                if (queue.peek() != null) {
                    queue.offer(null);
                }
            }
        }

        return result;

    }
}
