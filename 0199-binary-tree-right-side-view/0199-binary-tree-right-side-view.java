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
    class Node {
        TreeNode node;
        int level;

        public Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(root, 0));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (q.isEmpty() || q.peek().level != curr.level) ans.add(curr.node.val);
            if (curr.node.left != null) q.add(new Node(curr.node.left, curr.level + 1));
            if (curr.node.right != null) q.add(new Node(curr.node.right, curr.level + 1));
        }
        return ans;
    }
}