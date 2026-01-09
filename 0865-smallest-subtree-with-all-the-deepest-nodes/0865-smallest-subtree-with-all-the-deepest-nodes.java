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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
		if (root == null) return root;
       
        q.add(root);
        Map<TreeNode, TreeNode> map = new HashMap<>();
        
        while (!q.isEmpty()) {
            Deque<TreeNode> tempQ = new ArrayDeque<>();
            for(TreeNode t : q) {                
                if (t.left != null) {
                    tempQ.add(t.left);
                    map.put(t.left, t);
                }

                if (t.right != null) {
                    tempQ.add(t.right);
                    map.put(t.right, t);
                }
            }
            if (tempQ.size() == 0) break;
            else q = tempQ;
        }
        
        return helper(q, map);
    }
    
    private TreeNode helper(Deque<TreeNode> q,  Map<TreeNode, TreeNode> map) {
         while (!q.isEmpty()) {
            if (q.size() == 1) return q.poll();
            
            Deque<TreeNode> tempQ = new ArrayDeque<>();
            for (TreeNode t : q) {
                if (!tempQ.contains(map.get(t))) tempQ.add(map.get(t));
            }
            q = tempQ;
        }
        return null;
    }
}