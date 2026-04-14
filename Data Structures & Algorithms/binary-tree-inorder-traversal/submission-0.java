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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        java.util.List<Integer> list = new ArrayList<>();

        if (root !=null){
            stack.push(root);
            TreeNode currentNode = root.left;
            boolean done = false;
            while (!(stack.isEmpty() && currentNode == null)) {
                if (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;

                }
                else {
                    currentNode = stack.pop();
                    list.add(currentNode.val);
                    currentNode = currentNode.right;
                }
            }

        }
        return list;
    }
}