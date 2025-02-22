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
    public TreeNode recoverFromPreorder(String s) {
        List<int[]> vp = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int depth = 0;
            while (i < s.length() && s.charAt(i) == '-') {
                depth++;
                i++;
            }
            int num = 0;
            while (i < s.length() && s.charAt(i) != '-') {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            vp.add(new int[]{depth, num});
        }

        Stack<Pair<Integer, TreeNode>> st = new Stack<>();
        TreeNode root = null;
        
        for (int it[] : vp) {
            int depth = it[0];
            int nodeVal = it[1];
            TreeNode node = new TreeNode(nodeVal);

            while (!st.isEmpty() && st.peek().getKey() >= depth) {
                st.pop();
            }

            if (!st.isEmpty()) {
                TreeNode parent = st.peek().getValue();
                if (parent.left == null) parent.left = node;
                else parent.right = node;
            } 
            else root = node;

            st.push(new Pair<>(depth, node));
        }
        
        return root;
    }
}