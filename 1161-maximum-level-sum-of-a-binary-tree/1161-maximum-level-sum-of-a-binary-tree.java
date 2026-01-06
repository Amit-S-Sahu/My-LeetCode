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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int max = Integer.MIN_VALUE, ans = -1;
        int level = 1;
        while (!q.isEmpty()) {
            int currSum = 0;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.pop();
                currSum += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            if (currSum > max) {
                max = currSum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}