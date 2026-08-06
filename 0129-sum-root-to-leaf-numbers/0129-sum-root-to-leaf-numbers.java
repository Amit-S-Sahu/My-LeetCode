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
    private int sum = 0;

    private void dfs(TreeNode node, int curr) {
        if (node == null) return;
        curr *= 10;
        curr += node.val;
        if (node.left == null && node.right == null) {
            sum += curr;
            return;
        }
        dfs(node.left, curr);
        dfs(node.right, curr);
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}