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
    private int maxDiameter = 0;
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        maxDiameter = Math.max(maxDepth(node.left) + maxDepth(node.right), maxDiameter);
        return Math.max(maxDepth(node.left) + 1, maxDepth(node.right) + 1);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = this.maxDiameter;
        maxDepth(root);
        return maxDiameter;
    }
}
