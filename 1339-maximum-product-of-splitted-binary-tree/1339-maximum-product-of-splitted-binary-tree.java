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
    int mod = 1000000007;
    int total;
    int max;
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        if (total != -1) {
            max = Math.max(max, (((total - sum) % mod) * (sum % mod)) % mod);
        }
        return sum;
    }

    public int maxProduct(TreeNode root) {
        total = -1;
        total = dfs(root);
        dfs(root);
        return max;
    }
}