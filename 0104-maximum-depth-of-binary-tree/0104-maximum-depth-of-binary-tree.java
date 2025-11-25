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
    int max = 0;
    private void helper(int i, TreeNode root) {
        if (root == null) {
            max = Math.max(max, i);
            return;
        }
        helper(i + 1, root.left);
        helper(i + 1, root.right);
    }

    public int maxDepth(TreeNode root) {
        helper(0, root);
        return max;
    }
}