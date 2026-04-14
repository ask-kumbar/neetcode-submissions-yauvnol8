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
    public List<Integer> postorderTraversal(TreeNode root) {
        java.util.Stack<TreeNode> stack = new Stack<>();
        java.util.List<Integer> list = new ArrayList<>();
        TreeNode currentNode = root;
        TreeNode lastVisited = null;
        while (!(stack.isEmpty() && currentNode == null)){

            if ( currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else {
                TreeNode peek = stack.peek();
                if (peek.right != null && peek.right != lastVisited) {
                    currentNode = peek.right;
                }
                else {
                    stack.pop();
                    list.add(peek.val);
                    lastVisited = peek;
                }
            }

        }      
        return list;
    }
}