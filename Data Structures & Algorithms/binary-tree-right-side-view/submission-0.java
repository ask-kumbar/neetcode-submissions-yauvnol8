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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        queue.offer(null);
        TreeNode prev = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null){
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            else {
                if (prev != null) {
                    list.add(prev.val);
                }
                if (queue.peek() != null) {
                    queue.offer(null);
                }
            }
            prev = node;
        }

        return list;
    }
}
