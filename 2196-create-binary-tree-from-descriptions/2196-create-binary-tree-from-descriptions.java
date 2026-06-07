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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        Map<Integer, TreeNode> nodes = new HashMap<>();
        int root = 0;

        for (int description[] : descriptions) {
            int u = description[0], v = description[1];
            if (!nodes.containsKey(u)) {
                nodes.put(u, new TreeNode(u));
                root ^= u;
            }
            if (!nodes.containsKey(v)) {
                nodes.put(v, new TreeNode(v));
                root ^= v;
            }
            if (description[2] == 1) nodes.get(u).left = nodes.get(v);
            else nodes.get(u).right = nodes.get(v);
            root ^= v;
        }

        return nodes.get(root);
    }
}