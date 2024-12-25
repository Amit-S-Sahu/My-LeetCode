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
    private List<Integer> ans;
    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);

        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;

        int val = root.val;

        if (ans.size() == level) ans.add(val);
        else ans.set(level, Math.max(ans.get(level), val));
        
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}