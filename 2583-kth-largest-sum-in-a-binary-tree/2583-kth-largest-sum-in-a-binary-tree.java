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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return 0L;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); 
            ArrayList<Integer> curr = new ArrayList<>(); 
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                curr.add(node.val); 
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(curr); 
        }

        ArrayList<Long> levelSums = new ArrayList<>();
        for (ArrayList<Integer> level : list) {
            long sum = 0L;
            for (int val : level) {
                sum += val;
            }
            levelSums.add(sum);
        }
        levelSums.sort((a, b) -> Long.compare(b, a)); 

        return k <= levelSums.size() ? levelSums.get(k - 1) : -1L;
    }
}
