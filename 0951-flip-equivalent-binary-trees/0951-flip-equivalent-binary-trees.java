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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null || root1.val != root2.val) return false;

        Set<List<Integer>> set = new HashSet<>();
        Set<List<Integer>> visited = new HashSet<>();
        
        getPath(root1, new ArrayList<>(), set);
        
        if (!checkPath(root2, new ArrayList<>(), set, visited)) {
            return false;
        }
        
        return set.equals(visited);
    }
    
    private void getPath(TreeNode node, List<Integer> currPath, Set<List<Integer>> paths) {
        if (node == null) return;

        currPath.add(node.val);
        
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(currPath));
        } else {
            getPath(node.left, currPath, paths);
            getPath(node.right, currPath, paths);
        }
        
        currPath.remove(currPath.size() - 1);
    }

    private boolean checkPath(TreeNode node, List<Integer> currPath, Set<List<Integer>> set, Set<List<Integer>> visited) {
        if (node == null) return true;

        currPath.add(node.val);
        
        if (node.left == null && node.right == null) {
            List<Integer> path = new ArrayList<>(currPath);
            if (!set.contains(path)) return false;
            visited.add(path);
        } 
        else {
            boolean left = checkPath(node.left, currPath, set, visited);
            boolean right = checkPath(node.right, currPath, set, visited);
            if (!left || !right) return false;
        }
        
        currPath.remove(currPath.size() - 1);
        return true;
    }
}
